package com.lolzorrior.supernaturalmod.gui;

import com.lolzorrior.supernaturalmod.inventory.ContainerAltar;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModHandler implements IGuiHandler {

	public static final int MOD_ALTAR_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID)
		{
		case MOD_ALTAR_GUI:
			{
				return new ContainerAltar(player.inventory, world, BlockPos.ORIGIN);
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID)
		{
		case MOD_ALTAR_GUI: {
			return new ModGuiAltar(player.inventory, world);
			}
		}
		return null;
	}

}
