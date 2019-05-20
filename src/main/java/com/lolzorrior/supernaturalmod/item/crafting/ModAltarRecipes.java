package com.lolzorrior.supernaturalmod.item.crafting;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModAltarRecipes 
{
	private static final ModAltarRecipes MODALTAR_BASE = new ModAltarRecipes();
	/** List of Altar results. */
	private final Map<ItemStack, ItemStack> altarList = Maps.<ItemStack,ItemStack>newHashMap();
	/** List of xp each recipe generates. */
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static ModAltarRecipes instance()
	{
		return MODALTAR_BASE;
	}
	
	
	private ModAltarRecipes()
	{
		//this.addModAltar()
	}
	
	/** Adds an altar recipe, where the input item is a Block. */
	public void addModAltarRecipeForBlock(Block input, ItemStack stack, float experience)
	{
		this.addModAltar(Item.getItemFromBlock(input), stack, experience);
	}
	
	/** Adds an altar recipe using an Item as the input item. */
	public void addModAltar(Item input, ItemStack stack, float experience)
	{
		this.addModAltarRecipe(new ItemStack(input, 1, 32767), stack, experience);
	}
	
	/** Adds an altar recipe using an ItemStack as the input for the recipe. */
	public void addModAltarRecipe(ItemStack input, ItemStack stack, float experience)
	{
		if (getModAltarResult(input) != ItemStack.EMPTY ) {
			net.minecraftforge.fml.common.FMLLog.log.info("Ignored Altar recipe with conflicting input: {} = {}", input, stack); return; 
		}
		this.altarList.put(input, stack);
		this.experienceList.put(stack, Float.valueOf(experience));
	}
	
	/** Returns the altar result of an item. */
	public ItemStack getModAltarResult(ItemStack stack)
	{
		for (Entry<ItemStack, ItemStack> entry : this.altarList.entrySet())
		{
			if (this.compareItemStacks(stack, entry.getKey()))
			{
				return entry.getValue();
			}
		}
		return ItemStack.EMPTY;
	}
	
	/** Compares two itemstacks to make sure they are the same. */
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Map<ItemStack, ItemStack> getModAltarList()
	{
		return this.altarList;
	}
	
	public float getModAltarExperience(ItemStack stack)
	{
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1) return ret;
		
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
		{
			if (this.compareItemStacks(stack, entry.getKey()))
			{
				return ((Float)entry.getValue().floatValue());
			}
		}
		return 0.0F;
	}
}
