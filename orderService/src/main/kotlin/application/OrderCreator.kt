package application

import domain.EventBus
import domain.Order
import domain.OrderRepository
import domain.order.OrderCreatedDomainEvent
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@ApplicationScoped
class OrderCreator @Inject constructor(private val orderRepository: OrderRepository, private val eventBus: EventBus){

    @Transactional
    fun create(order: Order) : Order {
        eventBus.publish(OrderCreatedDomainEvent(order.id?.value.toString(), order.clientId, order.items))
        return orderRepository.save(order)
    }
}