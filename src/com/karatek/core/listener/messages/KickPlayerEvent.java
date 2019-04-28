package com.karatek.core.listener.messages;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class KickPlayerEvent implements Listener {

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        Player p = e.getPlayer();
        e.setLeaveMessage("§8[§4§l-§8] " + p.getName());
    }
}
