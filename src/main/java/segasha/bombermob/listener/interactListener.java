package segasha.bombermob.listener;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import segasha.bombermob.BomberMob;
import segasha.bombermob.mob.Bomber;

public class interactListener implements Listener {

    private final BomberMob plugin;

    public interactListener(BomberMob plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (e.getHand() != null && e.getHand() == EquipmentSlot.HAND){
                if (e.getItem() != null && e.getItem().getItemMeta() != null
                && e.getItem().getItemMeta().getLore() != null &&
                e.getItem().getItemMeta().getLore().contains(ChatColor.GRAY + "Spawn a bomber mob ")){
                    Location spawnLocation;
                    if (e.getClickedBlock().isPassable()){
                        spawnLocation = e.getClickedBlock().getLocation().add(0.5, 0, 0.5);
                    } else {
                        spawnLocation = e.getClickedBlock().getRelative(e.getBlockFace()).getLocation().add(0.5, 0, 0.5);
                    }
                    new Bomber(spawnLocation, plugin);
                    if (e.getPlayer().getGameMode() != GameMode.CREATIVE){
                        e.getItem().setAmount(e.getItem().getAmount() - 1);
                    }
                    e.setCancelled(true);
                }
            }
        }
    }
}
