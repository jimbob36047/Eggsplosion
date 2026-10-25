package com.github.jimbob36047.eggsplosion.Listeners;

import com.github.jimbob36047.eggsplosion.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import java.util.List;

public class EggsplodeListener implements Listener {

    private final Main plugin;

    public EggsplodeListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerEggThrow(PlayerEggThrowEvent event) {

        // if "enable-explosion" is "false" just do nothing i guess
        if (!this.plugin.getConfig().getBoolean("enable-explosion")) {
            return;
        }

        // sees if player is in creative. if not in creative, do nothing i guess
        Player player = event.getPlayer();
        if (player.getGameMode() != GameMode.CREATIVE) {
            return;
        }

        // gets the uuids in the config file or smth idk
        List<String> allowedUuids = this.plugin.getConfig().getStringList("allowed-uuids");
        String uuid = player.getUniqueId().toString();

        // if the uuid of egg thrower isnt in config file, do nothing
        if (!allowedUuids.contains(uuid)) {
            return;
        }

        // if "enable-explosion" is true, player is in creative and their uuid in config file, egg goes boom
        int size = this.plugin.getConfig().getInt("explosion-power");
        event.setHatching(false);
        event.getEgg().getLocation().createExplosion(size);
    }

}
