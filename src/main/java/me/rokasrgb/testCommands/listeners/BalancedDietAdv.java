package me.rokasrgb.testCommands.listeners;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class BalancedDietAdv implements Listener {

    @EventHandler
    public void onBalancedDietAdv(PlayerAdvancementDoneEvent event) {

        if(event.getAdvancement().getKey().toString().equals("minecraft:husbandry/balanced_diet")) {

            Player player = event.getPlayer();

            LuckPerms perms = LuckPermsProvider.get();

            User user = perms.getUserManager().getUser(player.getUniqueId());

            Node node = Node.builder("permissions.feed").build();

            user.data().add(node);

            perms.getUserManager().saveUser(user);
        }
    }
}
