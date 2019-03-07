package com.gildedrose.startegy;

import com.gildedrose.Item;

public interface ItemStrategy {

    void update(Item item);

    default int maxQuality() {
        return 50;
    }

    default int minQuality() {
        return 0;
    }

    default void resetQualityIfNeeded(Item item) {
        if (item.quality > maxQuality()) {
            item.quality = maxQuality();
        }
        if (item.quality < minQuality()) {
            item.quality = minQuality();
        }
    }
}
