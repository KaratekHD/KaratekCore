package com.karatek.core.commands;

/*
 * Command_Version
 *
 * Version 0.2.2 RC 2
 *
 * Last Change: 0.2.2 RC 2
 *
 * Copyright Karatek_HD
 *
 * License free
 */

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.karatek.core.main.Main;

public class Command_Version implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //check if sender is player or console
        if(!(sender instanceof Player)) {
            //send version
            Bukkit.getConsoleSender().sendMessage("This Server is running KaratekCore " + Main.version + ".");
            if(Main.unstable) {
                //send message for unstable version
                Bukkit.getConsoleSender().sendMessage("This Version is unstable.");
            }
            return true;
        } else {
            //get sender
            Player p = (Player) sender;
            //send version
            p.sendMessage("This Server is running KaratekCore §a" + Main.version + "§r.");
            if(Main.unstable) {
                //send message for unstable version
                p.sendMessage("This Version is unstable.");
            }
        }
        return false;
    }

}
