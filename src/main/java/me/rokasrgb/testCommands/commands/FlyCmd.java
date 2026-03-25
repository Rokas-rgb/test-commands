package me.rokasrgb.testCommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("fly")) {
            if(!player.hasPermission("fly")) {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            }

                if(player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.sendMessage(ChatColor.RED + "Flying disabled!");
                }else {
                    player.setAllowFlight(true);
                    player.sendMessage(ChatColor.GREEN + "Flying enabled!");
            }
             return true;
        }
        return true;
    }
}