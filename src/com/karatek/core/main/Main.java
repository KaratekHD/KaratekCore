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

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.karatek.core.commands.*;
import com.karatek.core.listener.*;
public class Main extends JavaPlugin {

    public static String pre = "§r[§6§lGamelMC§r]";
    public static String loginprefix = "§r[§2§lLogin§r]";
    public static String karatekpre = "§r[§b§lEntwicklermodus§r]";
    public static String rankpre = "§r[§4§lRang-System§r]";
    public static String version = "v0.2.2 RC2";

    private static Main plugin;

    public void onEnable() {
        plugin = this;

        System.out.println("Karatek Core ist aktiv.");
        loadConfigFile();

        //listener
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerChatEvent(), this);
        pm.registerEvents(new ScoreBoard(), this);
        pm.registerEvents(new Broadcast_Listener(), this);
        pm.registerEvents(new PlayerEventJoin(), this);
        pm.registerEvents(new SignListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new KickPlayerEvent(), this);

        //commands
        this.getCommand("test").setExecutor(new Command_Test());
        this.getCommand("chatclear").setExecutor(new Command_ChatClear());
        this.getCommand("cc").setExecutor(new Command_ChatClear());
        this.getCommand("kopf").setExecutor(new Command_Kopf());
        this.getCommand("globalmute").setExecutor(new Command_GlobalMute());
        this.getCommand("kvanish").setExecutor(new Command_KVanish());
        this.getCommand("kv").setExecutor(new Command_KVanish());
        this.getCommand("devinfo").setExecutor(new Command_DevInfo());
        this.getCommand("server").setExecutor(new Command_Server());
        this.getCommand("rank").setExecutor(new Command_Rank());
        this.getCommand("crash").setExecutor(new Command_Crash());
        this.getCommand("kversion").setExecutor(new Command_Version());
    }

    public static Main getPlugin() {
        return plugin;
    }

    public void loadConfigFile() {
        saveDefaultConfig();
        // If the Configuration Section doesn't exist, create it and save the config.
        if (getConfig().getConfigurationSection("commands") == null) {
            getConfig().createSection("commands");
            // I am going to be adding some example commands.
            getConfig().set("commands.example", "&4This is an example command");
            saveConfig();
        }
    }


}
