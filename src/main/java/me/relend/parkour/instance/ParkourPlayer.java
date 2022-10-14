package me.relend.parkour.instance;

import org.bukkit.entity.Player;

public class ParkourPlayer {

	private Player player;

	public ParkourPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}
}
