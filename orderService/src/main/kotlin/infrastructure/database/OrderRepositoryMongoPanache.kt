package infrastructure.database

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase
import jakarta.enterprise.context.ApplicationScoped
import java.util.UUID

@ApplicationScoped
class OrderRepositoryMongoPanache: PanacheMongoRepositoryBase<OrderMongoEntity, UUID>
