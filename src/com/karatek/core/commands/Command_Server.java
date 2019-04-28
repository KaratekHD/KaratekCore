package com.karatek.core.commands;

/*
 * Command_ChatClear
 *
 * Version 0.2.2 RC 2
 *
 * Last Change: 0.2.2 RC 2
 *
 * Copyright Karatek_HD
 *
 * License free
 */

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
        //get player sender
        Player p = (Player) sender;
        //check players permission
        if(!p.hasPermission("karatek.server")) {
            p.sendMessage(Main.pre + "Dir fehlt die Berrechtigung §akaratek.server§r.");
            return false;

        }
        //check syntax and send help
        if(args.length > 1) {
            p.sendMessage("Verwendung: /server <server>");
            return false;
        }
        if(args.length < 1) {
            p.sendMessage("Verwendung: /server <server>");
            return false;
        }
        //check for argument and teleport player
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
            //if the "server" could'nt be found send mesages
            p.sendMessage(Main.loginprefix + " Verbinde zu Server ...");
            p.sendMessage(Main.loginprefix + " Konnte keine Verbindung zum Server herstellen. Wenn du dies für einen Fehler hälst, wende dich bitte an einen Administrator.");
            return false;
        }

    }

}
