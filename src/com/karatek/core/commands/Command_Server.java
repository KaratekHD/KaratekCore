package com.karatek.core.commands;

import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.karatek.core.main.Main;

public class Command_Server implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(!p.hasPermission("karatek.server")) {
			p.sendMessage(Main.pre + "Dir fehlt die Berrechtigung §akaratek.server§r.");
			return false;
		} if(args.length > 1) {
			p.sendMessage("Verwendung: /server <server>");
			return false;
		}
		if(args.length < 1) {
			p.sendMessage("Verwendung: /server <server>");
			return false;
		}
		if(args[0].equalsIgnoreCase("cb1")) {
			p.sendMessage(Main.loginprefix + " Verbinde zu Server ...");
			p.performCommand("mv tp PlotWorldNeu");
			p.sendMessage(Main.loginprefix + " Lade Daten...");
			p.sendMessage(Main.loginprefix + " Deine Daten werden verarbeitet...");
			World w = p.getWorld();
			w.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
			p.sendMessage(Main.loginprefix + " Daten wurden verarbeitet.");
			p.sendMessage(Main.pre + " Du spielst nun auf Server §a" + args[0] + "§r.");
			return true;
		}
		if(args[0].equalsIgnoreCase("farmwelt1")) {
			p.sendMessage(Main.loginprefix + " Verbinde zu Server ...");
			p.performCommand("mv tp farmwelt");
			p.sendMessage(Main.loginprefix + " Lade Daten...");
			p.sendMessage(Main.loginprefix + " Deine Daten werden verarbeitet...");
			World w = p.getWorld();
			w.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
			p.sendMessage(Main.loginprefix + " Daten wurden verarbeitet.");
			p.sendMessage(Main.pre + " Du spielst nun auf Server §a" + args[0] + "§r.");
			return true;
		}
		if(args[0].equalsIgnoreCase("free1")) {
			p.sendMessage(Main.loginprefix + " Verbinde zu Server ...");
			p.performCommand("mv tp free");
			p.sendMessage(Main.loginprefix + " Lade Daten...");
			p.sendMessage(Main.loginprefix + " Deine Daten werden verarbeitet...");
			World w = p.getWorld();
			w.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
			p.sendMessage(Main.loginprefix + " Daten wurden verarbeitet.");
			p.sendMessage(Main.pre + " Du spielst nun auf Server §a" + args[0] + "§r.");
			return true;
		}
		if(args[0].equalsIgnoreCase("test")) {
			p.sendMessage(Main.loginprefix + " Verbinde zu Server ...");
			p.performCommand("mv tp test");
			p.sendMessage(Main.loginprefix + " Lade Daten...");
			p.sendMessage(Main.loginprefix + " Deine Daten werden verarbeitet...");
			World w = p.getWorld();
			w.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
			p.sendMessage(Main.loginprefix + " Daten wurden verarbeitet.");
			p.sendMessage(Main.pre + " Du spielst nun auf Server §a" + args[0] + "§r.");
			return true;
		}
		if(args[0].equalsIgnoreCase("lobby")) {
			p.sendMessage(Main.loginprefix + " Verbinde zu Server ...");
			p.performCommand("mv tp lobby");
			p.sendMessage(Main.loginprefix + " Lade Daten...");
			p.sendMessage(Main.loginprefix + " Deine Daten werden verarbeitet...");
			World w = p.getWorld();
			w.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
			p.sendMessage(Main.loginprefix + " Daten wurden verarbeitet.");
			p.sendMessage(Main.pre + " Du spielst nun auf Server §a" + args[0] + "§r.");
			return true;
		}
		else {
			p.sendMessage(Main.loginprefix + " Verbinde zu Server ...");
			p.sendMessage(Main.loginprefix + " Konnte keine Verbindung zum Server herstellen. Wenn du dies für einen Fehler hälst, wende dich bitte an einen Administrator.");
			return false;
		}
		
	}

}