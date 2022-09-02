package group.msg.at.cloud.cloudtrain.core.control;

import group.msg.at.cloud.cloudtrain.adapter.rest.out.recommendations.RecommendationsClient;
import group.msg.at.cloud.cloudtrain.core.entity.RecommendedItem;
import group.msg.at.cloud.cloudtrain.core.entity.WelcomeItems;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Dependent
public class RecommendationsCollector {

    @Inject
    @RestClient
    RecommendationsClient client;

    public void collect(WelcomeItems target, String userId) {
        List<RecommendedItem> recommendations = client.getRecommendations(userId);
        target.setRecommendations(recommendations);
    }
}
