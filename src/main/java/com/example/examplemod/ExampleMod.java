package com.example.examplemod;

import com.example.examplemod.Tools.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExampleMod.MODID)
public class ExampleMod {
    public static final String MODID = "examplemod";

    // 1. Create the Register "Bucket"
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // 2. Register items directly. No more manual ArrayList!
    public static final RegistryObject<Item> MY_SWORD = ITEMS.register("my_sword", customSword::new);
    public static final RegistryObject<Item> MY_PICKAXE = ITEMS.register("my_pioche", customPickaxe::new);
    public static final RegistryObject<Item> MY_AXE = ITEMS.register("my_axe", customAxe::new);
    public static final RegistryObject<Item> MY_SHOVEL = ITEMS.register("my_shovel", customShovel::new);

    public ExampleMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // 3. Tell the bus to handle our items
        ITEMS.register(bus);
    }
}