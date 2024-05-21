package application

import domain.ProductRepository
import domain.Uuid
import domain.exceptions.InsufficientStockException
import domain.exceptions.ProductNotFoundException
import domain.order.OrderItem
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import java.util.logging.Logger

@ApplicationScoped
class OrderProductsProcessor @Inject constructor(private val productRepository: ProductRepository) {

    private val log = Logger.getLogger(this::class.java.name)

    fun process(orderItems: List<OrderItem>) {
        log.info("Processing order items...")
        orderItems.forEach { item ->
            val product = productRepository.findById(Uuid(item.productId))
            product?.let {
                if (product.stockQuantity >= item.quantity) {
                    product.stockQuantity -= item.quantity
                    productRepository.save(product)
                } else {
                    log.warning("Insufficient stock for product ${product.name}")
                    throw InsufficientStockException("Insufficient stock for product ${product.name}")
                }
            } ?: throw ProductNotFoundException("Product not found")
        }
    }
}