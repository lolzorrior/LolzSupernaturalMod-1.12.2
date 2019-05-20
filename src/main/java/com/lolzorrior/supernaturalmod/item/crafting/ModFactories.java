package com.lolzorrior.supernaturalmod.item.crafting;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ModFactories extends net.minecraftforge.registries.IForgeRegistryEntry.Impl<IRecipe> implements IRecipe 
{
	private static final List<RecipeAltarItem> allAltarItems = new ArrayList<RecipeAltarItem>();
	protected Item output;
	protected ItemStack input;
	protected ItemStack altarItem;
	protected String resourceDomain;
	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canFit(int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getRecipeOutput() {
		// TODO Auto-generated method stub
		return null;
	}

	public RecipeAltarItem(Item output, ItemStack input, Item altarItem, String resourceDomain) {
		this.output = output;
		this.input = itemStack;
		this.altarItem = new ItemStack(altarItem, 1, 0);
		this.resourceDomain = resourceDomain!=null?resourceDomain.toLowerCase()::resourceDomain;
		
		
		}
	}
	
	public static class RecipeAltarItem {
		public final ItemStack input;
		public final String resourceDomain;
		
		public RecipeAltarItem(ItemStack i, String Domain) {
			input = i;
			resourceDomain = Domain;
		}
	}
}
