package domain.exceptions

class InsufficientStockException: Exception {

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)

}