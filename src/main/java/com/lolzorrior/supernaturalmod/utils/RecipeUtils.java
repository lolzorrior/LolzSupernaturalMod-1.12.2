package com.lolzorrior.supernaturalmod.utils;

import java.util.Iterator;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;

public class RecipeUtils {
	@Nullable
	public static IRecipe getRecipeWithOutput(ItemStack resultStack) {
		resultStack = resultStack.copy();
		ItemStack recipeResult = null;
		RegistryNamespaced<ResourceLocation, IRecipe> recipes = CraftingManager.REGISTRY;
		Iterator<IRecipe> iterator = recipes.iterator();
		while(iterator.hasNext()) {
			IRecipe tmpRecipe = iterator.next();
			recipeResult = tmpRecipe.getRecipeOutput();
			resultStack.setCount(Math.max(recipeResult.getCount(), 1));
			if (ItemStack.areItemsEqual(resultStack, recipeResult)) {
				return tmpRecipe;
			}
		}
		return null;
	}
	
}
