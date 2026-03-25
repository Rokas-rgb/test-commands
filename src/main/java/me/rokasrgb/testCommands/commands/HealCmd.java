package me.rokasrgb.testCommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command");
        }

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("heal")) {

            if(!player.hasPermission("permissions.heal")) {
                player.sendMessage(ChatColor.RED + "You do not have permissions to execute this command");
            }

            player.setHealth(20);

            return true;
        }
        return true;
    }
}
