package domain

interface EventBus {
    fun publish(domainEvent: DomainEvent)
}