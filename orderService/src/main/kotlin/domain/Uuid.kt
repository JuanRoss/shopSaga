package domain

import java.util.UUID

data class Uuid(val value: UUID) {
    constructor(value: String) : this(UUID.fromString(value))
    constructor() : this(UUID.randomUUID())
}
