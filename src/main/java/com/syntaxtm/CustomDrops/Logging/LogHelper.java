package com.syntaxtm.CustomDrops.Logging;

import org.bukkit.plugin.java.JavaPlugin;

public final class LogHelper
{
	// TODO: move constants here to config.yml
	private final static boolean LOG_TRACE = false;
	private final static boolean LOG_DEBUG = false;
	private final static boolean LOG_INFO = false;
	
	private static JavaPlugin plugin;
	
	public static void setPlugin(JavaPlugin bukkitPlugin) {
		plugin = bukkitPlugin;
	}
	
	public static void trace(String message)
	{
		if (message == null) throw new IllegalArgumentException("String message cannot be null");
		
		if (LOG_TRACE) {
			plugin.getLogger().finer(message);
		}
	}
	
	public static void debug(String message)
	{
		if (message == null) throw new IllegalArgumentException("String message cannot be null");
		
		if (LOG_DEBUG) {
			plugin.getLogger().fine(message);
		}
	}
	
	public static void info(String message)
	{
		if (message == null) throw new IllegalArgumentException("String message cannot be null");
		
		if (LOG_INFO) {
			plugin.getLogger().info(message);
		}
	}
	
	public static void warn(String message)
	{
		if (message == null) throw new IllegalArgumentException("String message cannot be null");
		
		plugin.getLogger().warning(message);
	}
	
	public static void error(String message, Exception e)
	{
		if (message == null) throw new IllegalArgumentException("String message cannot be null");
		if (e == null) throw new IllegalArgumentException("Exception e cannot be null");
		
		String logMessage = "An unhandled exception occurred in BlockBreakEventListener. " + message;
		logMessage += "\r\n" + e.getMessage() + "\r\n" + e.getStackTrace().toString();
		
		plugin.getLogger().severe(logMessage);
	}	
	
}
