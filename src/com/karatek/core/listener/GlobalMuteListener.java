package com.karatek.core.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.karatek.core.commands.Command_GlobalMute;
import com.karatek.core.main.Main;

public class GlobalMuteListener implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		if(Command_GlobalMute.globalmute) {
			if(e.getPlayer().hasPermission("karatek.globalmute.bypass")) {
				return;
			}
			e.getPlayer().sendMessage(Main.pre + "§8 Zuerzeit ist der Chat §4deaktiviert!");
			e.setCancelled(true);
		}
	}

}
