package com.karatek.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.karatek.core.main.Main;
import com.nametagedit.plugin.NametagEdit;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Command_Sync implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§r[§6§lGamelMC§r] Du musst ein Spieler sein.");
			return true;
		} else {
			Player p = (Player) sender;
			if(!(p.hasPermission("karatek.sync"))) {
				p.sendMessage(Main.pre + "Dir fehlt die Berechtigung §akaratek.sync§r.");
			} else {
				String prefix;
				if(PermissionsEx.getUser(p).inGroup("DEV")) {
					prefix = "§b§lDev§r:§b§l";
					NametagEdit.getApi().setPrefix(p, prefix);
				}
				if(PermissionsEx.getUser(p).inGroup("Owner")) {
					prefix = "§4§lOwner§r:§4§l";
					NametagEdit.getApi().setPrefix(p, prefix);
				}
				if(PermissionsEx.getUser(p).inGroup("Admin")) {
					prefix = "§4§lAdmin§r:§4§l";
					NametagEdit.getApi().setPrefix(p, prefix);
				}
				if(PermissionsEx.getUser(p).inGroup("Builder")) {
					prefix = "§eBuilder§r:§e";
					NametagEdit.getApi().setPrefix(p, prefix);
				}
				if(PermissionsEx.getUser(p).inGroup("SUP")) {
					prefix = "§aSupporter§r:§a";
					NametagEdit.getApi().setPrefix(p, prefix);
				}
				if(PermissionsEx.getUser(p).inGroup("MOD")) {
					prefix = "§2Moderator§r:§2";
					NametagEdit.getApi().setPrefix(p, prefix);
				}
				if(PermissionsEx.getUser(p).inGroup("Friend")) {
					prefix = "§dTeamFreund§r:§d";
					NametagEdit.getApi().setPrefix(p, prefix);
				}
				if(PermissionsEx.getUser(p).inGroup("FriendPlus")) {
					prefix = "§5TeamFreund+§r:§5";
					NametagEdit.getApi().setPrefix(p, prefix);
				}
				
				p.sendMessage(Main.pre + " Dein Prefix wurde aktualisiert.");
			}
		}

		
		return false;
	}

}
