package infrastructure.http

import domain.Order
import domain.OrderStatus
import domain.Uuid

class OrderControllerMapper {

    companion object  {

        fun toDomain(orderControllerDTO: OrderControllerDTO): Order {
            return Order(
                id = if (orderControllerDTO.id != null) Uuid(orderControllerDTO.id) else Uuid(),
                items = orderControllerDTO.items,
                clientId = orderControllerDTO.clientId,
                status = orderControllerDTO.status?.let { OrderStatus.valueOf(it) } ?: OrderStatus.PENDING_PAYMENT
            )

        }

        fun toControllerDTO(order: Order) = OrderControllerDTO(
            id = order.id?.value.toString(),
            items = order.items,
            clientId = order.clientId,
            status = order.status.name
        )
    }
}