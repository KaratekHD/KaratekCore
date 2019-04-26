package com.karatek.core.commands;

/*
 * Command_KVanish
 *
 * Version 0.2.2 RC 2
 *
 * Last Change: 0.2.2 RC 2
 *
 * Copyright Karatek_HD
 *
 * License free
 */

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.karatek.core.main.Main;

public class Command_KVanish implements CommandExecutor {

    ArrayList<String> vanish = new ArrayList<String>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p=(Player)sender;
        if(p.hasPermission("karatek.dev")) {
            if(args.length == 0) {
                if(vanish.contains(p.getName())) {
                    vanish.remove(p.getName());
                    p.sendMessage(Main.karatekpre + " Du bist nun für alle Spieler sichtbar.");
                    for(Player all : Bukkit.getOnlinePlayers()) {

                        all.showPlayer(p);

                    }
                } else {
                    vanish.add(p.getName());
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        all.hidePlayer(p);
                    }
                    p.sendMessage(Main.karatekpre + " Du bist nun für alle Spieler unsichtbar.");
                }
            } else if (args.length == 1){
                p.sendMessage("Falscher Syntax.");
            }
        } else {
            p.sendMessage("§rUnknown command. Type '/help' for help.");
        }
        return false;
    }

}
