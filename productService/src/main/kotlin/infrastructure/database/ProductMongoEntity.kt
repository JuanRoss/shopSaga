package infrastructure.database

import io.quarkus.mongodb.panache.common.MongoEntity
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import java.util.*

@MongoEntity(collection = "products")
data class ProductMongoEntity @BsonCreator constructor(
    @BsonId var id: UUID? = null,
    @BsonProperty("name") var name: String,
    @BsonProperty("description") var description: String?,
    @BsonProperty("price") var price: Double,
    @BsonProperty("quantity") var stockQuantity: Int
)
