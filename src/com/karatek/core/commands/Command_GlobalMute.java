package com.karatek.core.commands;

/*
 * Command_GlobalMute
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

public class Command_GlobalMute implements CommandExecutor {

    public static boolean globalmute = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String labels, String[] args) {

        //check if sender is a player
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + " Du musst ein Spieler sein.");
        } else {

            //get player
            Player p = (Player)sender;

            //check the players permissions
            if(!(p.hasPermission("karatek.globalmute"))) {
                p.sendMessage("§c Dir fehlt die Berechtigung §akaratek.globalmute§c.");
                return true;
            }
            //disable globalmute
            if(globalmute) {
                globalmute = false;
                Bukkit.broadcastMessage(Main.pre + "§r Der Globale Chat wurde von " + p.getDisplayName() + " §4aktiviert.");
            } else {
                //enable globalmute
                globalmute = true;
                Bukkit.broadcastMessage(Main.pre + "§r Der Globale Chat wurde von " + p.getDisplayName() + " §4deaktiviert!");
            }

        }

        return false;
    }

}
