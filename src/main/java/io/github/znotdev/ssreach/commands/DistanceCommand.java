package io.github.znotdev.ssreach.commands;

import io.github.znotdev.ssreach.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DistanceCommand implements CommandExecutor {
    private Main plugin;

    public DistanceCommand(Main plugin) {
        this.plugin = plugin;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cOnly players."));
            return false;
        }
        Player player = (Player)sender;
        if (!player.hasPermission("ssreach.distance")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNo permissions."));
            return false;
        }

        return false;
    }
}
