package com.karatek.core.listener.chat;

/*
 * TeamChatListener
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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class TeamChatListener implements Listener {

    @EventHandler

    public void onChat(AsyncPlayerChatEvent e) {
        //get Player
        Player p = e.getPlayer();
        //check beginning
        if(e.getMessage().startsWith("@team")) {
            //check permission
            if(p.hasPermission("karatek.teamsend")) {
                //broadcast
                String prefix = "§f[§4§lTEAMCHAT§r§f]";
                String msg = e.getMessage();
                Bukkit.broadcast(prefix + " " + p.getName() + " §8 >> " + msg.replaceAll("@team", "§r"), "karatek.teamsee");
                e.setCancelled(true);
            }
        }
    }
}
