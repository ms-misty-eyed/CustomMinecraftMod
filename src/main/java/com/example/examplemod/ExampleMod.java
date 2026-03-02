package com.example.examplemod;

import com.example.examplemod.tools.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExampleMod.MODID)
public class ExampleMod {
    public static final String MODID = "examplemod";

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    //Tools register
    public static final RegistryObject<Item> MY_SWORD = ITEMS.register("my_sword", customSword::new);
    public static final RegistryObject<Item> MY_PICKAXE = ITEMS.register("my_pioche", customPickaxe::new);
    public static final RegistryObject<Item> MY_AXE = ITEMS.register("my_axe", customAxe::new);
    public static final RegistryObject<Item> MY_SHOVEL = ITEMS.register("my_shovel", customShovel::new);

    //Block register
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    //Register the actual Block
    public static final RegistryObject<Block> GRAVITY_ANCHOR = BLOCKS.register("gravity_anchor",
            () -> new GravityAnchorBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    // 3. Register the Item so you can hold the block
    public static final RegistryObject<Item> GRAVITY_ANCHOR_ITEM = ITEMS.register("gravity_anchor",
            () -> new BlockItem(GRAVITY_ANCHOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public ExampleMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(bus);
        BLOCKS.register(bus);
    }
}