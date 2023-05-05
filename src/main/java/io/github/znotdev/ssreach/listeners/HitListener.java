package io.github.znotdev.ssreach.listeners;

import eu.vortexdev.api.KnockbackAPI;
import io.github.znotdev.ssreach.Main;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class HitListener implements Listener {

    private Main plugin;

    public void applyKnockback(Player player, double horizontal, double vertical) {
        Vector knockbackVelocity = player.getLocation().getDirection().multiply(horizontal).setY(vertical);
        player.setVelocity(knockbackVelocity);
    }

    public HitListener(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void PlayerLeftClick (PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            Player player = e.getPlayer();
            Integer dist;

            if (!plugin.json.containsKey(player.getUniqueId())) {return;} else {dist = (Integer) plugin.json.get(player.getUniqueId());}

            for (Entity entity : player.getNearbyEntities(dist, dist, dist)) {
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
                        Double hzt = KnockbackAPI.getDefault().horizontal.getValue();
                        Double vtl = KnockbackAPI.getDefault().vertical.getValue();
                        applyKnockback(toBeDamaged, hzt, vtl);
                        return;
                    }
                }
            }
        }
    }
}
