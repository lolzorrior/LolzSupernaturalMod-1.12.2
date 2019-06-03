package com.lolzorrior.supernaturalmod.item.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;


public class RecipeAltar extends net.minecraftforge.registries.IForgeRegistryEntry.Impl<IRecipe> implements IRecipe 
{
	protected Item output;
	protected ItemStack input;
	protected ItemStack altarItem;
	protected String resourceDomain;
	protected ResourceLocation resourceLocation;

	public RecipeAltar(Item item, ItemStack ingredients, String domain) {
		output = item;
		input = ingredients;
		resourceDomain = domain;
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) 
	{
	    for (int i = 0; i <= inv.getWidth(); ++i)
	    {
	        for (int j = 0; j <= inv.getHeight(); ++j)
            {
	        	ItemStack itemstack = inv.getStackInRowAndColumn(j, i);
	        	if (itemstack != ItemStack.EMPTY)
	        	{
	        	     if ( ItemStack.areItemStacksEqual(itemstack, input))
	                 {
	        	    	 return true;
	                 }
	        	}
           
            }
	    }
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		// TODO Auto-generated method stub
		return this.getRecipeOutput().copy();
	}

	@Override
	public boolean canFit(int width, int height) {
		return (width >= 3 && height >= 3);
	}

	@Override
	public ItemStack getRecipeOutput() {
		// TODO Auto-generated method stub
		return ItemStack.EMPTY;
	}
	
	
}

