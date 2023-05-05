package io.github.znotdev.ssreach.commands;

import io.github.znotdev.ssreach.Main;
import io.github.znotdev.ssreach.util.MessageUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        if (args.length < 1) {
            List<String> strings = new ArrayList<>(Arrays.asList(
                    "&r",
                    "&7&oUsage: &c/distance <player> <distance>",
                    "&r"
            ));
            MessageUtil.sendListMessage(player, strings);
        }

        return false;
    }
}
