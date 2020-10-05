package com.beecraft.honey.api.phase;

import com.beecraft.honey.Honey;
import com.beecraft.honey.api.events.PhaseChangeEvent;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;

import java.util.ArrayList;
import java.util.List;

public class PhaseManager {

    private List<GamePhase> phases = new ArrayList<GamePhase>();
    private GamePhase currentPhase;

    public List<GamePhase> getPhases() {
        return phases;
    }

    public void addPhase(GamePhase phase) {
        this.phases.add(phase);
    }

    public GamePhase fromName(String name) {
        return phases.stream().filter(gamePhase -> gamePhase.getName().equals(name)).findFirst().orElse(null);
    }

    public GamePhase getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(GamePhase newPhase) {
        Bukkit.getServer().getPluginManager().callEvent(new PhaseChangeEvent(newPhase, this.currentPhase));
        Bukkit.getServer().getPluginManager().registerEvents(newPhase.getListener(), Honey.getInstance());
        HandlerList.unregisterAll(this.currentPhase.getListener());
        this.currentPhase = newPhase;
    }

    public void nextPhase() {
        GamePhase newPhase = phases.get(phases.indexOf(this.currentPhase) + 1);
        Bukkit.getServer().getPluginManager().callEvent(new PhaseChangeEvent(newPhase, this.currentPhase));
        Bukkit.getServer().getPluginManager().registerEvents(newPhase.getListener(), Honey.getInstance());
        HandlerList.unregisterAll(this.currentPhase.getListener());
        this.currentPhase = newPhase;
        Bukkit.getOnlinePlayers().forEach(player -> this.currentPhase.showScoreboard(player));
    }

}