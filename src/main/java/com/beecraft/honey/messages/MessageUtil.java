package com.beecraft.honey.messages;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class MessageUtil {

    /**
     * Translates the '&' character into its respective colour code.
     *
     * @param message - The original string to be converted.
     * @return string - Translated with Colour Codes
     */
    public static String colorMessage(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    /**
     * Translates the '&' character into its respective colour code.
     * @param messages - The original list of strings to be converted.
     * @return list - The new list with Colour codes.
     */
    public static List<String> colorMessage(List<String> messages) {
        List<String> buffered = new ArrayList<>();
        for (String message : messages){
            buffered.add(colorMessage("&r" + message));
        }
        return buffered;
    }

    /**
     * Formats a given string with the given arguments.
     * @param message - Message to format.
     * @param args - Arguments to replace with.
     * @return string - The formatted string with color codes.
     */
    public static String format(String message, String... args) {
        return colorMessage(String.format(message, args));
    }

    /**
     * Capitalizes the First Letter of any String.
     *
     * @param original - This is the original non-capitalised string.
     * @return result - Will return the String instead with the first letter capitalised.
     */
    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

}
