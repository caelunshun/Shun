package me.caelunshun.shun;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UpdateChecker {
  private String resourceID;
  private String pluginName;

  private String currentVersion;
  private BukkitTask checkerTask;

  private static final String API_URL = "https://api.spigotmc.org/legacy/update.php?resource=";

  public UpdateChecker(Plugin plugin, String resourceID) {
    this.resourceID = resourceID;

    this.currentVersion = plugin.getDescription().getVersion();
    this.pluginName = plugin.getName();

    this.checkerTask =
        Bukkit.getScheduler()
            .runTaskTimerAsynchronously(plugin, this::checkForUpdates, 20, 20 * 60 * 60);
  }

  private void checkForUpdates() {
    try {
      URL url = new URL(API_URL + resourceID);

      HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      con.setReadTimeout(20 * 1000);

      con.connect();

      try (BufferedReader reader =
          new BufferedReader(new InputStreamReader(con.getInputStream()))) {
        String latestVersion = reader.readLine();

        if (latestVersion != null && !currentVersion.equals(latestVersion)) {
          Bukkit.getConsoleSender()
              .sendMessage(
                  String.format(
                      "["
                          + pluginName
                          + "] "
                          + ChatColor.AQUA
                          + "A new version (v%s) is available! Please download it from the plugin resource page.",
                      latestVersion));

          checkerTask.cancel();
        }
      }

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      // Fail silently - perhaps the server isn't connected to the Internet
    }
  }
}
