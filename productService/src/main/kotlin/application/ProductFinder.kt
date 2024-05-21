package application

import domain.ProductRepository
import domain.Uuid
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class ProductFinder @Inject constructor(private val productRepository: ProductRepository) {
    fun findAll() = productRepository.findAll()
    fun findById(id: Uuid) = productRepository.findById(id)
}