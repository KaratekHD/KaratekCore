package com.karatek.core.commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Crash implements CommandExecutor {
	
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p =(Player) sender;
		
		if(!p.hasPermission("essentials.crash")){
			p.sendMessage("Dazu hast du keine Rechte!");
		} else {
			if(args.length == 0) {
				p.sendMessage("§cVerwendung: /crash <Spieler>");
			} else if(args.length == 1) {
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if(target == null){
					p.sendMessage("Der Spieler" + args[0] + " ist nicht online!");
					
				} else if(target.getName().equalsIgnoreCase(p.getName())){
					p.sendMessage("§CDu willst dich doch nicht selber crashen oder?");
				} else if(target.getName().equalsIgnoreCase("Karatek_HD")){
					p.sendMessage("§CDu darfst diesen Spieler nicht crashen!");
				} else {
					crashPlayer(p, target);
				}
			} else {
				p.sendMessage("§CVerwendung: /crash <Spieler>");
			}
		}
		return false;
	}
	
	public void crashPlayer(Player sender, Player target) {
		//todo
		sender.sendMessage("§2Du hast den Spieler §e" + target.getDisplayName() + "gecrashed");
	}
	
	

}