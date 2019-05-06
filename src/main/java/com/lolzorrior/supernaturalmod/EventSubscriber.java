package com.lolzorrior.supernaturalmod;

import com.lolzorrior.supernaturalmod.SupernaturalMod;
import com.lolzorrior.supernaturalmod.block.BlockWitchWood;
import com.lolzorrior.supernaturalmod.block.BlockWitchWoodPlanks;
import com.lolzorrior.supernaturalmod.block.SupernaturalAltar;
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
	//Registry name has to be the same as Class i.e. supernatural_altar not altar
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event)
	{
		final Block[] blocks = 
		{
			new BlockWitchWood().setRegistryName("witch_wood").setUnlocalizedName(SupernaturalMod.MODID + ".witch_wood"),
			new BlockWitchWoodPlanks().setRegistryName("witch_wood_planks").setUnlocalizedName(SupernaturalMod.MODID + ".witch_wood_planks"),
			new SupernaturalAltar().setRegistryName("supernatural_altar").setUnlocalizedName(SupernaturalMod.MODID + ".supernatural_altar")
		};
		event.getRegistry().registerAll(blocks);
	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event)
	{
		final Item[] itemBlocks = 
			{
					new ItemBlock(ModBlocks.WITCH_WOOD).setRegistryName(ModBlocks.WITCH_WOOD.getRegistryName()),
					new ItemBlock(ModBlocks.WITCH_WOOD_PLANKS).setRegistryName(ModBlocks.WITCH_WOOD_PLANKS.getRegistryName()),
					new ItemBlock(ModBlocks.SUPERNATURAL_ALTAR).setRegistryName(ModBlocks.SUPERNATURAL_ALTAR.getRegistryName())
			};
		event.getRegistry().registerAll(itemBlocks);
	}
	
}
