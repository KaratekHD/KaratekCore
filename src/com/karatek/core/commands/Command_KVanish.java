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

        //get player
        Player p=(Player)sender;
        //check players permission
        if(p.hasPermission("karatek.dev")) {
            if(args.length == 0) {
                //unvanish player if he is vanished already
                if(vanish.contains(p.getName())) {
                    //remove player from arraylist
                    vanish.remove(p.getName());
                    //send message
                    p.sendMessage(Main.karatekpre + " Du bist nun für alle Spieler sichtbar.");
                    //get all online players
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        //unvanish sender
                        all.showPlayer(p);

                    }
                } else {
                    //vanish player by adding him to the ArrayList
                    vanish.add(p.getName());
                    //get all players
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        //hide sender
                        all.hidePlayer(p);
                    }
                    //send message
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
