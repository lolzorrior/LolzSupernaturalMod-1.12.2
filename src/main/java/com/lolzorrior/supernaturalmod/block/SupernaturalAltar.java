package com.lolzorrior.supernaturalmod.block;

import com.lolzorrior.supernaturalmod.block.materials.ModMaterials;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SupernaturalAltar extends Block  {

	public SupernaturalAltar()  {
		super(ModMaterials.WITCH_WOOD);
	    this.setDefaultState(this.blockState.getBaseState());
	    this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	    this.setHarvestLevel("axe", 2);
		this.setSoundType(SoundType.WOOD);
		this.blockHardness = 10f;
	}

    /**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            {
                playerIn.addExperienceLevel(5);
                return true;
            }
        }
    }
}
