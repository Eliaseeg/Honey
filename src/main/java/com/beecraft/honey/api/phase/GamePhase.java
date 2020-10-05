package com.beecraft.honey.api.phase;

import com.beecraft.honey.api.util.ScoreboardHelper;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GamePhase {

    private String name;
    private ScoreboardHelper scoreboard;
    private Listener listener;

    public GamePhase(String name, Listener listener) {
        this.name = name;
        this.listener = listener;
    }

    public String getName() { return this.name; }

    public Listener getListener() {
        return this.listener;
    }

    public void showScoreboard(Player player) {
        if (this.scoreboard != null) {
            this.scoreboard.display(player);
            return;
        }
        System.out.println("Scoreboard : " + this.name + " is null!");
    }

    public void setScoreboard(ScoreboardHelper scoreboard) {
        this.scoreboard = scoreboard;
    }

    /*
    public void showScoreboard(Player player) {
        if (this.scoreboard == null) return;
        this.scoreboard.display(player);
    }*/

}
