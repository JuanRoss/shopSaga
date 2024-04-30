package infrastructure.http

import application.OrderCreator
import application.OrderFinder
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.Response

@Path("/order")
class OrderController @Inject constructor(private val orderCreator: OrderCreator, private val orderFinder: OrderFinder) {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    fun create(orderDTO: OrderControllerDTO) : Response {
        try {
            val order = OrderControllerMapper.toDomain(orderDTO)
            val resultDTO = OrderControllerMapper.toControllerDTO(orderCreator.create(order))
            return Response.ok(resultDTO).build()
        } catch (e: Exception) {
            return Response.serverError().entity(e.message).build()
        }
    }

    @GET
    @Produces("application/json")
    fun getAll() : Response {
        try {
            val orders = orderFinder.findAll()
            return Response.ok(orders).build()
        } catch (e: Exception) {
            return Response.serverError().entity(e.message).build()
        }
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    fun getById(@PathParam("id") id: String) : Response {
        try {
            return Response.ok(orderFinder.findById(id)).build()
        } catch (e: Exception) {
            return Response.serverError().entity(e.message).build()
        }
    }
}