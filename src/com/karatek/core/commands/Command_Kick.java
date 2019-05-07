package com.karatek.core.commands;

import com.karatek.core.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Kick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length == 0) {
                p.sendMessage(Main.pre + " Verwendung: /kkick <Spieler> <Grund>");
                return false;
            } else {
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null) {
                    p.sendMessage("Der Spieler §a" + args[0] + " §rist nicht online!");
                } else {
                    String reason;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < args.length; i++){
                        sb.append(args[i]).append(" ");
                    }

                    reason = sb.toString().trim();
                    if(args.length < 2) {
                        reason = "Vom Server geworfen.";
                    }
                    if(target == p) {
                        p.sendMessage("§cDu willst dich doch nicht selber kicken, oder?");
                        return false;
                    }
                    //ignore the Developer and the Owner of GamelMC
                    if(!p.getName().equalsIgnoreCase(Main.author)) {
                        if(target.getName().equalsIgnoreCase(Main.author)) {
                            p.sendMessage("§cDu darfst diesen Spieler nicht kicken!");
                            return false;

                        }
                        if(target.getName().equalsIgnoreCase("ITzJoshLP")) {
                            p.sendMessage("§cDu darfst diesen Spieler nicht kicken!");
                            return false;
                        }

                    }
                    p.sendMessage("§7[§4Strafe§7] Du hast den Spieler " + target.getDisplayName() + " gekickt.");
                    target.kickPlayer("§8[§4Strafe§8] §c Du wurdest §4vom Server geworfen. \n\n §eGrund: §7" + reason + " \n\n §7Du wurdest gekickt von §a" + p.getDisplayName());
                }
            }
        } else {
            Bukkit.getConsoleSender().sendMessage("Hey!");
        }
        return false;
    }
}

