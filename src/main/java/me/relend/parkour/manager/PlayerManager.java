package me.relend.parkour.manager;

import me.relend.parkour.instance.ParkourPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PlayerManager {

	private ArrayList<ParkourPlayer> players;

	public PlayerManager() {
		players = new ArrayList<>();
	}

	public ParkourPlayer getPlayer(Player player) {
		for (ParkourPlayer pkp : players) {
			if (pkp.getPlayer().equals(player)) {
				return pkp;
			}
		}
		return null;
	}

	public void addPlayer(ParkourPlayer pkp) {
		players.add(pkp);
	}

	public void removePlayer(ParkourPlayer pkp) {
		players.remove(pkp);
	}
}
