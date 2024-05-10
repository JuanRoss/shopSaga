package domain

data class Product(val productId: Uuid, var name: String, var price: Double, var stock: Int)
