package me.caelunshun.shun;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

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

  public static void sendPluginInfoMessage(CommandSender sender, Plugin plugin) {
    sendMessage(
        sender,
        String.format(
            ChatColor.GRAY
                + "--------"
                + ChatColor.AQUA
                + ChatColor.BOLD
                + plugin.getName()
                + ChatColor.GRAY
                + "--------\n"
                + ChatColor.AQUA
                + "Version: "
                + ChatColor.GRAY
                + plugin.getDescription().getVersion()
                + ChatColor.AQUA
                + "\nAuthor: "
                + ChatColor.GRAY
                + plugin.getDescription().getAuthors().get(0)));
  }
}
