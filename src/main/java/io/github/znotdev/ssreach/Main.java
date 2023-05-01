package io.github.znotdev.ssreach;

import eu.vortexdev.api.SpigotAPI;
import io.github.znotdev.ssreach.commands.DistanceCommand;
import io.github.znotdev.ssreach.listeners.HitListener;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void log(String t) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', t));
    }

    public void loadCommands() {
        getCommand("distance").setExecutor(new DistanceCommand(this));
    }

    public void loadListeners() {
        getServer().getPluginManager().registerEvents(new HitListener(this), this);
    }

    @Override
    public void onEnable() {
        log(StringUtils.repeat("&7"+"-", 24));
        log("&a&lServer Side Reach");
        log("&r");
        log("&7Made by @zNotDeev on GitHub");
        log(StringUtils.repeat("&7"+"-", 24));
        loadCommands();
        loadListeners();
    }
}
