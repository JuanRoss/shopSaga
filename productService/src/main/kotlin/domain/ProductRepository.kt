package domain

interface ProductRepository {
    fun save(product: Product)
    fun findById(productId: Uuid): Product?
    fun findAll(): List<Product>
    fun delete(productId: Uuid)
}