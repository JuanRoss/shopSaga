package infrastructure.bus

import infrastructure.RabbitMqEventBus
import jakarta.enterprise.inject.Produces
import jakarta.inject.Singleton
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter

@Singleton
class RabbitMqEventBusProducer {

    @Channel("order-events")
    lateinit var eventsEmitter: Emitter<String>

    @Produces
    @Singleton
    fun produceRabbitMqOrderEventBus(): RabbitMqEventBus {
        return RabbitMqEventBus(eventsEmitter)
    }
}