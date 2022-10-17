package me.relend.parkour.commands.command;

import me.relend.parkour.commands.Command;
import me.relend.parkour.configuration.Message;
import me.relend.parkour.configuration.Permission;
import me.relend.parkour.menus.menu.ParkourAdminMenu;
import me.relend.parkour.menus.menu.ParkourMenu;
import me.relend.parkour.util.Util;
import org.bukkit.entity.Player;

public class ParkourCMD extends Command {

	public ParkourCMD() {
		super("parkour", new String[]{"pk"}, "Create and manage your parkours!");
	}

	@Override
	public void execute(Player player, String[] args) {
		if (player.hasPermission(Permission.PARKOUR_CMD.toString())) {
			if (args.length == 0) {
				if (player.hasPermission(Permission.PARKOUR_ADMIN_CMD.toString())) {
					new ParkourAdminMenu().open(player);
				} else {
					new ParkourMenu().open(player);
				}
			} else if (args.length == 1) {
				switch (args[0].toUpperCase()) {
					case "MENU" -> {
						if (player.hasPermission(Permission.PARKOUR_ADMIN_CMD.toString())) {
							new ParkourAdminMenu().open(player);
						} else {
							new ParkourMenu().open(player);
						}
					}
				}
			}
		} else {
			player.sendMessage(Util.colorize(Message.NO_PERMISSION.toString()));
		}
	}
}
