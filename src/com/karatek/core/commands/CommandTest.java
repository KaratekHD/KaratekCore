package com.karatek.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.karatek.core.main.Main;

public class CommandTest implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            
            p.sendMessage(Main.pre + " Hallo Welt!");


        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }


	}

