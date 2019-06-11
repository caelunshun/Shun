package me.caelunshun.shun;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ShunUtil {
  public static void sendMessage(CommandSender sender, String msg) {
    sender.sendMessage(colorCodes(msg));
  }

  public static void print(String msg) {
    Bukkit.getConsoleSender().sendMessage(colorCodes(msg));
  }

  public static String colorCodes(String input) {
    return ChatColor.translateAlternateColorCodes('&', input);
  }
}
