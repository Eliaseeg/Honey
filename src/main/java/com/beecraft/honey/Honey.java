package com.beecraft.honey;

import com.beecraft.honey.api.HoneyAPI;
import com.beecraft.honey.api.phase.GamePhase;
import com.beecraft.honey.listeners.GUIListener;
import com.beecraft.honey.listeners.JoinQuitListener;
import com.beecraft.honey.listeners.phases.LobbyPhaseListener;
import com.beecraft.honey.runnable.StartRunnable;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Honey extends JavaPlugin {

    private static Honey instance;
    private HoneyAPI honeyAPI;
    private BukkitRunnable startRunnable;

    @Override
    public void onEnable() {
        instance = this;

        this.getServer().getPluginManager().registerEvents(new JoinQuitListener(), this);
        this.getServer().getPluginManager().registerEvents(new GUIListener(), this);

        honeyAPI = new HoneyAPI();
        startRunnable = new StartRunnable();
        createLobbyPhase();
    }

    public static Honey getInstance() {
        return instance;
    }

    public HoneyAPI getAPI() {
        return honeyAPI;
    }

    public BukkitRunnable getStartRunnable() {
        return startRunnable;
    }

    private void createLobbyPhase() {
        GamePhase lobby = new GamePhase("Lobby", new LobbyPhaseListener());
        honeyAPI.getPhaseManager().addPhase(lobby);
    }

}