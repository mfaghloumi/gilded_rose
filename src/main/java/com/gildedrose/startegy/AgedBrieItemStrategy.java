package com.gildedrose.startegy;

import com.gildedrose.Item;

public class AgedBrieItemStrategy implements ItemStrategy {

    public void update(Item item) {
        item.sellIn -= 1;
        item.quality += 1;
        if (item.sellIn < 0) {
            item.quality += 1;
        }
        resetQualityIfNeeded(item);
    }

}
