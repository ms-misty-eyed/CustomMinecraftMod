package com.example.examplemod;

import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.*;
import net.minecraft.world.item.Item;

@Mod(ExampleMod.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class ExampleMod{
    //************ DECLARE VARIABLES ******************
    public static final String MODID = "examplemod";
    public static final String MODNAME = "ModName";
    public static String VERSION = "0.0.3";

    private static final Logger LOGGER = LogManager.getLogger();

    public static customSword mySword;
    public static customPickaxe myPickaxe;
    public static customAxe myAxe;
    public static customShovel myShovel;

    public ExampleMod(){
        //************ INITIALIZE VARIABLES ******************
        mySword = new customSword();
        myPickaxe = new customPickaxe();
        myAxe = new customAxe();
        myShovel = new customShovel();


        //************ REGISTER ITEMS ******************
        registerItem(mySword, "my_sword");
        registerItem(myPickaxe, "my_pickaxe");
        registerItem(myAxe, "my_axe");
    }
    public static ArrayList<Item> itemsToRegister = new ArrayList<>();

    private void registerItem(customSword mySword, String mySword1) {
        mySword.setRegistryName(mySword1);
        itemsToRegister.add(mySword);
    }

    private void registerItem(customPickaxe myPickaxe, String myPickaxe1) {
        myPickaxe.setRegistryName(myPickaxe1);
        itemsToRegister.add(myPickaxe);
    }

    private void registerItem(customAxe myAxe, String myAxe1) {
        myAxe.setRegistryName(myAxe1);
        itemsToRegister.add(myAxe);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){doItemRegistry(event);}

    private static void doItemRegistry(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(itemsToRegister.toArray(new Item[itemsToRegister.size()]));
    }
}


