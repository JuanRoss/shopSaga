package infrastructure.http

data class ProductControllerDTO(val id: String?, val name: String, val description: String?, val price: Double, val stockQuantity: Int)
