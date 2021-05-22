package com.syntaxtm.CustomDrops.Managers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;

public final class MaterialManager
{
	// TODO: move constants here to config.yml
	private final static int CUSTOM_DROP_MIN_QTY = 3;
	private final static int CUSTOM_DROP_MAX_QTY = 7;
	
	private static List<Material> simpleDrops;
	private static Hashtable<Material, Material> customDropMap;
	
	// TODO: load the simple drops from config.yml
	// TODO: load the custom drop materials and their drop(s), quantities, chances, etc from config.yml
	public static void init() {
		simpleDrops = new ArrayList<Material>();
		
		simpleDrops.add(Material.GLASS);
		simpleDrops.add(Material.GLASS_PANE);
		simpleDrops.add(Material.ICE);
		simpleDrops.add(Material.PACKED_ICE);
		simpleDrops.add(Material.BOOKSHELF);
		//simpleDrops.add(Material.GLOWSTONE);
		//simpleDrops.add(Material.CLAY);
		//simpleDrops.add(Material.SEA_LANTERN);
		
		customDropMap = new Hashtable<Material, Material>(); 
		
		customDropMap.put(Material.IRON_ORE, Material.IRON_INGOT);
		customDropMap.put(Material.GOLD_ORE, Material.GOLD_INGOT);
		customDropMap.put(Material.DIAMOND_ORE, Material.DIAMOND);
		customDropMap.put(Material.COAL_ORE, Material.COAL);
		customDropMap.put(Material.EMERALD_ORE, Material.EMERALD);
		customDropMap.put(Material.NETHER_QUARTZ_ORE, Material.QUARTZ);
		customDropMap.put(Material.GLOWSTONE, Material.GLOWSTONE_DUST);
		customDropMap.put(Material.SEA_LANTERN, Material.PRISMARINE_CRYSTALS);
	}
	
	// TODO: load quantity range for block drop(s) from config.yml
	public static int getRandomDropQuantity() {
		int dropCount = (int) (Math.random() * ((CUSTOM_DROP_MAX_QTY - CUSTOM_DROP_MIN_QTY) + 1)) + CUSTOM_DROP_MIN_QTY;		
		return dropCount;
	}
	
	// TODO: load from config.yml
	public static boolean isSimpleDrop(Block block) {
		if (block == null) throw new IllegalArgumentException("Block block cannot be null");
		
		Material material = block.getType();
		return isSimpleDrop(material);
	}
	
	// TODO: load from config.yml
	public static boolean isSimpleDrop(Material material) {
		if (material == null) throw new IllegalArgumentException("Material material cannot be null");
		
		return simpleDrops.contains(material);
	}
	
	// TODO: load from config.yml
	public static boolean isCustomDrop(Block block) {
		if (block == null) throw new IllegalArgumentException("Block block cannot be null");
		
		Material material = block.getType();
		return isSimpleDrop(material);
	}
	
	// TODO: load from config.yml
	public static boolean isCustomDrop(Material material) {
		if (material == null) throw new IllegalArgumentException("Material material cannot be null");
		
		return customDropMap.containsKey(material);
	}
	
	// TODO: this is 1:1 block to drop (i.e. ore -> ingots) this needs to be able to return a List of drops configurable in config.yml
	public static Material getCustomDropMaterial(Block block) {
		if (block == null) throw new IllegalArgumentException("Block block cannot be null");		
		if (!isCustomDrop(block)) throw new IllegalArgumentException("Block block is not setup for a custom drop");
		
		Material material = block.getType();
		
		return getCustomDropMaterial(material);
	}
	
	// TODO: this is 1:1 block to drop (i.e. ore -> ingots) this needs to be able to return a List of drops configurable in config.yml
	public static Material getCustomDropMaterial(Material material) {
		if (material == null) throw new IllegalArgumentException("Material material cannot be null");		
		if (!isCustomDrop(material)) throw new IllegalArgumentException("Material material is not setup for a custom drop");
				
		Material customDropMaterial = customDropMap.get(material);
		
		return customDropMaterial;
	}
}
