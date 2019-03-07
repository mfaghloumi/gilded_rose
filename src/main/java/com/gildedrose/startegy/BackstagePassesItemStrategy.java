package com.gildedrose.startegy;

import com.gildedrose.Item;

public class BackstagePassesItemStrategy implements ItemStrategy {

    public void update(Item item) {
        item.sellIn -= 1;
        if (item.sellIn > 10) {
            item.quality += 1;
        } else if (item.sellIn > 5) {
            item.quality += 2;
        } else if (item.sellIn > 0) {
            item.quality += 3;
        } else {
            item.quality = 0;
        }
        resetQualityIfNeeded(item);
    }

}
