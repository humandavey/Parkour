package me.relend.parkour.listeners;

import me.relend.parkour.Parkour;
import me.relend.parkour.instance.ParkourPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PKPlayerListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Parkour.getInstance().getPlayerManager().addPlayer(new ParkourPlayer(event.getPlayer()));
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Parkour.getInstance().getPlayerManager().removePlayer(Parkour.getInstance().getPlayerManager().getPlayer(event.getPlayer()));
	}
}
