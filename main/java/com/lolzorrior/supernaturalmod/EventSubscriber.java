package com.lolzorrior.supernaturalmod;

import com.lolzorrior.supernaturalmod.SupernaturalMod;
import com.lolzorrior.supernaturalmod.block.BlockWitchWood;
import com.lolzorrior.supernaturalmod.block.BlockWitchWoodPlanks;
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
			new BlockWitchWood().setRegistryName("witch_wood").setUnlocalizedName(SupernaturalMod.MODID + ".witch_wood"),
			new BlockWitchWoodPlanks().setRegistryName("witch_wood_planks").setUnlocalizedName(SupernaturalMod.MODID + ".witch_wood_planks")
		};
		event.getRegistry().registerAll(blocks);
	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event)
	{
		final Item[] itemBlocks = 
			{
					new ItemBlock(ModBlocks.WITCH_WOOD).setRegistryName(ModBlocks.WITCH_WOOD.getRegistryName()),
					new ItemBlock(ModBlocks.WITCH_WOOD_PLANKS).setRegistryName(ModBlocks.WITCH_WOOD_PLANKS.getRegistryName())
			};
		event.getRegistry().registerAll(itemBlocks);
	}
	
}
