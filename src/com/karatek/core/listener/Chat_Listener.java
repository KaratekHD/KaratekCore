package com.karatek.core.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.karatek.core.main.Main;

public class Chat_Listener implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		
		final String m = e.getMessage().trim();
        float uppercaseLetter = 0;
        for(int i = 0; i < m.length(); i ++ ) {
            if(Character.isUpperCase(m.charAt(i)) && Character.isLetter(m.charAt(i))) {
                uppercaseLetter++;
            }
        }
        if(uppercaseLetter / (float) m.length() > 0.4F) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Main.pre + " Bitte benutze nicht so viele Großbuchstaben!");
           
           
        }
		
	}

}
