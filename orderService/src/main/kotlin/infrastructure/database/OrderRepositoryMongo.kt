package infrastructure.database

import domain.Order
import domain.OrderRepository
import domain.Uuid
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class OrderRepositoryMongo @Inject constructor(
    private val orderRepositoryMongoPanache: OrderRepositoryMongoPanache
) : OrderRepository {

    override fun save(order: Order) : Order {
        val orderMongoEntity = OrderDatabaseMapper.toMongoEntity(order)
        orderRepositoryMongoPanache.persist(orderMongoEntity)
        return OrderDatabaseMapper.toDomain(orderMongoEntity)
    }

    override fun findById(id: String) : Order? {
        val orderMongoEntity = orderRepositoryMongoPanache.findById(Uuid(id).value)
        return orderMongoEntity?.let { OrderDatabaseMapper.toDomain(it) }
    }

    override fun findAll() : List<Order> {
        val orders = orderRepositoryMongoPanache.findAll()
        return orders.list<OrderMongoEntity>()
            .map { OrderDatabaseMapper.toDomain(it) }
    }
}