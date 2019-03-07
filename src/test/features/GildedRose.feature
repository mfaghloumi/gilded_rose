Feature: Gilded Rose

  Scenario: Quality update

    Given the following stock state

      | name                                      | sellIn | quality |
      | +5 Dexterity Vest                         | 10     | 20      |
      | Aged Brie                                 | 2      | 0       |
      | Elixir of the Mongoose                    | 5      | 7       |
      | Sulfuras, Hand of Ragnaros                | 0      | 80      |
      | Sulfuras, Hand of Ragnaros                | -1     | 80      |
      | Backstage passes to a TAFKAL80ETC concert | 15     | 20      |
      | Backstage passes to a TAFKAL80ETC concert | 10     | 49      |
      | Backstage passes to a TAFKAL80ETC concert | 5      | 49      |

    When 1 days have passed

    Then the stock state should be the following

      | name                                      | sellIn | quality |
      | +5 Dexterity Vest                         | 9      | 19      |
      | Aged Brie                                 | 1      | 1       |
      | Elixir of the Mongoose                    | 4      | 6       |
      | Sulfuras, Hand of Ragnaros                | 0      | 80      |
      | Sulfuras, Hand of Ragnaros                | -1     | 80      |
      | Backstage passes to a TAFKAL80ETC concert | 14     | 21      |
      | Backstage passes to a TAFKAL80ETC concert | 9      | 50      |
      | Backstage passes to a TAFKAL80ETC concert | 4      | 50      |