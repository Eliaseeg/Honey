package com.beecraft.honey.api;

import com.beecraft.honey.api.game.GameSettings;
import com.beecraft.honey.api.game.KitHandler;
import com.beecraft.honey.api.phase.PhaseManager;

public class HoneyAPI {

    private PhaseManager phaseManager;
    private GameSettings gameSettings;
    private KitHandler kitHandler;

    public HoneyAPI() {
        phaseManager = new PhaseManager();
        gameSettings = new GameSettings();
        kitHandler = new KitHandler();
    }

    public PhaseManager getPhaseManager() {
        return this.phaseManager;
    }

    public GameSettings getGameSettings() {
        return this.gameSettings;
    }

    public KitHandler getKitHandler() {
        return this.kitHandler;
    }

}