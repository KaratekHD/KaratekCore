package com.karatek.core.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class KickEvent implements Listener {
	
	@EventHandler
	public void onKick(PlayerKickEvent e) {
		Player p = e.getPlayer();
		e.setLeaveMessage("§8[§4§l-§8] " + p.getDisplayName());
	}

}
