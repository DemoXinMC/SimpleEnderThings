package com.demoxin.minecraft.simpleenderthings;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEnderPouch extends Item {
	public ItemEnderPouch()
    {
        super();
        
        setMaxStackSize(1);
        setUnlocalizedName("enderpouch");
        setCreativeTab(CreativeTabs.tabTools);
        this.setTextureName(SimpleEnderThings.MODID +":enderpouch");
    }
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
		InventoryEnderChest inventoryenderchest = entityPlayer.getInventoryEnderChest();
		if (inventoryenderchest != null)
			entityPlayer.displayGUIChest(inventoryenderchest);
        return itemStack;
    }
}
