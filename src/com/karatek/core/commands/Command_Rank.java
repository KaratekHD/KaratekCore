package com.karatek.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.karatek.core.main.Main;

public class Command_Rank implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		if(!p.hasPermission("karatek.rankadmin")) {
			p.sendMessage(Main.rankpre + " Dazu hast du keine Rechte. \n §4Dieser Vorgang wird gemeldet.§r");
			Bukkit.broadcast("Der Spieler §a" + p.getName() + " §rhat versucht einen serverinternen Befehl auszuführen: §a/rank", "karatek.teamsee");
			return false;
		}
		if(args.length < 2) {
			p.sendMessage(Main.rankpre + " §rVerwendung: /rank <Spieler> <Rang>");
			return false;
		} if(args.length > 2) {
			p.sendMessage(Main.rankpre + " §rVerwendung: /rank <Spieler> <Rang>");
			return false;
		}
		else {
			String targetname = args[0];
			String rank = args[1];
			Player target = Bukkit.getServer().getPlayer(rank);
			p.sendMessage(Main.karatekpre + " Alles richtig! Spieler: §a" + targetname + "§r Rang:§a " + rank);
			return true;
		}
		
	}

}
