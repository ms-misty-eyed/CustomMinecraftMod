package com.example.examplemod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tiers;

public class customShovel extends ShovelItem {
    public customShovel() {
        super(Tiers.DIAMOND, 0,0, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
    }


}
