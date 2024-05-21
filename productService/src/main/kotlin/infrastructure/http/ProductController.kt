package infrastructure.http

import application.ProductCreator
import application.ProductFinder
import domain.Uuid
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.Response

@Path("/product")
class ProductController @Inject constructor(private val productFinder: ProductFinder, private val productCreator: ProductCreator) {

    @GET
    @Produces("application/json")
    fun getAll() : Response {
        try {
            val products = productFinder.findAll()
                .map(ProductControllerMapper::toControllerDTO)
            return Response.ok(products).build()
        } catch (e: Exception) {
            return Response.serverError().entity(e.message).build()
        }
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    fun getById(@PathParam("id") id: String) : Response {
        try {
            val product = productFinder.findById(Uuid(id))?.let { ProductControllerMapper.toControllerDTO(it) }
            return Response.ok(product).build()
        } catch (e: Exception) {
            return Response.serverError().entity(e.message).build()
        }
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    fun create(productDTO: ProductControllerDTO) : Response {
        try {
            val product = ProductControllerMapper.toDomain(productDTO)
            val resultDTO = ProductControllerMapper.toControllerDTO(productCreator.create(product))
            return Response.ok(resultDTO).build()
        } catch (e: Exception) {
            return Response.serverError().entity(e.message).build()
        }
    }

}