package com.karatek.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.karatek.core.main.Main;

public class Command_DevInfo implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String labels, String[] args) {
		Player p = (Player)sender;
		if(!p.hasPermission("karatek.dev")) {
			p.sendMessage(Main.karatekpre + "§r Dir fehlt die Berrechtigung §akaratek.dev§r.");
			return false;
		} else {
			p.sendMessage(Main.karatekpre + "Im nachfolgenden all verfügbaren Namen:");
			String n1 = p.getCustomName();
			String n2 = p.getDisplayName();
			String n3 = p.getName();
			String n4 = p.getPlayerListName();
			p.sendMessage("p.getCustomName() ist §a§l" + n1 + "§r.");
			p.sendMessage("p.getDisplayName() ist §a§l" + n2 + "§r.");
			p.sendMessage("p.getName() ist §a§l" + n3 + "§r.");
			p.sendMessage("p.getPlayerListName() ist §a§l" + n4 + "§r.");
			p.sendMessage(Main.karatekpre + " §aThere is nothing to do.");
			return true;
		}
	}

}
