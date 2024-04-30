package domain.order

import domain.DomainEvent

class OrderCreatedDomainEvent(
    aggregateId: String,
    val clientId: Long,
    val orderItems: List<OrderItem>
) : DomainEvent(aggregateId)