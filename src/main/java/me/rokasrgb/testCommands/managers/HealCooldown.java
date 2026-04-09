package me.rokasrgb.testCommands.managers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class HealCooldown {

    private final HashMap<UUID, Long> cooldowns = new HashMap<>();

    public boolean onCooldown(Player player, int seconds) {
        if(!cooldowns.containsKey(player.getUniqueId())) {
            return false;
        }

        long lastUsed = cooldowns.get(player.getUniqueId());
        long timePassed = (System.currentTimeMillis() - lastUsed) /  1000;

        return timePassed < seconds;
    }

    public void setCooldown(Player player) {
        cooldowns.put(player.getUniqueId(), System.currentTimeMillis());
    }

    public long getRemaining(Player player, int seconds) {
        long lastUsed = cooldowns.get(player.getUniqueId());
        long timePassed = (System.currentTimeMillis() - lastUsed) /  1000;
        return timePassed - seconds;
    }
}
