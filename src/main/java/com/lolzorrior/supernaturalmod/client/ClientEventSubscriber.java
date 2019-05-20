package com.lolzorrior.supernaturalmod.client;

import com.lolzorrior.supernaturalmod.SupernaturalMod;
import com.lolzorrior.supernaturalmod.init.ModBlocks;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = SupernaturalMod.MODID, value = Side.CLIENT)
public final class ClientEventSubscriber 
{
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		for(int i = 0; i < EnumFacing.Axis.values().length; i++) {
		registerModel(Item.getItemFromBlock(ModBlocks.WITCH_WOOD), i);
		};
		registerModel(Item.getItemFromBlock(ModBlocks.WITCH_WOOD_PLANKS), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.SUPERNATURAL_ALTAR), 0);
		registerModel(Item.getItemFromBlock(ModBlocks.SUPERNATURAL_CRAFTING), 0);
	}
	
	private static void registerModel(Item item, int meta)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
