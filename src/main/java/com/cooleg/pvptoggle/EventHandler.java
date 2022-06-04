package com.cooleg.pvptoggle;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EventHandler implements Listener {

    PvpToggle pvpToggle;
    public EventHandler(PvpToggle pvpToggle) {
        this.pvpToggle = pvpToggle;
    }

    @org.bukkit.event.EventHandler
    public void onClick(InventoryClickEvent e) {
        if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.DARK_GREEN + "PVP Menu") && e.getCurrentItem() != null) {
            if (e.getRawSlot() == 4) {
                Player p = (Player) e.getWhoClicked();
                Toggler toggler = new com.cooleg.pvptoggle.Toggler();
                toggler.PvpToggle(p, pvpToggle);
                toggler.UpdateInventory(p, e);
            }
            e.setCancelled(true);
        }
    }

}
