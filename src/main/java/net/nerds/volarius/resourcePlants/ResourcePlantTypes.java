package net.nerds.volarius.resourcePlants;

import net.minecraft.item.Item;

public class ResourcePlantTypes {

    private Item type;
    private String name;

    public ResourcePlantTypes(Item type, String name) {
        this.type = type;
        this.name = name;
    }

    public Item getType() {
        return this.type;
    }
    public String getName() {
        return this.name;
    }
}
