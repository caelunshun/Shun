package me.caelunshun.shun;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Shun {
  protected Plugin plugin;

  public Shun(Plugin plugin) {
    this.plugin = plugin;
  }

  public void init() {
    Bukkit.getPluginManager().registerEvents(new ShunEventListener(), plugin);
  }
}
