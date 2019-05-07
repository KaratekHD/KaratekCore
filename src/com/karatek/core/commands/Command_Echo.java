package com.karatek.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Echo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        /*String msg;
        if(args.length < 1) {
            msg = args[0];
        }
        if(args.length < 2) {
            msg = msg + args[1];
        }
        if(args.length < 3) {
            msg = msg + args[2];
        }
        if(args.length < 4) {
            msg = msg + args[3];
        }
        if(args.length < 5) {
            msg = msg + args[4];
        }
        if(args.length < 6) {
            msg = msg + args[5];
        }
        if(args.length < 7) {
            msg = msg + args[6];
        }
        if(args.length < 8) {
            msg = msg + args[7];
        }
        if(args.length < 9) {
            msg = msg + args[8];
        }
        if(args.length < 10) {
            msg = msg + args[9];
        }
        if(args.length < 11) {
            msg = msg + args[10];
        }
        if(args.length < 12) {
            msg = msg + args[11];
        }

         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++){
            sb.append(args[i]).append(" ");
        }

        String allArgs = sb.toString().trim();
        p.sendMessage(allArgs);
        p.sendMessage("Hi!");
        return true;
    }
}
