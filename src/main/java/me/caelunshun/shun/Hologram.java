package me.caelunshun.shun;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;

public class Hologram {
  protected Plugin plugin;
  protected ArmorStand stand;

  public Hologram(Plugin plugin, Location loc, String text) {
    text = ChatColor.translateAlternateColorCodes('&', text);
    this.plugin = plugin;

    this.stand = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);

    stand.setGravity(false);
    stand.setCanPickupItems(false);
    stand.setCustomName(text);
    stand.setCustomNameVisible(true);
    stand.setVisible(false);
    stand.setRemoveWhenFarAway(false);
  }

  public void destroy() {
    stand.remove();
  }
}
