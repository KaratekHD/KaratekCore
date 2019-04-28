package com.karatek.core.commands;

/*
 * Command_Test
 *
 * Version 0.2.2 RC 2
 *
 * Last Change: 0.2.2 RC 2
 *
 * Copyright Karatek_HD
 *
 * License free
 */

import com.karatek.core.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Test implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
       //check if sender is player or console
        if(sender instanceof Player) {
            //get sender
            Player p = (Player) sender;
            //send message
            if(Main.unstable) {
                p.sendMessage(Main.pre + " KaratekCore §a" + Main.version + " §r(§cunstable§r) is installed correctly on this server.");
            } else {
                p.sendMessage(Main.pre + " KaratekCore §a" + Main.version + " is installed correctly on this server.");
            }
        } else {
            //send message
            if(Main.unstable) {
                Bukkit.getConsoleSender().sendMessage("KaratekCore " + Main.version + " (unstable) is installed correctly on this server.");
            } else {
                Bukkit.getConsoleSender().sendMessage("KaratekCore " + Main.version + " is installed correctly on this server.");
            }
        }

        return false;
    }
}
