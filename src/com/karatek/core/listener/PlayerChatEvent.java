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


public class PlayerChatEvent implements Listener {
	
	public static Plugin plugin;
	
	
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
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
