package group.msg.at.cloud.cloudtrain.core.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class WatchedItem {

    private UUID itemId;

    private String itemName;

    private LocalDateTime watchedAt;

    public WatchedItem() {

    }

    public WatchedItem(UUID itemId, String itemName, LocalDateTime lastWatchedAt) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.watchedAt = lastWatchedAt;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public LocalDateTime getWatchedAt() {
        return watchedAt;
    }

    public void setWatchedAt(LocalDateTime watchedAt) {
        this.watchedAt = watchedAt;
    }
}
