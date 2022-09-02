package group.msg.at.cloud.cloudtrain.core.control;

import group.msg.at.cloud.cloudtrain.adapter.rest.out.recommendations.RecommendationsClient;
import group.msg.at.cloud.cloudtrain.core.entity.RecommendedItem;
import group.msg.at.cloud.cloudtrain.core.entity.WelcomeItems;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Dependent
public class ResilientRecommendationsCollector {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResilientRecommendationsCollector.class);

    @Inject
    @RestClient
    RecommendationsClient client;

    @Fallback(fallbackMethod = "collectAfterFailure")
    public void collect(WelcomeItems target, String userId) {
        LOGGER.info("retrieving recommendations...");
        List<RecommendedItem> recommendations = client.getRecommendations(userId);
        target.setRecommendations(recommendations);
        LOGGER.info("... succeeded to retrieve recommendations...");
    }

    public void collectAfterFailure(WelcomeItems target, String userId) {
        LOGGER.info("...failed to retrieve recommendations");
        target.addStatusMessage("recommendations are temporarily unavailable!");
    }
}
