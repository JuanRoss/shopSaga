package domain

data class Order(val id: Uuid? = Uuid(), val items: List<OrderItem>, val clientId : Long, val status: OrderStatus = OrderStatus.PENDING_PAYMENT)
