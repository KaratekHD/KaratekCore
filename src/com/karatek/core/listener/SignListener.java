package com.karatek.core.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignListener implements Listener {
	
	@EventHandler
	public void onChange(SignChangeEvent e)  {
		
		String l1 = e.getLine(0).replace("&", "§");
		String l2 = e.getLine(1).replace("&", "§");
		String l3 = e.getLine(2).replace("&", "§");
		String l4 = e.getLine(3).replace("&", "§");
		
		e.setLine(0, l1);
		e.setLine(1, l2);
		e.setLine(2, l3);
		e.setLine(3, l4);
	}

}
