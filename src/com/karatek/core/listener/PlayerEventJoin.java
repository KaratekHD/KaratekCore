package com.karatek.core.listener;

/*
 * PlayerEventJoin
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

import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;


public class PlayerEventJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(p.hasPermission("karatek.silentjoin")) {
            e.setJoinMessage("");
        } else {
            e.setJoinMessage("§8[§a+§8] §8" + p.getDisplayName());
        }
        p.sendMessage(Main.loginprefix + " Deine Daten werden verarbeitet");
        PermissionUser pexuser = PermissionsEx.getUser(p);
        if(pexuser.inGroup("default")) {
            p.sendMessage(Main.loginprefix + " Dein Rang ist jetzt Spieler.");


        }
        if(pexuser.inGroup("DEV")) {
            p.sendMessage(Main.loginprefix + " Dein Rang ist jetzt §b§lDeveloper§r.");
        }
        if(pexuser.inGroup("Owner")) {
            p.sendMessage(Main.loginprefix + " Dein Rang ist jetzt §4§lOwner§r.");
        }
        if(pexuser.inGroup("Admin")) {
            p.sendMessage(Main.loginprefix + " Dein Rang ist jetzt §4§lAdmin§r.");
        }
        if(pexuser.inGroup("Builder")) {
            p.sendMessage(Main.loginprefix + " Dein Rang ist jetzt §eBuilder§r.");
        }
        if(pexuser.inGroup("SUP")) {
            p.sendMessage(Main.loginprefix + " Dein Rang ist jetzt §aSupporter§r.");
        }
        if(pexuser.inGroup("Mod")) {
            p.sendMessage(Main.loginprefix + " Dein Rang ist jetzt §2Moderator§r.");
        }
        if(pexuser.inGroup("Friend")) {
            p.sendMessage(Main.loginprefix + " Dein Rang ist jetzt §dTeamFreund§r.");
        }
        if(pexuser.inGroup("FriendPlus")) {
            p.sendMessage(Main.loginprefix + " Dein Rang ist jetzt §5TeamFreund+§r.");
        }
        if(p.hasPermission("karatek.silentjoin")) {
            p.sendMessage(Main.loginprefix + " Du bist automatisch gevanisht.");
            p.performCommand("v");
        }
        p.sendMessage(Main.loginprefix + " Daten wurden verarbeitet.");
        World w = p.getWorld();
        w.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
        p.sendMessage(Main.pre + " Herzlich willkommen auf GamelMC!");


    }
}
