package infrastructure.bus

import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.reactive.messaging.Incoming
import java.util.logging.Logger

@ApplicationScoped
class OrderCreatedProcessor {

    private val log = Logger.getLogger(this::class.java.name)

    @Incoming("order-created-requests")
    fun processOrderCreatedEvent(event: String) {
        log.info("Order created event received: $event. Checking inventory of products...")
    }
}