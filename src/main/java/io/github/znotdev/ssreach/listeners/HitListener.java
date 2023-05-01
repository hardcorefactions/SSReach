package io.github.znotdev.ssreach.listeners;

import eu.vortexdev.api.KnockbackAPI;
import eu.vortexdev.api.knockback.KnockbackProfile;
import io.github.znotdev.ssreach.Main;
import jdk.nashorn.internal.ir.Block;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

public class HitListener implements Listener {

    private Main plugin;

    public HitListener(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void PlayerLeftClick (PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            Player player = e.getPlayer();
            for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
                if (entity instanceof Player && entity.getLocation().distanceSquared(player.getLocation()) <= 25) {
                    Vector toEntity = entity.getLocation().subtract(player.getEyeLocation()).toVector().normalize();
                    Vector direction = player.getEyeLocation().getDirection().normalize();
                    double angle = Math.toDegrees(Math.acos(toEntity.dot(direction)));

                    plugin.log(angle + " | " + direction);
                    if (angle <= 26) {
                        Player toBeDamaged = (Player)entity;
                        if (player.getLocation().distance(toBeDamaged.getLocation()) <= 3) {
                            return;
                        }
                        toBeDamaged.damage(1.0);
                        KnockbackAPI.applyKnockback(KnockbackAPI.getDefault(), toBeDamaged);
                        return;
                    }
                }
            }
        }
    }
}
