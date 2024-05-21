package domain

data class Product(val id: Uuid?, var name: String, var description: String?, var price: Double, var stockQuantity: Int)
