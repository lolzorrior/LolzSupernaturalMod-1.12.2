package com.lolzorrior.supernaturalmod.item.crafting;

import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class RecipeAltarFactory implements IRecipeFactory {

	@Override
	public IRecipe parse(JsonContext context, JsonObject json) {
		String domain = null;
		if(JsonUtils.hasField(json, "domain"))
		{
			domain = JsonUtils.getString(json, domain, "");
		}
		final ItemStack ingredients = CraftingHelper.getItemStack(JsonUtils.getJsonObject(json, "ingredient"), context);
		final ItemStack result = CraftingHelper.getItemStack(JsonUtils.getJsonObject(json, "result"), context);
		return new RecipeAltar(result.getItem(), ingredients, domain);
	}

}
