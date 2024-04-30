package infrastructure.http

import domain.order.OrderItem


data class OrderControllerDTO(val id: String?, val items: List<OrderItem>, val clientId: Long, val status: String?)
