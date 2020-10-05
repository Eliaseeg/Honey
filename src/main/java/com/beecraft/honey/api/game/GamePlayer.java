package com.beecraft.honey.api.game;

import org.bukkit.entity.Player;

public class GamePlayer {

    private Kit kit;
    private Player player;

    public GamePlayer(Player player) {
        this.player = player;
    }

    public Kit getKit() {
        return this.kit;
    }

}