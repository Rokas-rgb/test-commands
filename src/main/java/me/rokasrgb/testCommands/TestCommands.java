package me.rokasrgb.testCommands;

import org.bukkit.plugin.java.JavaPlugin;

public final class TestCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("heal").setExecutor(new TestCommands());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
