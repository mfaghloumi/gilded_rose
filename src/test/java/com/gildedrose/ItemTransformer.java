package com.gildedrose;

import com.gildedrose.Item;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;
import java.util.Map;

public class ItemTransformer implements TypeRegistryConfigurer {
    public Locale locale() {
        return Locale.ENGLISH;
    }

    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(Item.class,
                        (Map<String, String> row) -> {
                            String name = row.get("name");
                            int sellIn = Integer.parseInt(row.get("sellIn"));
                            int quality = Integer.parseInt(row.get("quality"));
                            return new Item(name, sellIn, quality);
                        }
                )
        );
    }
}
