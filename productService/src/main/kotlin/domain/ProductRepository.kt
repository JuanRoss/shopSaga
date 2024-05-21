package domain

interface ProductRepository {
    fun save(product: Product): Product
    fun findById(id: Uuid): Product?
    fun findAll(): List<Product>
    fun deleteById(id: Uuid)
}