package group.msg.at.cloud.cloudtrain.core.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class RecommendedItem {

    private UUID itemId;

    private String itemName;

    private BigDecimal weight;

    public RecommendedItem() {

    }

    public RecommendedItem(UUID itemId, String itemName, BigDecimal weight) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.weight = weight;
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

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
