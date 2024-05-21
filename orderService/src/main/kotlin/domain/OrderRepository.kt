package domain

interface OrderRepository {
    fun save(order: Order) : Order
    fun findById(id: Uuid) : Order?
    fun findAll() : List<Order>
}