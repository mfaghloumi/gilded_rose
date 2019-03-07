package com.gildedrose.cucumber;


import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GildedRoseStepDefs {

    private GildedRose gildedRose;

    @Given("the following stock state")
    public void the_stock_is(List<Item> items) {
        gildedRose = new GildedRose(items.toArray(new Item[0]));
    }

    @When("{int} days have passed")
    public void days_have_passed(int days) {
        for (int i = 0; i < days; i++) {
            gildedRose.updateQuality();
        }
    }

    @Then("the stock state should be the following")
    public void the_stock_state_should_be_the_following(List<Item> expectedItems) {
        assertEquals(gildedRose.getItems().length, expectedItems.size());
        for (int i = 0; i < expectedItems.size(); i++) {
            assertTrue("Issue with element : " + gildedRose.getItems()[i], equals(expectedItems.get(i), gildedRose.getItems()[i]));
        }
    }

    private boolean equals(Item expected, Item actual) {
        if (expected == actual) return true;
        return Objects.equals(expected.name, actual.name)
                && expected.sellIn == actual.sellIn
                && expected.quality == actual.quality;
    }

}