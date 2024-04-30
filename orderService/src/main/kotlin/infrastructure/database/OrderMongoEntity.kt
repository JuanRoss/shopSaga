package infrastructure.database

import io.quarkus.mongodb.panache.common.MongoEntity
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import java.util.*

@MongoEntity(collection = "orders")
data class OrderMongoEntity @BsonCreator constructor(
    @BsonId var id: UUID? = null,
    @BsonProperty("clientId") var clientId: Long,
    @BsonProperty("items") var items: List<OrderItemMongoEntity>,
    @BsonProperty("status") var status: String
)

data class OrderItemMongoEntity @BsonCreator constructor(
    @BsonProperty("productId") var productId: Long,
    @BsonProperty("quantity") var quantity: Int = 0
)

