package com.beecraft.honey.api.game;

import com.beecraft.honey.Honey;
import me.mattstudios.mfgui.gui.guis.Gui;
import me.mattstudios.mfgui.gui.guis.GuiItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class KitHandler {

    public Gui gui;
    public List<Kit> kits = new ArrayList<>();

    public KitHandler() {
        this.gui = new Gui(6, Honey.getInstance().getAPI().getGameSettings().getName() + " Kits!");
        this.gui.setDefaultClickAction(event -> event.setCancelled(true));
    }

    public void addKit(Kit kit) {
        this.kits.add(kit);
    }

    public Kit getKit(int index) {
        return this.kits.get(index);
    }

    public List<Kit> getKits() {
        return this.kits;
    }

    public void openGUI(Player player) {
        kits.forEach(kit -> {
            if (player.hasPermission(kit.getPermission()))
                this.gui.addItem(kit.getGuiItem());
            else
                this.gui.addItem(new GuiItem(Material.RED_STAINED_GLASS_PANE));
        });
        this.gui.open(player);
    }

}
