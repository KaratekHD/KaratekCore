package com.karatek.core.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.karatek.core.main.Main;

public class Broadcast_Listener implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(e.getMessage().startsWith("@bc")) {
			if(!p.hasPermission("karatek.broadcast")) {
				p.sendMessage(Main.pre + " Dir fehlt die Berechtigung §akaratek.broadcast§r.");
				e.setCancelled(true);
			} else {
				String bcmsgorig = e.getMessage();
				String bcmsg = bcmsgorig.replaceAll("@bc", "§a§l");
				Bukkit.broadcastMessage("-------------------§6§lGamelMC§r-------------------");
				Bukkit.broadcastMessage(bcmsg);
				Bukkit.broadcastMessage("-------------------§6§lGamelMC§r-------------------");
				e.setCancelled(true);
				p.sendMessage(Main.pre + "§r Deine Nachicht wurde ausgegeben.");
			}
		}
	}

}
