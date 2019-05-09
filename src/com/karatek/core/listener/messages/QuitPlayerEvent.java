package com.karatek.core.listener.messages;

/*
 * QuitPlayerEvent
 *
 * Version 0.2.2 RC 3
 *
 * Last Change: 0.2.2 RC 2
 *
 * Copyright Karatek_HD
 *
 * License free
 */

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitPlayerEvent implements Listener {

    @EventHandler
    public void onQuit (PlayerQuitEvent e) {
        Player p = e.getPlayer();
        String name = p.getDisplayName();
        System.out.println("Der Spieler " + name + " hat die Verbindung getrennt. ");
        e.setQuitMessage("§8[§4-§8] " + name);
    }

}
