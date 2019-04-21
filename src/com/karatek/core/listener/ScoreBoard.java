package com.karatek.core.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;



import ru.tehkode.permissions.bukkit.PermissionsEx;


public class ScoreBoard implements Listener {

    public static void setBoard(Player p) {
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective o = s.registerNewObjective("aaa", "bbb");
        int players = Bukkit.getServer().getOnlinePlayers().size();
        
        // Einstellungen des Scoreboards

        o.setDisplayName("§6§lGamelMC§r.§6§lde");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        // Scores für das Scoreboard

        Score Rang = o.getScore("> §3§lRang:");
        if(PermissionsEx.getUser(p).inGroup("Admin")) {
            Score getRang = o.getScore("§cAdmin");
            getRang.setScore(9);
        }
        if(PermissionsEx.getUser(p).inGroup("Owner")) {
            Score getRang = o.getScore("§4§lOwner");
            getRang.setScore(9);
        }
        if(PermissionsEx.getUser(p).inGroup("Developer")) {
            Score getRang = o.getScore("§b§lDeveloper");
            getRang.setScore(9);
        }
        if(PermissionsEx.getUser(p).inGroup("Moderator")) {
            Score getRang = o.getScore("§2Moderator");
            getRang.setScore(9);
        }
        if(PermissionsEx.getUser(p).inGroup("Supporter")) {
            Score getRang = o.getScore("§aSupporter");
            getRang.setScore(9);
        }
        if(PermissionsEx.getUser(p).inGroup("Friend")) {
            Score getRang = o.getScore("§dTeamFreund");
            getRang.setScore(9);
        }
        if(PermissionsEx.getUser(p).inGroup("FriendPlus")) {
            Score getRang = o.getScore("§dTeamFreund+");
            getRang.setScore(9);
        }
        if(PermissionsEx.getUser(p).inGroup("YouTuber+")) {
            Score getRang = o.getScore("§5YouTuber§4+");
            getRang.setScore(9);
        }
        if(PermissionsEx.getUser(p).inGroup("default")) {
            Score getRang = o.getScore("§7Spieler");
            getRang.setScore(9);
        }
        if(PermissionsEx.getUser(p).inGroup("Builder")) {
            Score getRang = o.getScore("§eBuilder");
            getRang.setScore(9);
        }
        Score Platzhalter0 = o.getScore("§0");
        Score Platzhalter1 = o.getScore("§1");
        Score Name = o.getScore("> §3§lName:");
        Score getName = o.getScore("§r" + p.getName());
        Score Platzhalter2 = o.getScore("§2");
        Score Kills = o.getScore(">§3§l TeamSpeak:");
        Score getKillsScore = o.getScore("§rgamelts.nitrado.net");
        Score Platzhalter3 = o.getScore("§3");
        Score Deaths = o.getScore(">§3§l Spieler:");
        Score getDeathsScore = o.getScore(" §r" + players + "/500");
        Score Platzhalter4 = o.getScore("§4");
        
        // Punkte für die Scores

        Platzhalter0.setScore(11);
        Rang.setScore(10);
        Platzhalter1.setScore(8);
        Name.setScore(7);
        getName.setScore(6);
        Platzhalter2.setScore(5);
        Kills.setScore(4);
        getKillsScore.setScore(3);
        Platzhalter3.setScore(2);
        Deaths.setScore(1);
        getDeathsScore.setScore(0);
        Platzhalter4.setScore(-1);

        p.setScoreboard(s);
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent j) {
        setBoard(j.getPlayer());
    }
}
