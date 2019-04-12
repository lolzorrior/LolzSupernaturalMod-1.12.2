package com.lolzorrior.supernaturalmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockWitchWood extends Block 
{
	public BlockWitchWood() {
		super(Material.WOOD);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setSoundType(SoundType.WOOD);
	}
}
