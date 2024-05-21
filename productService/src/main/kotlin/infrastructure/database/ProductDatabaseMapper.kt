package infrastructure.database

import domain.Product
import domain.Uuid
import java.util.*

class ProductDatabaseMapper {

    companion object {

        fun toDomain(productMongoEntity: ProductMongoEntity): Product {
            val id1 = productMongoEntity.id
            return Product(
                id = if (id1 != null) Uuid(id1.toString()) else null,
                name = productMongoEntity.name,
                description = productMongoEntity.description,
                price = productMongoEntity.price,
                stockQuantity = productMongoEntity.stockQuantity
            )
        }

        fun toMongoEntity(product: Product): ProductMongoEntity {
            return ProductMongoEntity(
                id = if (product.id != null) UUID.fromString(product.id.value.toString()) else null,
                name = product.name,
                description = product.description,
                price = product.price,
                stockQuantity = product.stockQuantity
            )
        }
    }
}