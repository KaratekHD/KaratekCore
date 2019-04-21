package com.karatek.core.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.karatek.core.main.Main;

public class OnCommandListener implements Listener {
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		
		Player p = e.getPlayer();
		if(p.hasMetadata("cmdspy")) {
			p.sendMessage(Main.pre + " Der Spieler §a" + e.getPlayer().getName() + "§r hat einen Command ausgeführt:§r " + e.getMessage());
		}
		
	}

}
