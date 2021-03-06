package com.karatek.core.commands;

/*
 * Command_ChatClear
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

public class Command_ChatClear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //get player
        Player p = (Player) sender;
        //check players permission
        if(!p.hasPermission("karatek.chatclear")) {
            p.sendMessage(Main.pre + " Dir fehlt die Berechtigung §akaratek.chatclear§r.");
        } else {
            //get all players and clear the chat
            for (int i= 0; i < 105; ++i) {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    if(!all.hasPermission("karatek.seechatclear")) {
                        all.sendMessage("");
                    }
                }
            }
            //send message
            Bukkit.broadcastMessage(Main.pre + " §7Der Chat wurde von §e" + p.getDisplayName() + "§7 geleert!");
        }
        return false;
    }

}
