package com.karatek.core.listener.chat;

/*
 * JoinPlayerEvent
 *
 * Version 0.2.2 RC 3
 *
 * Last Change: 0.2.2 RC 2
 *
 * Copyright Karatek_HD
 *
 * License free
 */

import com.karatek.core.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class BroadcastListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        //get Player
        Player p = e.getPlayer();
        //check beginning
        if(e.getMessage().startsWith("@bc")) {
            //check senders permission
            if(!p.hasPermission("karatek.broadcast")) {
                p.sendMessage(Main.pre + " Dir fehlt die Berechtigung §akaratek.broadcast§r.");
                e.setCancelled(true);
            } else {
                //broadcast
                String bcmsgorig = e.getMessage();
                String bcmsg = bcmsgorig.replaceAll("@bc", "§a§l");
                Bukkit.broadcastMessage("-------------------" + Main.pre + "-------------------");
                Bukkit.broadcastMessage(bcmsg);
                Bukkit.broadcastMessage("-------------------" + Main.pre + "-------------------");
                e.setCancelled(true);
                p.sendMessage(Main.pre + "§r Deine Nachicht wurde ausgegeben.");
            }
        }
    }
}
