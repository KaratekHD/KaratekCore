package com.karatek.core.listener;

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
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class FlyListener implements Listener {

    @EventHandler
    public void onFly(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        //check permission
        if(!p.hasPermission("karatek.fly")) {
            //sendmessage and kick
            p.sendMessage(Main.pre + " Du fliegst, obwohl du keine Berrechtigungen dazu hast.");
            p.kickPlayer("§8[§4Strafe§8] §c Du wurdest §4vom Server geworfen. \n\n §eGrund: §7Du fliegst, obwohl du keine Berrechtigung dazu hast. \n\n Es sieht so aus, als würdest du einen Hackclient verwenden. \n Dieses Verhalten wurde einem §aTeamMitglied §7gemeldet.");
            Bukkit.broadcast(Main.pre + "Der Spieler §a" + p.getDisplayName() + "§r fliegt, obwohl er keine Berrechtigung dazu hat.", "karatek.teamsee");
        }

    }
}
