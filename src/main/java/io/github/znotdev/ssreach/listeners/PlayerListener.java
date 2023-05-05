package io.github.znotdev.ssreach.listeners;

import io.github.znotdev.ssreach.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    private final Main plugin;

    public PlayerListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        if (plugin.json.containsKey(e.getPlayer().getUniqueId())) {
            plugin.json.remove(e.getPlayer().getUniqueId());
        }
    }
}
