package com.lolzorrior.supernaturalmod.block;

import com.lolzorrior.supernaturalmod.block.materials.ModMaterials;
import com.lolzorrior.supernaturalmod.init.ModBlocks;
import com.lolzorrior.supernaturalmod.inventory.ContainerAltar;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class SupernaturalAltar extends Block  {

	public SupernaturalAltar()  {
		super(ModMaterials.WITCH_WOOD);
	    this.setDefaultState(this.blockState.getBaseState());
	    this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
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
                playerIn.displayGui(new InterfaceSupernaturalAltar(worldIn, pos));
                return true;
            }
        }
    }
 
    
    public static class InterfaceSupernaturalAltar implements IInteractionObject {
    	private final World world;
    	private final BlockPos position;
    	
    	public InterfaceSupernaturalAltar(World worldIn, BlockPos pos)
    	{
    		this.world = worldIn;
    		this.position = pos;
    	}

		@Override
		public String getName() {
			return "altar";
		}

		@Override
		public boolean hasCustomName() {
			return false;
		}

		@Override
		public ITextComponent getDisplayName() {
			return new TextComponentTranslation(ModBlocks.SUPERNATURAL_ALTAR.getUnlocalizedName() + ".name", new Object[0]);
		}

		@Override
		public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
			return new ContainerAltar(playerInventory, this.world, this.position);
		}

		@Override
		public String getGuiID() {
			return "minecraft:crafting_table";
		}
    	
    }
}
