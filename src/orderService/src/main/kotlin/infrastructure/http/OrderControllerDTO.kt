package infrastructure.http

import domain.OrderItem

data class OrderControllerDTO(val id: String?, val items: List<OrderItem>, val clientId: Long, val status: String?)
