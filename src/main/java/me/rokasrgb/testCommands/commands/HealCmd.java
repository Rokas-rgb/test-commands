package me.rokasrgb.testCommands.commands;

import me.rokasrgb.testCommands.TestCommands;
import me.rokasrgb.testCommands.managers.HealCooldown;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCmd implements CommandExecutor {


    private TestCommands plugin;

    public HealCmd(TestCommands plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command");
        }

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("heal")) {

            if (args.length < 1) {
                if (!player.hasPermission("permissions.heal")) {
                    player.sendMessage(ChatColor.RED + "You do not have permissions to execute this command");
                }

                player.setHealth(20);

                return true;
            } else {
                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if (target == null) {
                    player.sendMessage(ChatColor.RED + "That player is not online");
                } else {
                    target.setHealth(20);
                    player.sendMessage(ChatColor.GREEN + "You have been healed by" + player.getDisplayName() + "!");
                }
            }

            HealCooldown healCooldown = plugin.getHealCooldown();

            if(healCooldown.onCooldown(player, 3600)) {
                player.sendMessage(ChatColor.RED + "You are on cooldown!: " + healCooldown.getRemaining(player, 3600));
                return false;
            }
        }
        return true;
    }
}
