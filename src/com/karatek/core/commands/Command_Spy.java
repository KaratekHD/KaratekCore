package com.karatek.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import com.karatek.core.main.Main;

public class Command_Spy implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Main.pre + " Du musst ein Spieler sein.");
		}
		
		Player p = (Player)sender;
		if(p.hasPermission("karatek.spy")) {
			if(p.hasMetadata("cmdspy")) {
				p.removeMetadata("cmdspy", Main.getInstance());
				p.sendMessage(Main.pre + " Du siehst die Commands der Spieler nicht mehr!");
			} else {
				p.setMetadata("cmdspy", new FixedMetadataValue(Main.getInstance(), true));
				p.sendMessage(Main.pre + " Du siehst nun alle Commands der Spieler.");
			} 
		} else {
			p.sendMessage(Main.pre + " Dir fehlt die Berechtigung §akaratek.spy§r.");
		}
		
			
		return false;
	}

}
