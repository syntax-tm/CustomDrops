package com.syntaxtm.CustomDrops.Utils;

public class StringUtils {

	public static String firstUpperCased(String name){
        char first = Character.toUpperCase(name.charAt(0));
        return first + name.substring(1).toLowerCase();
    }

    public static String firstAllUpperCased(String name) {
    	String[] words = name.split(" ");
    	String formattedName = "";
    
    	for (String word : words) {
    		formattedName += " " + firstUpperCased(word);
    	}
    	
        return formattedName.trim();
    }

    public static String allUpperCased(String name) {
        return name.toUpperCase();
    }
	
}
