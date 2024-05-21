package infrastructure.bus

import application.OrderProductsProcessor
import com.google.gson.Gson
import domain.order.OrderCreatedDomainEvent
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.eclipse.microprofile.reactive.messaging.Incoming
import java.util.logging.Logger

@ApplicationScoped
class OrderCreatedProcessor @Inject constructor(private val orderProductsProcessor: OrderProductsProcessor) {

    private val log = Logger.getLogger(this::class.java.name)

    @Incoming("order-created-requests")
    fun processOrderCreatedEvent(event: String) {
        log.info("Order created event received: $event. Checking inventory of products...")
        //TODO: serialize event to OrderCreatedEvent
        val gson = Gson()
        val orderCreatedEvent = gson.fromJson(event, OrderCreatedDomainEvent::class.java)
        //orderProductsProcessor.process(orderCreatedEvent.orderItems)
        orderProductsProcessor.process(orderCreatedEvent.orderItems)
    }
}