package me.rokasrgb.testCommands;

import me.rokasrgb.testCommands.commands.FeedCmd;
import me.rokasrgb.testCommands.commands.FlyCmd;
import me.rokasrgb.testCommands.commands.HealCmd;
import me.rokasrgb.testCommands.managers.FeedCooldown;
import me.rokasrgb.testCommands.managers.HealCooldown;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestCommands extends JavaPlugin {

    private FeedCooldown  feedCooldown;
    private  HealCooldown  healCooldown;

    @Override
    public void onEnable() {
        this.getCommand("heal").setExecutor(new HealCmd(this));
        this.getCommand("feed").setExecutor(new FeedCmd(this));
        this.getCommand("fly").setExecutor(new FlyCmd());

        feedCooldown = new FeedCooldown();
        healCooldown = new HealCooldown();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public FeedCooldown getFeedCooldown() {
        return feedCooldown;
    }

    public HealCooldown getHealCooldown() {
        return healCooldown;
    }
}
