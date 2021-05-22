package com.syntaxtm.CustomDrops;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.syntaxtm.CustomDrops.Logging.LogHelper;
import com.syntaxtm.CustomDrops.Managers.MaterialManager;
import com.syntaxtm.CustomDrops.Utils.BlockUtils;
import com.syntaxtm.CustomDrops.Utils.PlayerUtils;

public class BlockBreakEventListener implements Listener {
	
	// TODO: remove this, with the Util classes this isn't likely needed to be referenced directly
	@SuppressWarnings("unused")
	private CustomDrops plugin;
	
	public BlockBreakEventListener(CustomDrops plugin) {
		if (plugin == null) {
			throw new IllegalArgumentException("CustomDrops plugin cannot be null");
		}
		
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent event) {
		try
		{
			LogHelper.debug("Handling [onBlockBreakEvent]...");
			
			Block block = event.getBlock();
			Material material = block.getType();
			String blockTypeName = BlockUtils.GetTypeName(block);

			//	simple drops are the blocks that are set to drop the original Material that would otherwise
			// be changed (i.e. GLOWSTONE) or just wouldn't drop anything (i.e. Glass)
			if (MaterialManager.isSimpleDrop(material)) {				
				BlockUtils.replaceBlockAndDrop(block, material);
				
				LogHelper.info("Simple custom drop completed for " + blockTypeName);
	            
	            return;
			}
						
			if (MaterialManager.isCustomDrop(material)) {				
				Player player = event.getPlayer();
				
				// TODO: load from config.yml per-block and per-drop
				int dropCount = MaterialManager.getRandomDropQuantity();
	            Material newDrop = MaterialManager.getCustomDropMaterial(material);

	            // grant exp for the mining
	            PlayerUtils.addExpToPlayer(player, 1, dropCount);
	            
	            // actually remove the block (swap w/ AIR) and simulate a natural item drop
	            BlockUtils.replaceBlockAndDrop(block, newDrop, dropCount);
	            
	            LogHelper.info("Custom drop completed for " + blockTypeName + ". Dropped " + dropCount + " " + newDrop.name());
	            
	            return;
			}
			
			LogHelper.debug("[onBlockBreakEvent] handling completed without drop modifications.");
		}
		catch (Exception e)
		{
			LogHelper.error("Error handling [onBlockBreakEvent].", e);
		}		
	}
}
