package com.karatek.core.listener.chat;

/*
 * GlobalMuteListener
 *
 * Version 0.2.2 RC 2
 *
 * Last Change: 0.2.2 RC 2
 *
 * Copyright Karatek_HD
 *
 * License free
 */

import com.karatek.core.commands.Command_GlobalMute;
import com.karatek.core.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class GlobalMuteListener implements Listener {

    @EventHandler

    public void onChat(AsyncPlayerChatEvent e) {
        //check variable
        if(Command_GlobalMute.globalmute) {
            //check permission for bypqaa
            if(e.getPlayer().hasPermission("karatek.globalmute.bypass")) {
                return;
            }
            //sendMessage and cancel event
            e.getPlayer().sendMessage(Main.pre + "§8 Zuerzeit ist der Chat §4deaktiviert!");
            e.setCancelled(true);
        }
    }
}
