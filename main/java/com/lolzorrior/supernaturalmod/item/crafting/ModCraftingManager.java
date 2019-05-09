package com.lolzorrior.supernaturalmod.item.crafting;

import java.nio.file.FileSystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;

public class ModCraftingManager 
{
	private static final Logger LOGGER = LogManager.getLogger();
	private static int nextAvailableId;
	public static final RegistryNamespaced<ResourceLocation, IRecipe> REGISTRY = net.minecraftforge.registries.GameData.getWrapper(IRecipe.class);
	
	private static boolean parseJsonRecipes()
	{
		FileSystem filesystem = null;
		Gson gson = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
		boolean flag1;
		
		try
		{
			URL url = ModCraftingManager.class.getResource("")
		}
	}
}
