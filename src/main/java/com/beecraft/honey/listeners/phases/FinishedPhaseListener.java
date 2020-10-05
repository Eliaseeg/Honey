package com.beecraft.honey.listeners.phases;

import com.beecraft.honey.api.events.PhaseChangeEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class FinishedPhaseListener implements Listener {

    @EventHandler
    public void onPhaseChange(PhaseChangeEvent event) {
        System.out.println(event.getNewPhase().getName().toUpperCase());
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        event.setCancelled(true);
    }


}