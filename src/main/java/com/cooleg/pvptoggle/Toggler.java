package com.cooleg.pvptoggle;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Toggler {

    public void pvpGui(Player player) {
        Inventory inv = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "PVP Menu");
        ItemStack filter = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta filtermeta = filter.getItemMeta();
        filtermeta.setDisplayName(" ");
        filter.setItemMeta(filtermeta);
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, filter);
        }

        inv.setItem(4, genGui(player));

        player.openInventory(inv);

    }

    public void UpdateInventory (Player player, InventoryClickEvent e) {

        e.getInventory().setItem(4, genGui(player));

    }

    public void PvpToggle(Player p, PvpToggle pvpToggle) {
        if (p.getWorld().getPVP() == true) {
            for (World world : Bukkit.getWorlds()) {
                world.setPVP(false);
                pvpToggle.getConfig().set("pvp", false);
                pvpToggle.saveConfig();
            }
        } else {
            for (World world : Bukkit.getWorlds()) {
                world.setPVP(true);
                pvpToggle.getConfig().set("pvp", true);
                pvpToggle.saveConfig();
            }
        }
    }

    public ItemStack genGui(Player player) {
        ItemStack itemStack;
        ItemMeta meta;
        if (player.getWorld().getPVP()) {
            itemStack = new ItemStack(Material.GREEN_CONCRETE);
            meta = itemStack.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "PVP is currently enabled!");
            List<String> loreList = new ArrayList<>();
            loreList.add("Click to disable PVP");
            meta.setLore(loreList);
            itemStack.setItemMeta(meta);
        } else {
            itemStack = new ItemStack(Material.RED_CONCRETE);
            meta = itemStack.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN + "PVP is currently disabled!");
            List<String> loreList = new ArrayList<>();
            loreList.add("Click to enable PVP");
            meta.setLore(loreList);
            itemStack.setItemMeta(meta);
        }

        return itemStack;
    }

}
