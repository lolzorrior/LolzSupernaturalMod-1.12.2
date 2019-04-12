package com.lolzorrior.supernaturalmod;

import com.lolzorrior.supernaturalmod.SupernaturalMod;
import com.lolzorrior.supernaturalmod.block.BlockWitchWood;
import com.lolzorrior.supernaturalmod.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = SupernaturalMod.MODID)
public final class EventSubscriber 
{
	/*@SubscribeEvent
	public static void registerItems(Register<Item> event)
	{
		final Item[] items = 
			{
					new ItemWitchWood().setRegistryName("witch_wood").setUnlocalizedName(SupernaturalMod.MODID + "." + "witch_wood"),
			};
		event.getRegistry().registerAll(items);
	}*/
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event)
	{
		final Block[] blocks = 
		{
			new BlockWitchWood().setRegistryName("witch_wood").setUnlocalizedName(SupernaturalMod.MODID + "." + "witch_wood")	
		};
		event.getRegistry().registerAll(blocks);
	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event)
	{
		final Item[] itemBlocks = 
			{
					new ItemBlock(ModBlocks.WITCH_WOOD).setRegistryName(ModBlocks.WITCH_WOOD.getRegistryName())
			};
		event.getRegistry().registerAll(itemBlocks);
	}
	
}
