package infrastructure.database

import domain.Order

import domain.OrderStatus
import domain.Uuid
import domain.order.OrderItem
import java.util.*

class OrderDatabaseMapper {

    companion object {
        fun toMongoEntity(order: Order) : OrderMongoEntity {
            return OrderMongoEntity(
                id = if (order.id != null) UUID.fromString(order.id.value.toString()) else null,
                items = order.items.map{ item -> OrderItemMongoEntity(productId = item.productId, quantity = item.quantity)},
                clientId = order.clientId,
                status = order.status.name
            )
        }

        fun toDomain(orderMongoEntity: OrderMongoEntity) : Order {
            val id1 = orderMongoEntity.id
            return Order(
                id = if (id1 != null) Uuid(id1.toString()) else null,
                items = orderMongoEntity.items.map { item -> OrderItem(productId = item.productId, quantity = item.quantity) },
                clientId = orderMongoEntity.clientId,
                status = OrderStatus.valueOf(orderMongoEntity.status)
            )
        }
    }
}