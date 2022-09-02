package group.msg.at.cloud.cloudtrain.adapter.rest.out.recommendations;

import group.msg.at.cloud.cloudtrain.core.entity.RecommendedItem;
import group.msg.at.cloud.common.observability.rest.trace.RestTraceClientRequestFilter;
import group.msg.at.cloud.common.observability.rest.trace.RestTraceClientResponseFilter;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "cloudtrain.services.recommendations")
//@RegisterProvider(JwtPropagatingClientRequestFilter.class)
@RegisterProvider(RestTraceClientRequestFilter.class)
@RegisterProvider(RestTraceClientResponseFilter.class)
@Path("api/v1/recommendations")
public interface RecommendationsClient {

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    List<RecommendedItem> getRecommendations(@PathParam("userId") String userId);
}
