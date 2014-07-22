package com.demoxin.minecraft.simpleenderthings;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LootDropper
{
    @SubscribeEvent
    public void HandleDrop(LivingDropsEvent fEvent)
    {
        if(!fEvent.recentlyHit)
            return;
        
        if(fEvent.entity instanceof EntityEnderman)
            HandleEndermanDrops(fEvent);
        
        if(fEvent.entity instanceof EntityDragon)
            HandleDragonDrops(fEvent);
        
    }
    
    private void HandleEndermanDrops(LivingDropsEvent fEvent)
    {
        if(fEvent.entity.worldObj.rand.nextInt(100) > 1)
            return;
        
        ItemStack toDrop = null;
        
        if(fEvent.entity.worldObj.rand.nextBoolean())
            toDrop = new ItemStack(SimpleEnderThings.itemPouch, 1, 0);
        else
            toDrop = new ItemStack(SimpleEnderThings.itemTome, 1, 0);
        
        fEvent.drops.add(new EntityItem(fEvent.entity.worldObj, fEvent.entity.posX, fEvent.entity.posY, fEvent.entity.posZ, toDrop));
    }
    
    private void HandleDragonDrops(LivingDropsEvent fEvent)
    {
        int playerCount = fEvent.entity.worldObj.playerEntities.size();
        
        for(int i = 0; i < playerCount; i++)
        {
            fEvent.drops.add(new EntityItem(fEvent.entity.worldObj, fEvent.entity.posX, fEvent.entity.posY, fEvent.entity.posZ, new ItemStack(SimpleEnderThings.itemTome, 1, 0)));
            
            if(fEvent.entity.worldObj.rand.nextInt(5) < 1)
                fEvent.drops.add(new EntityItem(fEvent.entity.worldObj, fEvent.entity.posX, fEvent.entity.posY, fEvent.entity.posZ, new ItemStack(SimpleEnderThings.itemPouch, 1, 0)));
        }
    }
}
