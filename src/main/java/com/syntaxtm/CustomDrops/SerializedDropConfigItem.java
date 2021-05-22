package com.syntaxtm.CustomDrops;

import java.util.*;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

@SerializableAs("drop")
public class SerializedDropConfigItem implements ConfigurationSerializable {
	
	private String name;
    private int block_id;
    private List<SerializedDroppedBlock> dropped_blocks;
    
    public String getName() {
    	return name;
    }
    
    public int getBlockId() {
    	return block_id;
    }
    
    public List<SerializedDroppedBlock> getDroppedBlocks() {
    	return dropped_blocks;
    }
 	
    public SerializedDropConfigItem() {
    	
    }
    
    public SerializedDropConfigItem(String name, int blockId, List<SerializedDroppedBlock> dropped_blocks) {
    	this.name = name;
    	this.block_id = blockId;
    	this.dropped_blocks = dropped_blocks;
	}
    
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", name);
        map.put("block_id", block_id);
        map.put("dropped_blocks", dropped_blocks);

        return map;
    }
    
}
