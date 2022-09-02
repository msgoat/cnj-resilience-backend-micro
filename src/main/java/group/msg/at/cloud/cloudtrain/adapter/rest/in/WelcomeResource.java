package group.msg.at.cloud.cloudtrain.adapter.rest.in;

import group.msg.at.cloud.cloudtrain.core.boundary.Welcome;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * REST endpoint returning welcome messages.
 * <p>
 * Handles only the mapping of a REST invocation to a Java method invocation;
 * all transactional business logic is encapsulated in a {@code Boundary} this resource class delegates to.
 * </p>
 * <p>
 * Please note that JAX-RS {@code Resource} classes must be {@code @RequestScoped} according to the JAX-RS 2.1 spec in
 * order for JAX-RS to work properly with CDI.
 * </p>
 */
@RequestScoped
@Path("v1/welcome")
public class WelcomeResource {

    @Inject
    private Welcome boundary;

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWelcomeItems(@PathParam("userId") String userId) {
        return Response.ok(boundary.collectWelcomeItems(userId)).build();
    }

    @GET
    @Path("resilient/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWelcomeItemsWithResilience(@PathParam("userId") String userId) {
        return Response.ok(boundary.collectWelcomeItemsWithResilience(userId)).build();
    }
}
