package com.lolzorrior.supernaturalmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lolzorrior.supernaturalmod.proxy.IProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = SupernaturalMod.MODID, name = SupernaturalMod.NAME, version = SupernaturalMod.VERSION, acceptedMinecraftVersions = SupernaturalMod.MC_VERSION)
public class SupernaturalMod 
{
	public static final String MODID = "supernaturalmod";
	public static final String NAME = "Lolzorrior's Supernatural Mod";
	public static final String VERSION = "0.1";
	public static final String MC_VERSION = "[1.12.2]";
	
	public static final Logger LOGGER = LogManager.getLogger(SupernaturalMod.MODID);
	
	public static final String CLIENT = "com.lolzorrior.supernaturalmod.proxy.ClientProxy";
	public static final String SERVER = "com.lolzorrior.supernaturalmod.proxy.ServerProxy";
	@SidedProxy(clientSide = SupernaturalMod.CLIENT, serverSide = SupernaturalMod.SERVER)
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit(event);
	}

	
	@EventHandler
	public void init (FMLInitializationEvent event)
	{
		LOGGER.info(SupernaturalMod.NAME  + " says hi!");
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
	
	public EntityPlayer getPlayer() {
		return Minecraft.getMinecraft().player;
	}
}
