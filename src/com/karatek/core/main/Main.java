package com.karatek.core.main;

import com.karatek.core.commands.*;
import com.karatek.core.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static String version = "v0.2.2 RC 2";
    public static String pre = "§r[§4§lKaratekCore§r]";
    public static String karatekpre = "§r[§b§lENTWICKLERMODUS§r]";
    public static String rankpre = "§r[§4§lRangSystem§r]";
    public static String loginprefix = "§r[§2§lLogin§r]";
    public void onEnable() {
        System.out.println("KaratekCore wurde aktiviert!");

        //commands
        this.getCommand("test").setExecutor(new Command_Test());
        this.getCommand("chatclear").setExecutor(new Command_ChatClear());
        this.getCommand("cc").setExecutor(new Command_ChatClear());
        this.getCommand("crash").setExecutor(new Command_Crash());
        this.getCommand("globalmute").setExecutor(new Command_GlobalMute());
        this.getCommand("kopf").setExecutor(new Command_Kopf());
        this.getCommand("kvanish").setExecutor(new Command_KVanish());
        this.getCommand("kv").setExecutor(new Command_KVanish());
        this.getCommand("rank").setExecutor(new Command_Rank());
        this.getCommand("kversion").setExecutor(new Command_Version());
        this.getCommand("server").setExecutor(new Command_Server());

        //get Plugin Manager
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerChatEvent(), this);
        pm.registerEvents(new Broadcast_Listener(), this);
        pm.registerEvents(new JoinPlayerEvent(), this);
        pm.registerEvents(new KickPlayerEvent(), this);
        pm.registerEvents(new QuitPlayerEvent(), this);
        pm.registerEvents(new ScoreBoard(), this);
        pm.registerEvents(new SignListener(), this);


    }
}
