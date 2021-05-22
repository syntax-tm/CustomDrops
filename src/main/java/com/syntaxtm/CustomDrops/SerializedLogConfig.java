package com.syntaxtm.CustomDrops;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

public class SerializedLogConfig implements ConfigurationSerializable {
	
	private Boolean debug;
	private Boolean dropped_block_info;
    private Boolean dropped_block_fail;
    private Boolean dropped_block_success;
    
    public Boolean getLogDebug() {
    	return debug;
    }
    
    public Boolean getLogBlockInfo() {
    	return dropped_block_info;
    }
    
    public Boolean getLogBlockFail() {
    	return dropped_block_fail;
    }
    
    public Boolean getLogBlockSuccess() {
    	return dropped_block_success;
    }
    
    public SerializedLogConfig() {
    	
    }
    
    public SerializedLogConfig(Boolean debug, Boolean dropped_block_info, Boolean dropped_block_fail, Boolean dropped_block_success) {
    	this.debug = debug;
    	this.dropped_block_info = dropped_block_info;
    	this.dropped_block_fail = dropped_block_fail;
    	this.dropped_block_success = dropped_block_success;
	}
    
    public final Map<String, Object> serialize(){
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("debug", debug);
        map.put("dropped_block_info", dropped_block_info);
        map.put("dropped_block_fail", dropped_block_fail);
        map.put("dropped_block_success", dropped_block_success);

        return map;
    }

    public static SerializedLogConfig deserialize(Map<String, Object> map){
    	Boolean logDebug = (Boolean) map.get("debug");
    	Boolean logBlockInfo = (Boolean) map.get("dropped_block_info");
    	Boolean logDropFail = (Boolean) map.get("dropped_block_fail");
    	Boolean logDropSuccess = (Boolean) map.get("dropped_block_success");

        return new SerializedLogConfig(logDebug, logBlockInfo, logDropFail, logDropSuccess);
    }
}
