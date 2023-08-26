package segasha.bombermob;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import segasha.bombermob.command.bomberSpawnCommand;
import segasha.bombermob.listener.interactListener;

public final class BomberMob extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommand();
        registerEvents();
    }

    private void registerCommand() {
        new bomberSpawnCommand().register();
    }

    public void registerEvents() {
        PluginManager manager = Bukkit.getPluginManager();

        manager.registerEvents(new interactListener(this), this);
    }
}
