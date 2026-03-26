package me.rokasrgb.testCommands.commands;

import me.rokasrgb.testCommands.TestCommands;
import me.rokasrgb.testCommands.managers.FeedCooldown;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCmd implements CommandExecutor {

    private TestCommands plugin;

    public FeedCmd(TestCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
        }
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("feed")) {

            if(!player.hasPermission("permissions.feed")) {
                player.sendMessage(ChatColor.RED + "You do not have permissions to execute this command!");
                return true;
            }

            FeedCooldown feedCooldown = plugin.getFeedCooldown();

            if(feedCooldown.onCooldown(player, 3600)) {
             player.sendMessage(ChatColor.RED + "You are on cooldown!: " + feedCooldown.getRemaining(player, 3600));
             return true;
            }

            player.setFoodLevel(20);
            player.sendMessage(ChatColor.GREEN + "You have now eaten!");

            feedCooldown.setCooldown(player);

            return true;
        }
        return true;
    }
}