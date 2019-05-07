package com.karatek.core.main;

/*
 * Main
 *
 * Version 0.2.2 RC 2
 *
 * Last Change: 0.2.2 RC 2
 *
 * Copyright Karatek_HD
 *
 * License free
 */

import com.karatek.core.commands.*;
import com.karatek.core.listener.*;
import com.karatek.core.listener.chat.*;
import com.karatek.core.listener.messages.JoinPlayerEvent;
import com.karatek.core.listener.messages.KickPlayerEvent;
import com.karatek.core.listener.messages.QuitPlayerEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.karatek.spigotlib.api.*;

public class Main extends JavaPlugin {

    private static Main plugin;

    //create variables for all classes
    public static boolean unstable = false;
    public static String version = "v0.2.2";
    public static String name = "KaratekCore";
    public static String pre = "§r[§4§l" + name +  "§r]";
    public static String karatekpre = "§r[§b§lENTWICKLERMODUS§r]";
    public static String rankpre = "§r[§4§lRangSystem§r]";
    public static String loginprefix = "§r[§2§lLogin§r]";
    public static String author = "Karatek_HD";




    public void onEnable() {
        plugin = this;

        System.out.println("KaratekCore wurde erfolgreich aktiviert!");
        if(unstable) {
            System.out.println("Warnung: Diese Version des Plugins ist instabil.");
        }

        //commands
        this.getCommand("test").setExecutor(new Command_Test());
        this.getCommand("chatclear").setExecutor(new Command_ChatClear());
        this.getCommand("cc").setExecutor(new Command_ChatClear());
        this.getCommand("crash").setExecutor(new Command_Crash());
        this.getCommand("globalmute").setExecutor(new Command_GlobalMute());
        this.getCommand("kopf").setExecutor(new Command_Kopf());
        this.getCommand("kvanish").setExecutor(new Command_KVanish());
        this.getCommand("kv").setExecutor(new Command_KVanish());
        this.getCommand("kkick").setExecutor(new Command_Kick());
        this.getCommand("rank").setExecutor(new Command_Rank());
        this.getCommand("kversion").setExecutor(new Command_Version());
        this.getCommand("server").setExecutor(new Command_Server());
        this.getCommand("troll").setExecutor(new Command_Troll());
        
        if(unstable) {
            this.getCommand("echo").setExecutor(new Command_Echo());
        }

        //get Plugin Manager
        PluginManager pm = Bukkit.getPluginManager();

        //register listener
        pm.registerEvents(new BroadcastListener(), this);
        pm.registerEvents(new JoinPlayerEvent(), this);
        pm.registerEvents(new KickPlayerEvent(), this);
        pm.registerEvents(new QuitPlayerEvent(), this);
        pm.registerEvents(new ScoreBoard(), this);
        pm.registerEvents(new SignListener(), this);
        pm.registerEvents(new GlobalMuteListener(), this);
        pm.registerEvents(new PrefixListener(), this);
        pm.registerEvents(new TeamChatListener(), this);
        pm.registerEvents(new UpperCaseListener(), this);
        pm.registerEvents(new FlyListener(), this);
        pm.registerEvents(new PlayerSignListener(), this);

    }

    //getter
    public static Main getPlugin() {
        return plugin;
    }
}
