package com.beecraft.honey.listeners.phases;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

// Lobby phase
public class LobbyPhaseListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
         event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        event.setCancelled(true);
    }

}