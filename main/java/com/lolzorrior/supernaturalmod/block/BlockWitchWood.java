package com.lolzorrior.supernaturalmod.block;

import com.lolzorrior.supernaturalmod.block.materials.ModMaterials;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;



public class BlockWitchWood extends BlockRotatedPillar
{
	private static final PropertyEnum<BlockLog.EnumAxis> axis = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);
	
	public BlockWitchWood() 
	{
		super(ModMaterials.WITCH_WOOD);
		this.setDefaultState(this.blockState.getBaseState().withProperty(axis, BlockLog.EnumAxis.Y));
		this.setHarvestLevel("axe", 2);
		this.setSoundType(SoundType.WOOD);
		this.blockHardness = 10f;
	}
	
	@Override
	public boolean isToolEffective(String type, IBlockState state)
	{
		if ("axe".equals(type))
			return true;
		else return false;
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
	    switch ((BlockLog.EnumAxis)state.getValue(axis))
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

	
	   /**
     * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
     */
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = 4;
        int j = 5;

        if (worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5)))
        {
            for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4)))
            {
                IBlockState iblockstate = worldIn.getBlockState(blockpos);

                if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos))
                {
                    iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
                }
            }
        }
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        switch (rot)
        {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:

                switch ((BlockLog.EnumAxis)state.getValue(axis))
                {
                    case X:
                        return state.withProperty(axis, BlockLog.EnumAxis.Z);
                    case Z:
                        return state.withProperty(axis, BlockLog.EnumAxis.X);
                    default:
                        return state;
                }

            default:
                return state;
        }
    }

    @Override public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos){ return true; }
    @Override public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos){ return true; }

    
}