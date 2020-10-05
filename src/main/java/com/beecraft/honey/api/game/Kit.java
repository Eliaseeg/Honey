package com.beecraft.honey.api.game;

import com.beecraft.honey.messages.MessageUtil;

import me.mattstudios.mfgui.gui.components.GuiAction;
import me.mattstudios.mfgui.gui.components.ItemBuilder;
import me.mattstudios.mfgui.gui.guis.GuiItem;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Kit {

    private String name;

    private Material placeholder;
    private String title;
    private List<String> lore;
    private boolean glow;

    private List<ItemStack> items;
    private GuiAction<InventoryClickEvent> action;
    private GuiItem guiItem;

    private String permission;

    public Kit(String name) {
        this.name = name;
    }

    public void setPlaceholder(Material placeholder) {
        this.placeholder = placeholder;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public void setGlow(boolean glow) {
        this.glow = glow;
    }

    public void setItems(List<ItemStack> items) {
        this.items = items;
    }

    public void setAction(GuiAction<InventoryClickEvent> action) {
        this.action = action;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }

    public Kit build() {
        this.guiItem = ItemBuilder.from(this.placeholder)
                .setName(MessageUtil.colorMessage(this.name))
                .setLore(MessageUtil.colorMessage(this.lore))
                .glow(this.glow).asGuiItem(this.action);
        return this;
    }

    public GuiItem getGuiItem() {
        return this.guiItem;
    }

}