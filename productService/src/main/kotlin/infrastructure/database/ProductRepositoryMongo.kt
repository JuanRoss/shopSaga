package infrastructure.database

import domain.Product
import domain.ProductRepository
import domain.Uuid
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class ProductRepositoryMongo @Inject constructor(private val productRepositoryMongoPanache: ProductRepositoryMongoPanache) : ProductRepository {

    override fun findById(id: Uuid): Product? {
        val mongoEntity = productRepositoryMongoPanache.findById(id.value)
        return ProductDatabaseMapper.toDomain(mongoEntity)
    }

    override fun findAll(): List<Product> {
        val products = productRepositoryMongoPanache.findAll()
        return products.list<ProductMongoEntity>()
            .map { ProductDatabaseMapper.toDomain(it) }
    }

    override fun save(product: Product): Product {
        val mongoEntity = ProductDatabaseMapper.toMongoEntity(product)
        productRepositoryMongoPanache.persist(mongoEntity)
        return ProductDatabaseMapper.toDomain(mongoEntity)
    }

    override fun deleteById(id: Uuid) {
        productRepositoryMongoPanache.deleteById(id.value)
    }

}