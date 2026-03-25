package me.rokasrgb.testCommands.listeners;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class EndDragonKill implements Listener {

    @EventHandler
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent event) {

        if(event.getAdvancement().getKey().toString().equals("minecraft:end/kill_dragon")) {
            Player player = event.getPlayer();

            LuckPerms perms = LuckPermsProvider.get();

            User user = perms.getUserManager().getUser(player.getUniqueId());

            Node node = Node.builder("permissions.fly").build();

            user.data().add(node);

            perms.getUserManager().saveUser(user);
        }
    }
}
