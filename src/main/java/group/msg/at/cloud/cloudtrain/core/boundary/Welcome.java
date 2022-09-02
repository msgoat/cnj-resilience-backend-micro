package group.msg.at.cloud.cloudtrain.core.boundary;

import group.msg.at.cloud.cloudtrain.core.control.RecommendationsCollector;
import group.msg.at.cloud.cloudtrain.core.control.ResilientRecommendationsCollector;
import group.msg.at.cloud.cloudtrain.core.control.ResilientWatchListCollector;
import group.msg.at.cloud.cloudtrain.core.control.WatchListCollector;
import group.msg.at.cloud.cloudtrain.core.entity.WelcomeItems;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

/**
 * Simple {@code Boundary} that returns welcome messages.
 */
@Stateless
public class Welcome {

    @Inject
    RecommendationsCollector recommendationsCollector;

    @Inject
    WatchListCollector watchListCollector;

    @Inject
    ResilientRecommendationsCollector resilientRecommendationsCollector;

    @Inject
    ResilientWatchListCollector resilientWatchListCollector;

    public WelcomeItems collectWelcomeItems(String userId) {
        WelcomeItems result = new WelcomeItems();
        recommendationsCollector.collect(result, userId);
        watchListCollector.collect(result, userId);
        return result;
    }

    public WelcomeItems collectWelcomeItemsWithResilience(String userId) {
        WelcomeItems result = new WelcomeItems();
        resilientRecommendationsCollector.collect(result, userId);
        resilientWatchListCollector.collect(result, userId);
        return result;
    }
}
