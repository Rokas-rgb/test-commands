package me.rokasrgb.testCommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCmd implements CommandExecutor {

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

            player.setFoodLevel(20);
            player.sendMessage(ChatColor.GREEN + "You have now eaten!");

            return true;
        }
        return true;
    }
}