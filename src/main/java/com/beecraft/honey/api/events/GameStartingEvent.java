package com.beecraft.honey.api.events;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameStartingEvent extends Event {

    private static HandlerList handlers = new HandlerList();
    private int task;

    public GameStartingEvent(int task) {
        this.task = task;
    }

    public void cancelTask() {
        Bukkit.getScheduler().cancelTask(this.task);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}
