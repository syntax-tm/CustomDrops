package com.syntaxtm.CustomDrops;

import org.bukkit.plugin.java.JavaPlugin;

import com.syntaxtm.CustomDrops.Logging.LogHelper;
import com.syntaxtm.CustomDrops.Managers.MaterialManager;

public final class CustomDrops extends JavaPlugin {
	
    @Override
    public void onEnable() {
    	// set the static plugin to this so that the LogHelper can access the bukkit log functions
    	LogHelper.setPlugin(this);
    	
    	// TODO: load the config from config.yml at startup
    	// init the material manager
    	MaterialManager.init();
    	
    	LogHelper.debug("Registering BlockBreakEventListener for the BlockBreakEvent...");
    	
    	// register the block break event with the server's plug-in manager
		getServer().getPluginManager().registerEvents(new BlockBreakEventListener(this), this);
    	
		LogHelper.debug("Registered BlockBreakEventListener for the BlockBreakEvent.");
    }

    @Override
    public void onDisable() {
        // called when the plug-in is disabled
    }

}