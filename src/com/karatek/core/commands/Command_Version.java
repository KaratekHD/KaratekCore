package com.karatek.core.commands;

/*
 * Command_Version
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

public class Command_Version implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage("This Server is running KaratekCore " + Main.version + ".");
			return true;
		} else {
			Player p = (Player) sender;
			p.sendMessage("This Server is running KaratekCore §a" + Main.version + "§r.");
		}
		return false;
	}

}
