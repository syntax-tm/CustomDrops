package com.syntaxtm.CustomDrops;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class SerializedDroppedBlock implements ConfigurationSerializable {
	
	private int block_id;
	private Integer data_value;
	private String block_name;
    private int min_qty, max_qty;
    private double chance;

    public int getBlockId() {
        return block_id;
    }

    public Integer getDataValue() {
        return data_value;
    }

    public String getBlockName() {
        return block_name;
    }

    public int getMinQty() {
        return min_qty;
    }
    
    public int getMaxQty() {
        return max_qty;
    }
    
    public double getChance() {
        return chance;
    }

    public SerializedDroppedBlock(int block_id, Integer data_value, String block_name,
    		int min_qty, int max_qty, double chance) {
        this.block_id = block_id;
        this.data_value = data_value;
        this.block_name = block_name;
        this.min_qty = min_qty;
        this.max_qty = max_qty;
        this.chance = chance;
    }

    public SerializedDroppedBlock(Map<String, Object> map) {
        this.block_id = (Integer) map.get("block_id");
        this.data_value = (Integer) map.get("data_value");
        this.block_name = (String) map.get("block_name");
        this.min_qty = (Integer) map.get("min_qty");
        this.max_qty = (Integer) map.get("max_qty");
        this.chance = (Double) map.get("chance");
    }

    public static SerializedDroppedBlock deserialize(Map<String, Object> map) {
        return new SerializedDroppedBlock(map);
    }

    public static SerializedDroppedBlock valueOf(Map<String, Object> map) {
        return new SerializedDroppedBlock(map);
    }

    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("block_id", block_id);
        map.put("data_value", data_value);
        map.put("block_name", block_name);
        map.put("min_qty", min_qty);
        map.put("max_qty", max_qty);
        map.put("chance", chance);

        return map;
    }
}
