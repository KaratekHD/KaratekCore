package com.karatek.core.commands;

/*
 * Command_GlobalMute
 * 
 * Version 0.2.2 RC 2
 * 
 * Last Change: 0.2.2 RC 2
 * 
 * Copyright Karatek_HD
 * 
 * License free
 */

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.karatek.core.main.Main;

public class Command_GlobalMute implements CommandExecutor {
	
	public static boolean globalmute = false;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String labels, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(Main.pre + " Du musst ein Spieler sein.");
		} else {
			
			Player p = (Player)sender;
			
			if(!(p.hasPermission("karatek.globalmute"))) {
				p.sendMessage(Main.pre + "Dir fehlt die Berechtigung §akaratek.globalmute§r.");
				return true;
			}
			if(globalmute) {
				globalmute = false;
				Bukkit.broadcastMessage(Main.pre + "§r Der Globale Chat wurde von " + p.getDisplayName() + " §4aktiviert.");
			} else {
				globalmute = true;
				Bukkit.broadcastMessage(Main.pre + "§r Der Globale Chat wurde von " + p.getDisplayName() + " §4deaktiviert!");
			}
			
		}
		
		return false;
	}

}
