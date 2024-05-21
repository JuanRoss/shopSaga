package application

import domain.Product
import domain.ProductRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class ProductCreator @Inject constructor(private val productRepository: ProductRepository) {
    fun create(product: Product) = productRepository.save(product)
}