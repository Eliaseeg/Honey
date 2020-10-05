package com.beecraft.honey.runnable;

import com.beecraft.honey.Honey;

import com.beecraft.honey.messages.Messages;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class StartRunnable extends BukkitRunnable {

    private int time = Honey.getInstance().getConfig().getInt("CONFIG.START_TIME");

    @Override
    public void run() {
        String timeStr = String.valueOf(time);
        if (time == 15) Bukkit.broadcastMessage(Messages.CHAT_STARTING.get("a", "s"));
        if (time <= 10 && time > 5) Bukkit.broadcastMessage(Messages.CHAT_STARTING.get("6", "s"));
        if (time <= 5 && time > 1) {
            Bukkit.broadcastMessage(Messages.CHAT_STARTING.get("c", timeStr, "s"));
            Bukkit.getServer().getOnlinePlayers().forEach(player ->
                    player.sendTitle(Messages.TITLE_STARTING.get(String.valueOf(time)), Messages.TITLE_STARTING_SUBTITLE.get(), 2, 1, 1)
            );
        }
        if (time == 1) {
            Bukkit.broadcastMessage(Messages.CHAT_STARTING.get("c", timeStr, ""));
            Bukkit.getServer().getOnlinePlayers().forEach(player ->
                    player.sendTitle(Messages.TITLE_STARTING.get(String.valueOf(time)), Messages.TITLE_STARTING_SUBTITLE.get(), 2, 1, 1)
            );
        }
        if (time >= 0) {
            Bukkit.getServer().getOnlinePlayers().forEach(player -> player.resetTitle());
            Honey.getInstance().getAPI().getPhaseManager().nextPhase();
            this.cancel();
        }
        time--;
    }

}