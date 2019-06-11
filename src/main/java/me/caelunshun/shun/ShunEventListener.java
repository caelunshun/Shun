package me.caelunshun.shun;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class ShunEventListener implements Listener {
  @EventHandler
  public void onArmorStandInteract(PlayerArmorStandManipulateEvent event) {
    // Prevent players from placing armor on a hologram
    if (!event.getRightClicked().isVisible()) {
      event.setCancelled(true);
    }
  }
}
