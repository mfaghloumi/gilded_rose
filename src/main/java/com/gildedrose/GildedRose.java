package com.gildedrose;

import com.gildedrose.startegy.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class GildedRose {

    final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    final static String AGED_BRIE = "Aged Brie";
    final static String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private static Map<String, ItemStrategy> strategies = new HashMap<>();

    private static ItemStrategy defaultStrategy = new StandardItemStrategy();

    Item[] items;

    static {
        strategies.put(AGED_BRIE, new AgedBrieItemStrategy());
        strategies.put(SULFURAS, new SulfurasItemStrategy());
        strategies.put(BACKSTAGE_PASSES, new BackstagePassesItemStrategy());
    }

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        Arrays.stream(items)
                .forEach(item -> strategies.getOrDefault(item.name, defaultStrategy).update(item));
    }

}