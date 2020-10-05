package com.beecraft.honey.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerJoinGameEvent extends Event {

    private static HandlerList handlers = new HandlerList();
    private final Player player;

    public PlayerJoinGameEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
