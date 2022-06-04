package com.cooleg.pvptoggle;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class PvpToggle extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        boolean pvp = getConfig().getBoolean("pvp");
        for (World world : Bukkit.getWorlds()) {
            world.setPVP(pvp);
        }
        getCommand("pvp").setExecutor(new PvpCommand());
        Bukkit.getPluginManager().registerEvents(new EventHandler(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
