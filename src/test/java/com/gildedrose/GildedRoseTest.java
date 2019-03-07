package com.gildedrose;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.gildedrose.GildedRose.*;
import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class GildedRoseTest {

    private final static String FOO = "Foo";

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                //Foo (Standard) decreases quality by two once sell by day is zero or less
                {new Item(FOO, 0, 4), -1, 2},

                //Foo (Standard) decreases quality by one if sell by day is above zero
                {new Item(FOO, 4, 2), 3, 1},

                //Quality cannot go under zero
                {new Item(FOO, 1, 0), 0, 0},

                //Quality cannot go above fifty
                {new Item(AGED_BRIE, 1, 50), 0, 50},

                //Aged brie increase quality by one each day
                {new Item(AGED_BRIE, 1, 1), 0, 2},

                //Backstage passes item decreases quality by one if sell by day more than eleven
                {new Item(BACKSTAGE_PASSES, 14, 1), 13, 2},

                //Backstage passes increases quality by two if sell by day is more than six
                {new Item(BACKSTAGE_PASSES, 10, 1), 9, 3},

                //Backstage passes increases quality by three if sell by day is more than zero
                {new Item(BACKSTAGE_PASSES, 5, 1), 4, 4},

                //Backstage passes quality drops to zero if sell by day is zero or less
                {new Item(BACKSTAGE_PASSES, 0, 50), -1, 0},

                //Backstage passes quality cannot go above fifty when increasing
                {new Item(BACKSTAGE_PASSES, 5, 49), 4, 50},

                //Backstage passes item keep quality to zero if sell by day less than zero
                {new Item(BACKSTAGE_PASSES, -1, 4), -2, 0},

                //Sulfuras has quality eighty and stays at eighty
                {new Item(SULFURAS, 0, 80), 0, 80},

        };
    }

    @Test
    @UseDataProvider("data")
    public void should_update_quality_and_sellIn(Item item, int expectedSellIn, int expectedQuality) {
        //Given
        GildedRose app = from(item);

        //When
        app.updateQuality();

        //Then
        assertSellIn(app, expectedSellIn);
        assertQuality(app, expectedQuality);
    }

    private GildedRose from(Item item) {
        Item[] items = new Item[]{item};
        return new GildedRose(items);
    }

    private static void assertQuality(GildedRose app, int expected) {
        String message = String.format("Quality was expected to be %s but actual is %s for item '%s'",
                expected, app.items[0].quality, app.items[0].name);
        assertEquals(message, expected, app.items[0].quality);
    }

    private static void assertSellIn(GildedRose app, int expected) {
        String message = String.format("SellIn was expected to be %s but actual is %s for item '%s'",
                expected, app.items[0].sellIn, app.items[0].name);
        assertEquals(message, expected, app.items[0].sellIn);
    }
}