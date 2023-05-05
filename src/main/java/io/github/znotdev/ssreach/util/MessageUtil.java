package io.github.znotdev.ssreach.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class MessageUtil {
    public static void sendListMessage(CommandSender sender, List<String> msg) {
        msg.forEach(line -> sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line)));
    }
}
