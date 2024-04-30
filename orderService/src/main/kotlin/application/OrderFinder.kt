package application

import domain.OrderRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class OrderFinder @Inject constructor(private val orderRepository: OrderRepository) {
    fun findById(id: String) = orderRepository.findById(id)
    fun findAll() = orderRepository.findAll()
}