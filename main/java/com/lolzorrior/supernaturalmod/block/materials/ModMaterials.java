package com.lolzorrior.supernaturalmod.block.materials;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class ModMaterials {

	//Witch Wood material
	public static final Material WITCH_WOOD = new ModMaterial(MapColor.WOOD).setRequiresTool().setBurning();
	
	public static class ModMaterial extends Material {
	
		public ModMaterial(MapColor color) {
		
			super(color);
	
		}
	
		@Override
		protected ModMaterial setNoPushMobility() {
			super.setNoPushMobility();
			return this;
		}
	
		@Override
		protected ModMaterial setImmovableMobility() {
			super.setImmovableMobility();
			return this;
		}
	
		@Override
		protected ModMaterial setRequiresTool() {
			super.setRequiresTool();
			return this;
		}
	
		@Override
		protected ModMaterial setBurning() {
			super.setBurning();
			return this;
		}
	}
}


