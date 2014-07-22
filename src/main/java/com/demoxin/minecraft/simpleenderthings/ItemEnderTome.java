package com.demoxin.minecraft.simpleenderthings;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class ItemEnderTome extends Item
{
	public ItemEnderTome()
    {
        super();
        
        setMaxStackSize(1);
        setUnlocalizedName("endertome");
        setCreativeTab(CreativeTabs.tabTools);
        this.setTextureName(SimpleEnderThings.MODID + ":endertome");
    }
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
		ChunkCoordinates teleTarget = null;
		boolean requireDimension = false;
		teleTarget = entityPlayer.getBedLocation(entityPlayer.dimension);
		
		if(teleTarget == null)
		{
			teleTarget = entityPlayer.getBedLocation(0);
			requireDimension = true;
		}
			
		
		if(teleTarget == null)
			return itemStack;
		
		if(requireDimension)
			entityPlayer.travelToDimension(0);
		entityPlayer.setPositionAndUpdate(teleTarget.posX, teleTarget.posY, teleTarget.posZ);
		itemStack.stackSize = 0;
		entityPlayer.addPotionEffect(new PotionEffect(Potion.hunger.getId(), 800, 2, false));
		entityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 400, 2, false));
        return itemStack;
    }
}
