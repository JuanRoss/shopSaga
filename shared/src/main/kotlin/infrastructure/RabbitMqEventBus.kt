package infrastructure

import domain.DomainEvent
import domain.EventBus

class RabbitMqEventBus : EventBus {
    override fun publish(domainEvent: DomainEvent) {
        //TODO implement RabbitMq logic
        println("Publishing event: $domainEvent")
    }
}