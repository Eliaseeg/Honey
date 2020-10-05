package com.beecraft.honey.api.events;

import com.beecraft.honey.api.phase.GamePhase;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PhaseChangeEvent extends Event {

    private static HandlerList handlers = new HandlerList();
    private final GamePhase phase;
    private final GamePhase oldPhase;

    public PhaseChangeEvent(GamePhase phase, GamePhase oldPhase) {
        this.phase = phase;
        this.oldPhase = oldPhase;
    }

    /**
     * Returns the new Phase the plugin it's being changed to.
     * @return
     */
    public GamePhase getNewPhase() {
        return this.phase;
    }

    /**
     * Returns the old phase the plugin it's being changed from.
     * @return
     */
    public GamePhase getOldPhase() {
        return this.oldPhase;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
