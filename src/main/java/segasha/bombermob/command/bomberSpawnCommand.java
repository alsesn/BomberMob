package segasha.bombermob.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import segasha.bombermob.utils.CommandHandler;

import java.util.Arrays;

@CommandInfo(name = "bomber", requiresPlayer = true)
public class bomberSpawnCommand extends CommandHandler {
    @Override
    protected boolean execute(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack egg = new ItemStack(Material.ENDERMAN_SPAWN_EGG);
            ItemMeta eggMeta = egg.getItemMeta();
            eggMeta.setDisplayName(ChatColor.RED + "Bomber");
            eggMeta.setLore(Arrays.asList(ChatColor.GRAY + "Spawn a bomber mob "));
            egg.setItemMeta(eggMeta);

            player.getInventory().addItem(egg);
        }
        return true;
    }

    @Override
    protected boolean help(CommandSender sender, String label) {
        return false;
    }
}
