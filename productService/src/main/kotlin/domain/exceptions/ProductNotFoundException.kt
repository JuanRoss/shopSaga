package domain.exceptions

class ProductNotFoundException : Exception  {

        constructor(message: String) : super(message)

        constructor(message: String, cause: Throwable) : super(message, cause)
}