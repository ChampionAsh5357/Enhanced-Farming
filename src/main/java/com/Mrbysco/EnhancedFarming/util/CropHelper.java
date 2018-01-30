package com.Mrbysco.EnhancedFarming.util;

import com.Mrbysco.EnhancedFarming.block.EnumCropType;
import com.Mrbysco.EnhancedFarming.init.FarmingBlocks;
import com.Mrbysco.EnhancedFarming.init.FarmingItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class CropHelper {

	public static Item getCropSeed(EnumCropType type) {
		Item seed = null;
		
		switch (type) {
		case AUBERGINE:
			seed = FarmingItems.aubergine_seeds;
			break;
		case CUCUMBER:
			seed = FarmingItems.cucumber_seeds;
			break;
		case MINT:
			seed = FarmingItems.mint_seeds;
			break;
		case TOMATO:
			seed = FarmingItems.tomato_seeds;
			break;
		case GRAPE:
			seed = FarmingItems.grape_seeds;
			break;
		case PINEAPPLE:
			seed = FarmingItems.pineapple;
			break;
		default:
			seed = FarmingItems.mint_seeds;
			break;
		}
		
		return seed; 
	}
	
	public static Item getCrop(EnumCropType type) {
		Item crop = null;	
		
		switch (type) {
		case AUBERGINE:
			crop = FarmingItems.aubergine;
			break;
		case CUCUMBER:
			crop = FarmingItems.cucumber;
			break;
		case MINT:
			crop = FarmingItems.mint;
			break;
		case TOMATO:
			crop = FarmingItems.tomato;
			break;
		case GRAPE:
			crop = FarmingItems.grapes;
			break;
		case PINEAPPLE:
			crop = FarmingItems.pineapple;
			break;
		default:
			crop = FarmingItems.mint;
			break;
		}
		
		return crop; 
	}
}
