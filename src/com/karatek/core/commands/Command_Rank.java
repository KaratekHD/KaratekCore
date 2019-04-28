package com.karatek.core.commands;

/*
 * Command_Rank
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

public class Command_Rank implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //check if sender is a player
        if(!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage("§r[§6§lGamelMC§r] Du musst ein Spieler sein.");
            return false;
        }
        //get player sender
        Player p = (Player)sender;
        //check for senders permission
        if(!p.hasPermission("karatek.rankadmin")) {
            //send message
            p.sendMessage(Main.rankpre + " Dazu hast du keine Rechte. \n §4Dieser Vorgang wird gemeldet.§r");
            //notify all team members
            Bukkit.broadcast("Der Spieler §a" + p.getName() + " §rhat versucht einen serverinternen Befehl auszuführen: §a/rank", "karatek.teamsee");
            return false;
        }
        //check syntax and return help
        if(args.length < 2) {
            p.sendMessage(Main.rankpre + " §rVerwendung: /rank <Spieler> <Rang>");
            return false;
        } if(args.length > 2) {
            p.sendMessage(Main.rankpre + " §rVerwendung: /rank <Spieler> <Rang>");
            return false;
        }

        else {
            //get target player
            Player target = Bukkit.getServer().getPlayer(args[0]);
            p.sendMessage(Main.rankpre + " Suche in Rang Liste...");
            //check for the argument and set the rank by executing setrank();
            if(args[1].equalsIgnoreCase("Owner")) {
                setrank(p, target, args[1], "§4§lOwner");
            }
            if(args[1].equalsIgnoreCase("Admin")) {
                setrank(p, target, args[1], "§c§lAdmin");
            }
            if(args[1].equalsIgnoreCase("Developer")) {
                setrank(p, target, args[1], "§bDeveloper");
            }
            if(args[1].equalsIgnoreCase("Moderator")) {
                setrank(p, target, args[1], "§2Moderator");
            }
            if(args[1].equalsIgnoreCase("Supporter")) {
                setrank(p, target, args[1], "§aSupporter");
            }
            if(args[1].equalsIgnoreCase("Friend")) {
                setrank(p, target, args[1], "§dTeamFreund");
            }
            if(args[1].equalsIgnoreCase("FriendPlus")) {
                setrank(p, target, args[1], "§dTeamFreund+");
            }
            if(args[1].equalsIgnoreCase("YouTuber")) {
                setrank(p, target, args[1], "§5YouTuber");
            }
            if(args[1].equalsIgnoreCase("YouTuberPlus")) {
                setrank(p, target, args[1], "§5YouTuber§4+");
            }
            if(args[1].equalsIgnoreCase("YouTuberPlus")) {
                setrank(p, target, args[1], "§5YouTuber§4+");
            }
            if(args[1].equalsIgnoreCase("Spieler")) {
                setrank(p, target, args[1], "§7Spieler");
            }
            if(args[1].equalsIgnoreCase("Builder")) {
                setrank(p, target, args[1], "§eBuilder");
            }
            if(args[1].equalsIgnoreCase("Tester")) {
                setrank(p, target, args[1], "§1Tester");
            }
            if(args[1].equalsIgnoreCase("VIP")) {
                setrank(p, target, args[1], "§6VIP");
            }
            if(args[1].equalsIgnoreCase("Premium")) {
                setrank(p, target, args[1], "§rPremium");
            }
            if(args[1].equalsIgnoreCase("Ultra")) {
                setrank(p, target, args[1], "§1Ultra");
            }
            return true;
        }

    }

    public void setrank(Player sender, Player target, String rank, String msg) {
        //change target group
        sender.performCommand("pex user " + target.getName() + " group set " + rank);
        //send messages
        sender.sendMessage(Main.rankpre + " Der Rang von §a" + target.getName() + " §rist jetzt " + msg + "§r.");
        target.sendMessage(Main.rankpre + " Dein Rang wurde von " + sender.getDisplayName() + " §r geändert. Dein neuer Rang ist jetzt " + msg + "§r.");

    }

}
