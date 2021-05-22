package com.syntaxtm.CustomDrops.Utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;

import com.syntaxtm.CustomDrops.Logging.LogHelper;

public final class PlayerUtils
{
	// TODO: move constants here to config.yml
	private final static boolean USE_EXP_MULTIPLIER = true;
	
	public static void addExpToPlayer(Player player, int exp) {
		if (player == null) throw new IllegalArgumentException("Player player cannot be null");
		if (exp < 0) throw new IllegalArgumentException("int exp must be greater than 0");
		
		addExpToPlayer(player, exp, 1);
	}
	
	public static void addExpToPlayer(Player player, int exp, int multiplier) {
		if (player == null) throw new IllegalArgumentException("Player player cannot be null");
		if (exp < 0) throw new IllegalArgumentException("int exp must be greater than 0");
		if (multiplier < 0) throw new IllegalArgumentException("int multiplier must be greater than 0");
		
		Location loc = player.getLocation();
		World world = player.getWorld();
		 
		// if not using the multiplier only drop one orb
		if (!USE_EXP_MULTIPLIER) multiplier = 1;
		
		for (int i = 0; i < multiplier; i++) {
			ExperienceOrb orb = world.spawn(loc, ExperienceOrb.class);
			orb.setExperience(1);
		}
		
        LogHelper.debug("Dropped " + multiplier + " orbs at " + exp + " exp each.");
	}	
}
