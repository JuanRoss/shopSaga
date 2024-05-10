package infrastructure

import com.google.gson.Gson
import domain.DomainEvent
import domain.EventBus
import org.eclipse.microprofile.reactive.messaging.Emitter
import java.util.logging.Logger

class RabbitMqEventBus(val eventsEmitter:Emitter<String>) : EventBus {

    private val log: Logger = Logger.getLogger(this::class.java.name)

    override fun publish(domainEvent: DomainEvent) {
        val gson = Gson()
        val jsonDomainEvent = gson.toJson(domainEvent)
        log.info("Publishing event: $jsonDomainEvent")
        eventsEmitter.send(jsonDomainEvent)
        log.info("Event published: $jsonDomainEvent")
    }
}