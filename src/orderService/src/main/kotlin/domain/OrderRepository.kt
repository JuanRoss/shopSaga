package domain

interface OrderRepository {
    fun save(order: Order) : Order
    fun findById(id: String) : Order?
    fun findAll() : List<Order>
}