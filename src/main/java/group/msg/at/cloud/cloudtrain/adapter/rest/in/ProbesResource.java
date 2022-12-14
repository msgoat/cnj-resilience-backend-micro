package group.msg.at.cloud.cloudtrain.adapter.rest.in;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * REST endpoint exposing readiness and liveness probes which are required
 * when running in a {@code Kubernetes}-based container environment.
 * <p>
 * A {@code readiness} probe simply returns HTTP status code 200 as soon
 * as this application is ready to accept the first HTTP request.
 * </p>
 * <p>
 * A {@code liveness} probe returns HTTP status code 200 as long as
 * this application is considered to be healthy. More sophisticated
 * implementations may include more complex health checkpoints and
 * may return some health information in JSON format.
 * </p>
 * <p>
 * In CloudTrain we are using this custom JAX-RS/CDI-based probes implementation
 * instead of the MicroProfile Health API to make sure that CDI managed REST
 * resource classes are actually available before accessing them. Unfortunately,
 * the MicroProfile Health API reports a server to be up and running <strong>before</strong>
 * CDI is actually up.
 * </p>
 */
@RequestScoped
@Path("v1/probes")
@Produces(MediaType.TEXT_PLAIN)
public class ProbesResource {

    /**
     * Always returns an empty plain text response with HTTP status code 200.
     */
    @GET
    @Path("readiness")
    public Response checkReadiness() {
        return Response.ok().build();
    }

    /**
     * Always returns an empty plain text response with HTTP status code 200.
     */
    @GET
    @Path("liveness")
    public Response checkLiveness() {
        return Response.ok().build();
    }
}
