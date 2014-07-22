package com.demoxin.minecraft.simpleenderthings;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = SimpleEnderThings.MODID, name = SimpleEnderThings.NAME, version = SimpleEnderThings.VERSION)
public class SimpleEnderThings {
	// Mod Info
	public static final String MODID = "SimpleEnderThings";
	public static final String NAME = "SimpleEnderThings";
	public static final String VERSION = "1.0";
	// Mod Info End
	
	// Singleton
	@Instance("SimpleEnderThings")
	public static SimpleEnderThings instance;
	
	// Items
	public static Item itemPouch;
    public static Item itemTome;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	itemPouch = new ItemEnderPouch();
    	GameRegistry.registerItem(itemPouch, "enderPouch");
        
        itemTome = new ItemEnderTome();
        GameRegistry.registerItem(itemTome, "enderTome");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new LootDropper());
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ItemStack craftingPouch = new ItemStack(itemPouch, 1);
        ItemStack craftingString = new ItemStack(Items.string);
        ItemStack craftingLeather = new ItemStack(Items.leather);
        ItemStack craftingChest = new ItemStack(Item.getItemFromBlock(Blocks.ender_chest));
        
        GameRegistry.addRecipe(craftingPouch, "LSL","LEL","LLL", 'L', craftingLeather, 'S', craftingString, 'E', craftingChest);
        
        ItemStack craftingEnderTome = new ItemStack(itemTome, 1);
        ItemStack craftingEyeOfEnder = new ItemStack(Items.ender_eye);
        ItemStack craftingBook = new ItemStack(Items.enchanted_book);
        
        GameRegistry.addShapelessRecipe(craftingEnderTome, craftingEyeOfEnder, craftingBook);
    }
}