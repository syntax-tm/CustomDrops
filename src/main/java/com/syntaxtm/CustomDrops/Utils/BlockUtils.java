package com.syntaxtm.CustomDrops.Utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import com.syntaxtm.CustomDrops.Logging.LogHelper;

public final class BlockUtils
{
	private final static Material EMPTY_BLOCK = Material.AIR;
	
	public static String GetTypeName(Block block) {
		if (block == null) throw new IllegalArgumentException("Block block cannot be null");
		
		Material material = block.getType();
		return material.name();
    }
	
	public static void replaceBlockAndDrop(Block block, Material material) {
		if (block == null) throw new IllegalArgumentException("Block block cannot be null");
		if (material == null) throw new IllegalArgumentException("Material material cannot be null");
		
        replaceBlockAndDrop(block, material, 1);
	}
	
	public static void replaceBlockAndDrop(Block block, Material material, int qty) {
		if (block == null) throw new IllegalArgumentException("Block block cannot be null");
		if (material == null) throw new IllegalArgumentException("Material material cannot be null");
		if (qty <= 0) throw new IllegalArgumentException("qty must be greater than or equal to 1");
		
        replaceBlockAndDrop(block, new ItemStack(material, qty));
	}
	
	public static void replaceBlockAndDrop(Block block, ItemStack drop) {
		if (block == null) throw new IllegalArgumentException("Block block cannot be null");
		if (drop == null) throw new IllegalArgumentException("ItemStack drop cannot be null");
		
		LogHelper.trace("Replacing " + GetTypeName(block) + " block drop with custom ItemStack...");
		
		// manually change the block to air (delete it) and make it seem like
        // the new ore was dropped naturally
        block.setType(EMPTY_BLOCK);
        block.getWorld().dropItemNaturally(block.getLocation(), drop);
        
        LogHelper.trace("Block replacement and drop completed.");
	}
}
