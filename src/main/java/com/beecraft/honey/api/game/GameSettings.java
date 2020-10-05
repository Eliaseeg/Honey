package com.beecraft.honey.api.game;

public class GameSettings {

    private String name;
    private int maxTeamPlayers;
    private int maxPlayers;
    private int minPlayers;
    private boolean teams;
    private boolean isSet;

    public GameSettings() {}

    public GameSettings setName(String name) {
        this.name = name;
        return this;
    }

    public GameSettings setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        return this;
    }

    public GameSettings setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
        return this;
    }

    public GameSettings setTeams(boolean teams) {
        this.teams = teams;
        return this;
    }

    public GameSettings setMaxTeamPlayers(int maxTeamPlayers) {
        this.maxTeamPlayers = maxTeamPlayers;
        return this;
    }

    public GameSettings setSet(boolean set) {
        isSet = set;
        return this;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getMaxTeamPlayers() {
        return this.maxTeamPlayers;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public int getMinPlayers() {
        return this.minPlayers;
    }

    public boolean isTeams() {
        return this.teams;
    }

    public boolean isSet() {
        return this.isSet;
    }

}
