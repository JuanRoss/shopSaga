package infrastructure.bus

import infrastructure.RabbitMqEventBus
import jakarta.enterprise.inject.Produces
import jakarta.inject.Singleton

@Singleton
class RabbitMqEventBusProducer {

    @Produces
    @Singleton
    fun produceRabbitMqOrderEventBus(): RabbitMqEventBus {
        return RabbitMqEventBus()
    }
}