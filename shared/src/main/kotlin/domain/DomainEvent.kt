package domain

import java.time.LocalDateTime
import java.util.UUID

open abstract class DomainEvent(
    val aggregateId: String,
    val eventId: String = UUID.randomUUID().toString(),
    val occurredAt: String = LocalDateTime.now().toString()) {

    constructor(aggregateId: String) :
            this(aggregateId, eventId = "eventId", occurredAt = "")

}
