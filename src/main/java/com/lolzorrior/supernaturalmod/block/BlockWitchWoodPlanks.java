package com.lolzorrior.supernaturalmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockWitchWoodPlanks extends Block {

	public BlockWitchWoodPlanks() {
        super(Material.WOOD);
        this.setDefaultState(this.blockState.getBaseState());
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
}
