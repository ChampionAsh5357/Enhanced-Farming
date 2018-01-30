package com.Mrbysco.EnhancedFarming.proxy;

import java.util.List;

import com.Mrbysco.EnhancedFarming.block.ILeafColor;
import com.Mrbysco.EnhancedFarming.init.FarmingBlocks;
import com.Mrbysco.EnhancedFarming.render.ScarecrowRenderer;
import com.Mrbysco.EnhancedFarming.tileentity.TileEntityScarecrow;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{
	
	public void Preinit() {
		
	}

	public void Init() {
		this.addLeaves();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScarecrow.class, new ScarecrowRenderer());
	}
	
	private static List<Block> coloredBlocks = Lists.newArrayList();
	
	public void addLeaves() {
		for(Block block : FarmingBlocks.BLOCKS)
		{
			if (block instanceof ILeafColor)
			{
				coloredBlocks.add(block);
			}
		}
		
		this.registerColouring();
	}
	
    public void registerColouring()
    {
		
        for (Block block : coloredBlocks)
        {
        	ILeafColor fruitLeaves = (ILeafColor)block;
            if (fruitLeaves.getBlockColor() != null) Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(fruitLeaves.getBlockColor(), block);
            if (fruitLeaves.getItemColor() != null) Minecraft.getMinecraft().getItemColors().registerItemColorHandler(fruitLeaves.getItemColor(), block);
        }
    }
}
