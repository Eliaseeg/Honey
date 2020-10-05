package com.beecraft.honey.listeners;

import com.beecraft.honey.Honey;
import com.beecraft.honey.api.phase.GamePhase;
import com.beecraft.honey.api.util.ItemBuilder;
import com.beecraft.honey.api.events.PlayerJoinGameEvent;
import com.beecraft.honey.listeners.phases.FinishedPhaseListener;

import com.beecraft.honey.messages.MessageUtil;
import com.beecraft.honey.messages.Messages;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class JoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!(Honey.getInstance().getAPI().getGameSettings().isSet())) return;
        int currentPlayers = (Bukkit.getServer().getOnlinePlayers().size() + 1);
        int minPlayers = Honey.getInstance().getAPI().getGameSettings().getMinPlayers();
        int maxPlayers = Honey.getInstance().getAPI().getGameSettings().getMaxPlayers();

        if (currentPlayers == minPlayers) {
            Honey.getInstance().getStartRunnable().runTaskTimer(Honey.getInstance(),1l, 20l);
            Honey.getInstance().getAPI().getPhaseManager().addPhase(new GamePhase("Finishing", new FinishedPhaseListener())); // Adding finished phase listener before game actually starts.
        }

        ItemStack quitItem = new ItemBuilder(Material.valueOf(Honey.getInstance().getConfig().getString("ITEMS.QUIT.MATERIAL")))
                            .title(MessageUtil.colorMessage(Honey.getInstance().getConfig().getString("ITEMS.QUIT.NAME")))
                            .lores(MessageUtil.colorMessage(Honey.getInstance().getConfig().getStringList("ITEMS.QUIT.LORE")))
                            .build();

        Player player = event.getPlayer();
        player.sendMessage(MessageUtil.format(Messages.CHAT_JOIN_GAME.get(player.getName(), String.valueOf(currentPlayers), String.valueOf(maxPlayers))));
        player.getInventory().setItem(8, quitItem);

        Honey.getInstance().getAPI().getPhaseManager().getCurrentPhase().showScoreboard(player);
        Bukkit.getServer().getPluginManager().callEvent(new PlayerJoinGameEvent(player));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (!(Honey.getInstance().getAPI().getGameSettings().isSet())) return;
        int currentPlayers = (Bukkit.getServer().getOnlinePlayers().size() + 1);
        int minPlayers = Honey.getInstance().getAPI().getGameSettings().getMinPlayers();
        int maxPlayers = Honey.getInstance().getAPI().getGameSettings().getMaxPlayers();

        if (currentPlayers < minPlayers) {
            Honey.getInstance().getStartRunnable().cancel();
        }

        Bukkit.broadcastMessage(MessageUtil.format(Messages.CHAT_QUIT_GAME.get(event.getPlayer().getName(), String.valueOf(currentPlayers), String.valueOf(maxPlayers))));
    }

}