package me.rokasrgb.testCommands;

import me.rokasrgb.testCommands.commands.FeedCmd;
import me.rokasrgb.testCommands.commands.FlyCmd;
import me.rokasrgb.testCommands.commands.HealCmd;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("heal").setExecutor(new HealCmd());
        this.getCommand("feed").setExecutor(new FeedCmd());
        this.getCommand("fly").setExecutor(new FlyCmd());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
