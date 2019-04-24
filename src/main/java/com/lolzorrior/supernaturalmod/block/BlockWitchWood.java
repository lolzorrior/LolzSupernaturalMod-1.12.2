package com.lolzorrior.supernaturalmod.block;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;



public class BlockWitchWood extends BlockLog
{
	private static final PropertyEnum<BlockLog.EnumAxis> axis = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);
	public BlockWitchWood() 
	{
		super();
		this.setDefaultState(this.blockState.getBaseState().withProperty(axis, BlockLog.EnumAxis.Y));
		this.setHarvestLevel("axe", 2);
		this.setSoundType(SoundType.WOOD);
	}
	
/**
 * Convert the given metadata into a BlockState for this Block
 */
	public IBlockState getStateFromMeta(int meta)
	{
	    IBlockState state = this.getDefaultState();
	
	    switch (meta & 0b1100)
	    {
	        case 0b0000:
	            state = state.withProperty(axis, BlockLog.EnumAxis.Y);
	            break;
	
	        case 0b0100:
	            state = state.withProperty(axis, BlockLog.EnumAxis.X);
	            break;
	
	        case 0b1000:
	            state = state.withProperty(axis, BlockLog.EnumAxis.Z);
	            break;
	
	        case 0b1100:
	            state = state.withProperty(axis, BlockLog.EnumAxis.NONE);
	            break;
	    }
	
	    return state;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state)
	{
	    switch ((BlockWitchWood.EnumAxis)state.getValue(axis))
	    {
	        case X: return 0b0100;
	        case Y: return 0b0000;
	        case Z: return 0b1000;
	        case NONE: return 0b1100;
	        default: return 0b1100;
	    }
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {axis});
	}
	
	
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getStateFromMeta(meta).withProperty(axis, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis()));
	}
	
	public boolean canDropFromExplosion(Explosion explosionIn)
	{
		return false;
	}

}