package com.infinitycraft.plugin.general.tools.text;

import org.bukkit.ChatColor;

public class ColorCoder {
    /**
     * A quick and easy way to convert color codes
     * @param text The text with color codes to be converted
     * @return The text with the color codes converted
     */
    public static String convertColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}