package segasha.bombermob.mob;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.entity.Enderman;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import segasha.bombermob.BomberMob;

import java.util.jar.Attributes;


public class Bomber {
    public Bomber(Location location, BomberMob plugin) {
        Enderman enderman = (Enderman) location.getWorld().spawnEntity(location, EntityType.ENDERMAN);

        enderman.setCustomName(ChatColor.RED + "Bomber");
        enderman.setCustomNameVisible(true);
        enderman.getEquipment().setItemInMainHand(new ItemStack(Material.TNT, 1));

        new BukkitRunnable(){

            @Override
            public void run() {
                if (enderman.isDead()){
                    return;
                }

                if (enderman.getTarget() == null) {
                    for (Entity entity : enderman.getNearbyEntities(10, 10 ,10)) {
                        if (entity instanceof Player){
                            enderman.setTarget((Player) entity);
                        }
                    }
                }

                enderman.getLocation().getWorld().spawnEntity(enderman.getLocation(), EntityType.PRIMED_TNT);
            }
        }.runTaskTimer(plugin, 100L, 100L);
    }
}
