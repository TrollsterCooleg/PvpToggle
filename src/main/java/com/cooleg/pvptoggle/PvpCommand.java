package com.cooleg.pvptoggle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PvpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("pvp.toggle")) {return false;}
        if (sender instanceof Player) {
            new com.cooleg.pvptoggle.Toggler().pvpGui(((Player) sender).getPlayer());
        }
        return false;
    }
}
