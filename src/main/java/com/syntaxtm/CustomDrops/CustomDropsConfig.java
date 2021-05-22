package com.syntaxtm.CustomDrops;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.file.YamlConfiguration;

public class CustomDropsConfig {

	private static File file = new File("plugins/CustomDrops/config.yml");
    private static YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
	
	private static SerializedLogConfig log;
	private static List<SerializedDropConfigItem> drops;
	
	public static List<SerializedDropConfigItem> getDrops() {
		return drops;
	}
	
	public static SerializedLogConfig getLog() {
		return log;
	}
	
	@SuppressWarnings("unchecked")
	public static void load() {
        config.options().copyDefaults(true);
        
        Map<String, Object> loadedConfig = config.getValues(true);
        
        drops = (List<SerializedDropConfigItem>) loadedConfig.get("dropped_blocks");
    	log = (SerializedLogConfig) loadedConfig.get("log");
    	
    }
	
}
