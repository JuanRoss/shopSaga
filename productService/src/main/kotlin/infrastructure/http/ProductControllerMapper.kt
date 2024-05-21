package infrastructure.http

import domain.Product
import domain.Uuid

class ProductControllerMapper {

    companion object {

            fun toDomain(productControllerDTO: ProductControllerDTO): Product {
                return Product(
                    id = if (productControllerDTO.id != null) Uuid(productControllerDTO.id) else null,
                    name = productControllerDTO.name,
                    description = productControllerDTO.description,
                    price = productControllerDTO.price,
                    stockQuantity = productControllerDTO.stockQuantity
                )
            }

            fun toControllerDTO(product: Product): ProductControllerDTO {
                return ProductControllerDTO(
                    id = product.id?.value.toString(),
                    name = product.name,
                    description = product.description,
                    price = product.price,
                    stockQuantity = product.stockQuantity
                )
            }
    }
}