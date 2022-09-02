package group.msg.at.cloud.cloudtrain.core.control;

import group.msg.at.cloud.cloudtrain.adapter.rest.out.watchlist.WatchListClient;
import group.msg.at.cloud.cloudtrain.core.entity.WatchedItem;
import group.msg.at.cloud.cloudtrain.core.entity.WelcomeItems;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Dependent
public class ResilientWatchListCollector {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResilientWatchListCollector.class);

    @Inject
    @RestClient
    WatchListClient client;

    @Timeout(value = 2L, unit = ChronoUnit.SECONDS)
    @Fallback(fallbackMethod = "collectAfterFailure")
    public void collect(WelcomeItems target, String userId) {
        LOGGER.info("retrieving watch list...");
        List<WatchedItem> watchList = client.getWatchedItems(userId);
        target.setWatchList(watchList);
        LOGGER.info("...succeeded to retrieve watch list");
    }

    public void collectAfterFailure(WelcomeItems target, String userId) {
        LOGGER.info("...failed to retrieve watch list");
        target.addStatusMessage("watch list is temporarily unavailable!");
    }

}
