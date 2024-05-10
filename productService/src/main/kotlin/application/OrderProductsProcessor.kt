package application

import domain.ProductRepository
import domain.Uuid
import domain.exceptions.InsufficientStockException
import domain.exceptions.ProductNotFoundException
import domain.order.OrderItem
import jakarta.inject.Inject

class OrderProductsProcessor @Inject constructor(private val productRepository: ProductRepository) {

    fun process(orderItems: List<OrderItem>) {
        orderItems.forEach { item ->
            val product = productRepository.findById(Uuid(item.productId))
            product?.let {
                if (product.stock >= item.quantity) {
                    product.stock -= item.quantity
                    productRepository.save(product)
                } else {
                    throw InsufficientStockException("Insufficient stock for product ${product.name}")
                }
            } ?: throw ProductNotFoundException("Product not found")
        }
    }
}