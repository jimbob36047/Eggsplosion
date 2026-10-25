package com.github.jimbob36047.eggsplosion;

import com.github.jimbob36047.eggsplosion.Listeners.EggsplodeListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // plugin enable logic
        // log that its enabled
        getSLF4JLogger().info("Plugin Enabled");
        getSLF4JLogger().info("version: " + getDescription().getVersion());

        // config file stuff
        saveDefaultConfig();
        getConfig();

        //
        getServer().getPluginManager().registerEvents(new EggsplodeListener(this), this);

        // bStats stuff, idk what this stuff does
        int pluginId = 34947;
        Metrics metrics = new Metrics(this, pluginId);
    }

    @Override
    public void onDisable() {
        // plugin disable logic
        // log that its disabled
        getSLF4JLogger().info("Plugin Disabled");
        getSLF4JLogger().info("bye bye");
    }
}
