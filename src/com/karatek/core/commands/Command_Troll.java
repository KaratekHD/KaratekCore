package com.karatek.core.commands;

import com.karatek.core.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Troll implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String labels, String[] args) {
        //get sender
        Player p = (Player) sender;
        //check senders permission
        if(p.hasPermission("karatek.troll")) {
            //check syntax
            if(args.length == 1) {
                //get target
                Player t = Bukkit.getPlayer(args[0]);
                //check if target is online
                if(t != null) {
                    //send troll packet
                    t.sendBlockChange(t.getLocation(), Material.LAVA, (byte)0);
                } else {
                    //send message
                    p.sendMessage("§rDer Spieler §a" + args[0] + " §rist nicht online!");
                }

            } else {
                //send help
                p.sendMessage("Verwendung:  /troll <Spieler>");
            }
        } else {
            //send missing permission message
            p.sendMessage(Main.pre + " Dir fehlt die Berrechtigung §akaratek.troll§r.");
        }
        return false;
    }
}
