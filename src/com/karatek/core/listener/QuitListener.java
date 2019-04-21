package com.karatek.core.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
	
	@EventHandler
	public void onQuit (PlayerQuitEvent e) {
		Player p = e.getPlayer();
		String name = p.getDisplayName();
		System.out.println("Der Spieler " + name + " hat die Verbindung getrennt. ");
		e.setQuitMessage("§8[§4-§8] " + name);
	}

}
