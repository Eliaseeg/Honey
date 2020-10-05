package com.beecraft.honey.listeners;

import com.beecraft.honey.Honey;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        FileConfiguration config = Honey.getInstance().getConfig();

        if (!(item.hasItemMeta())) return;
        if (item.getType() != Material.valueOf(config.getString("ITEMS.QUIT.MATERIAL"))) return;

        ItemMeta meta = item.getItemMeta();
        if (!(meta.hasDisplayName())) return;
        if (!(meta.getDisplayName().equals(config.getString("ITEMS.QUIT.NAME")))) return;

        System.out.println("Clicked lobby item");
    }

}