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
		Player target = Bukkit.getServer().getPlayer(args[0]);
		String group;
		String ranktitle;
		if(target == null) {
			p.sendMessage("§cWarnung: §rDer Spieler §a" + args[0] + "§r ist nicht online.");
			if(args[1].equalsIgnoreCase("Owner")) {
				group = "Owner";
			}
			if(args[1].equalsIgnoreCase("Admin")) {
				group = "Admin";
			}
			if(args[1].equalsIgnoreCase("Developer")) {
				group = "Developer";
			}
			if(args[1].equalsIgnoreCase("Builder")) {
				group = "Builder";
			}
			if(args[1].equalsIgnoreCase("Moderator")) {
				group = "Moderator";
			}
			if(args[1].equalsIgnoreCase("Supporter")) {
				group = "Supporter";
			}
			if(args[1].equalsIgnoreCase("YT+")) {
				group = "YouTuber+";
			}
			if(args[1].equalsIgnoreCase("YT")) {
				group = "YouTuber";
			}
			if(args[1].equalsIgnoreCase("Premium")) {
				group = "Premium";
			}
			if(args[1].equalsIgnoreCase("Ultra")) {
				group = "Ultra";
			}
			if(args[1].equalsIgnoreCase("Tester")) {
				group = "Tester";
			}
			if(args[1].equalsIgnoreCase("Friend")) {
				group = "TeamFreund";
			}
			if(args[1].equalsIgnoreCase("FriendPlus")) {
				group = "TeamFreund+";
			}
			if(args[1].equalsIgnoreCase("VIP")) {
				group = "VIP";
			} else {
				p.sendMessage(Main.rankpre + " Dies ist kein gültiger Rang auf GamelMC.");
				return false;
			}
			p.performCommand("pex user " + args[0] + " group set " + group);
			if(args[1].equalsIgnoreCase("Owner")) {
				ranktitle = "§4§lOwner";
			}
			if(args[1].equalsIgnoreCase("Admin")) {
				ranktitle = "§cAdmin";
			}
			if(args[1].equalsIgnoreCase("Developer")) {
				ranktitle = "§bDeveloper";
			}
			if(args[1].equalsIgnoreCase("Builder")) {
				ranktitle = "§eBuilder";
			}
			if(args[1].equalsIgnoreCase("Moderator")) {
				ranktitle = "§2Moderator";
			}
			if(args[1].equalsIgnoreCase("Supporter")) {
				ranktitle = "§aSupporter";
			}
			if(args[1].equalsIgnoreCase("YT+")) {
				ranktitle = "§5YouTuber§4+";
			}
			if(args[1].equalsIgnoreCase("YT")) {
				ranktitle = "§5YouTuber";
			}
			if(args[1].equalsIgnoreCase("Premium")) {
				ranktitle = "§6Premium";
			}
			if(args[1].equalsIgnoreCase("Ultra")) {
				ranktitle = "§9Ultra";
			}
			if(args[1].equalsIgnoreCase("VIP")) {
				ranktitle = "§4VIP";
			}
			if(args[1].equalsIgnoreCase("Tester")) {
				ranktitle = "§9Tester";
			}
			if(args[1].equalsIgnoreCase("Friend")) {
				ranktitle = "§dTeamFreund";
			}
			if(args[1].equalsIgnoreCase("FriendPlus")) {
				ranktitle = "§dTeamFreund+";
			}
			else {
				ranktitle = "§4Error";
			}
			p.sendMessage(Main.rankpre + " Der Spieler §a" + args[0] + " hat nun den Rang " + ranktitle + "§r.");
			return true;
		}
		//normal
		if(args[1].equalsIgnoreCase("Owner")) {
			group = "Owner";
		}
		if(args[1].equalsIgnoreCase("Admin")) {
			group = "Admin";
		}
		if(args[1].equalsIgnoreCase("Developer")) {
			group = "Developer";
		}
		if(args[1].equalsIgnoreCase("Builder")) {
			group = "Builder";
		}
		if(args[1].equalsIgnoreCase("Moderator")) {
			group = "Moderator";
		}
		if(args[1].equalsIgnoreCase("Supporter")) {
			group = "Supporter";
		}
		if(args[1].equalsIgnoreCase("YT+")) {
			group = "YouTuber+";
		}
		if(args[1].equalsIgnoreCase("YT")) {
			group = "YouTuber";
		}
		if(args[1].equalsIgnoreCase("Premium")) {
			group = "Premium";
		}
		if(args[1].equalsIgnoreCase("Ultra")) {
			group = "Ultra";
		}
		if(args[1].equalsIgnoreCase("Tester")) {
			group = "Tester";
		}
		if(args[1].equalsIgnoreCase("Friend")) {
			group = "TeamFreund";
		}
		if(args[1].equalsIgnoreCase("FriendPlus")) {
			group = "TeamFreund+";
		}
		if(args[1].equalsIgnoreCase("VIP")) {
			group = "VIP";
		} else {
			p.sendMessage(Main.rankpre + " Dies ist kein gültiger Rang auf GamelMC.");
			return false;
		}
		if(args[1].equalsIgnoreCase("Owner")) {
			ranktitle = "§4§lOwner";
		}
		if(args[1].equalsIgnoreCase("Admin")) {
			ranktitle = "§cAdmin";
		}
		if(args[1].equalsIgnoreCase("Developer")) {
			ranktitle = "§bDeveloper";
		}
		if(args[1].equalsIgnoreCase("Builder")) {
			ranktitle = "§eBuilder";
		}
		if(args[1].equalsIgnoreCase("Moderator")) {
			ranktitle = "§2Moderator";
		}
		if(args[1].equalsIgnoreCase("Supporter")) {
			ranktitle = "§aSupporter";
		}
		if(args[1].equalsIgnoreCase("YT+")) {
			ranktitle = "§5YouTuber§4+";
		}
		if(args[1].equalsIgnoreCase("YT")) {
			ranktitle = "§5YouTuber";
		}
		if(args[1].equalsIgnoreCase("Premium")) {
			ranktitle = "§6Premium";
		}
		if(args[1].equalsIgnoreCase("Ultra")) {
			ranktitle = "§9Ultra";
		}
		if(args[1].equalsIgnoreCase("VIP")) {
			ranktitle = "§4VIP";
		}
		if(args[1].equalsIgnoreCase("Tester")) {
			ranktitle = "§9Tester";
		}
		if(args[1].equalsIgnoreCase("Friend")) {
			ranktitle = "§dTeamFreund";
		}
		if(args[1].equalsIgnoreCase("FriendPlus")) {
			ranktitle = "§dTeamFreund+";
		}
		else {
			ranktitle = "§4Error";
		}
		p.sendMessage(Main.rankpre + " Der Spieler §a" + target.getName() + " hat nun den Rang " + ranktitle + "§r.");
		target.sendMessage(Main.rankpre + " §aDein Rang wurde aktualisiert! Dein neuer Rang ist nun " + ranktitle + "§a.");
		return true;
	}

}
