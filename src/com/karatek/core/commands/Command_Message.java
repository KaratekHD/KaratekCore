package com.karatek.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.karatek.core.main.Main;

public class Command_Message implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if(!p.hasPermission("karatek.msg")) {
			p.sendMessage(Main.pre + "Dir fehlt die Berrechtigung §akaratek.msg§r.");
		} else {
			//Eigentlicher Command
			Player t = Bukkit.getPlayer(args[0]);
	        StringBuilder msg = new StringBuilder();
	        for(int i = 0; i < args.length; i++) {
	            if (i > 0) msg.append(" ");
	            msg.append(args[i]);
	        }
	        p.sendMessage(Main.karatekpre + t.getDisplayName() + msg);

			
			
			
			//Eigentlicher Command
		}
		return false;
	}

}
