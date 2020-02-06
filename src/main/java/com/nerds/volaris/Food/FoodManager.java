package com.nerds.volaris.Food;

import com.nerds.volaris.Volaris;
import net.minecraft.item.*;

import java.util.ArrayList;
import java.util.List;

public class FoodManager {

    public static List<Item> init() {
        List<Item> volarisFoods = new ArrayList<>();

        Item burgerItem = new Item((new Item.Properties())
                .group(Volaris.volarisItemGroup)
                .food((new Food.Builder()).hunger(15).saturation(1.9F).build()))
                .setRegistryName(Volaris.ID, "burger");
        volarisFoods.add(burgerItem);

        Item chickenTaco = new Item((new Item.Properties())
                .group(Volaris.volarisItemGroup)
                .food((new Food.Builder().hunger(10).saturation(1.2F).build())))
                .setRegistryName(Volaris.ID, "chicken_taco");
        volarisFoods.add(chickenTaco);

        Item fishTaco = new Item((new Item.Properties())
                .group(Volaris.volarisItemGroup)
                .food((new Food.Builder().hunger(11).saturation(1.3F).build())))
                .setRegistryName(Volaris.ID, "fish_taco");
        volarisFoods.add(fishTaco);

        Item burgerMeal = new Item((new Item.Properties())
                .group(Volaris.volarisItemGroup)
                .food((new Food.Builder().hunger(18).saturation(2.1F).build())))
                .setRegistryName(Volaris.ID, "burger_meal");
        volarisFoods.add(burgerMeal);

        return volarisFoods;
    }
}
