package com.karatek.core.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.karatek.core.commands.CommandTest;
import com.karatek.core.commands.Command_ChatClear;
import com.karatek.core.commands.Command_Crash;
import com.karatek.core.commands.Command_DevInfo;
import com.karatek.core.commands.Command_GlobalMute;
import com.karatek.core.commands.Command_KVanish;
import com.karatek.core.commands.Command_Kopf;
import com.karatek.core.commands.Command_Rank;
import com.karatek.core.commands.Command_Server;
import com.karatek.core.listener.Broadcast_Listener;
import com.karatek.core.listener.GlobalMuteListener;
import com.karatek.core.listener.KickEvent;
import com.karatek.core.listener.OnCommandListener;
import com.karatek.core.listener.PlayerChatEvent;
import com.karatek.core.listener.PlayerEventJoin;
import com.karatek.core.listener.QuitListener;
import com.karatek.core.listener.ScoreBoard;
import com.karatek.core.listener.SignListener;

public class Main extends JavaPlugin {
	
	public static String pre = "§r[§6§lGamelMC§r]";
	public static String loginprefix = "§r[§2§lLogin§r]";
	public static String karatekpre = "§r[§b§lEntwicklermodus§r]";
	public static String rankpre = "§r[§4§lRang-System§r]";
	
	
	private static Main plugin;
	
	public void onEnable() {
		System.out.println("Karatek Core ist aktiv.");
		
		plugin = this;
		
		//listener
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerChatEvent(), this);
		pm.registerEvents(new ScoreBoard(), this);
		pm.registerEvents(new OnCommandListener(), this);
		pm.registerEvents(new Broadcast_Listener(), this);
		pm.registerEvents(new PlayerEventJoin(), this);
		pm.registerEvents(new GlobalMuteListener(), this);
		pm.registerEvents(new SignListener(), this);
		pm.registerEvents(new QuitListener(), this);
		pm.registerEvents(new KickEvent(), this);

		//commands
		this.getCommand("test").setExecutor(new CommandTest());
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
	}
	
	
	public static Main getInstance() {
		return plugin;
	}

}
