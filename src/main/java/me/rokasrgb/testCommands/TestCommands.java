package me.rokasrgb.testCommands;

import me.rokasrgb.testCommands.commands.FeedCmd;
import me.rokasrgb.testCommands.commands.FlyCmd;
import me.rokasrgb.testCommands.commands.HealCmd;
import me.rokasrgb.testCommands.managers.FeedCooldown;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestCommands extends JavaPlugin {

    private FeedCooldown  feedCooldown;

    @Override
    public void onEnable() {
        this.getCommand("heal").setExecutor(new HealCmd());
        this.getCommand("feed").setExecutor(new FeedCmd());
        this.getCommand("fly").setExecutor(new FlyCmd());

        feedCooldown = new FeedCooldown();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public FeedCooldown getFeedCooldown() {
        return feedCooldown;
    }
}
