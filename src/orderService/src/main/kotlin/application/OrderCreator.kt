package application

import domain.Order
import domain.OrderRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class OrderCreator @Inject constructor(private val orderRepository: OrderRepository){

    fun create(order: Order) : Order {
        return orderRepository.save(order)
    }
}