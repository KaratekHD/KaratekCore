package com.karatek.core.listener;

/*
 * PlayerChatEvent
 *
 * Version 0.2.2 RC 2
 *
 * Last Change: 0.2.2 RC 2
 *
 * Copyright Karatek_HD
 *
 * License free
 */

import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
//import ru.tehkode.permissions.bukkit.PermissionsEx;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import com.karatek.core.main.Main;
import com.karatek.core.commands.*;

public class PlayerChatEvent implements Listener {

    public static Plugin plugin;



    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        final String m = e.getMessage().trim();
        float uppercaseLetter = 0;
        String msg = e.getMessage();
        msg.replace("%", "Prozent");
        if(p.hasPermission("karatek.dev")) {
            msg.replace("PARA", "§");
        }
        if(!p.hasPermission("karatek.adminchat")) {
            e.setFormat(p.getDisplayName() + " §r: " + msg);
        }
        if(p.hasPermission("karatek.adminchat")) {
            e.setFormat("§8»\n§r" + p.getDisplayName() + " §r: §a§l" + msg + "\n§8»");
        }
        for(int i = 0; i < m.length(); i ++ ) {
            if(Character.isUpperCase(m.charAt(i)) && Character.isLetter(m.charAt(i))) {
                uppercaseLetter++;
            }
        }
        if(uppercaseLetter / (float) m.length() > 0.4F) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Main.pre + " Bitte benutze nicht so viele Großbuchstaben!");


        }
        if(Command_GlobalMute.globalmute) {
            if(e.getPlayer().hasPermission("karatek.globalmute.bypass")) {
                return;
            }
            e.getPlayer().sendMessage(Main.pre + "§8 Zuerzeit ist der Chat §4deaktiviert!");
            e.setCancelled(true);
        }
        if(e.getMessage().startsWith("@team")) {
            if(p.hasPermission("karatek.teamsend")) {
                String tmsg = e.getMessage();
                String prefix = "§f[§4§lTEAMCHAT§r§f]";

                Bukkit.broadcast(prefix + " " + p.getDisplayName() + " §8 >> " + tmsg.replaceAll("@team", "§r"), "karatek.teamsee");
                e.setCancelled(true);
            }
        }
    }
}
