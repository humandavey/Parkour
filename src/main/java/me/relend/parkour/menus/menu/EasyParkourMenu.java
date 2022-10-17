package me.relend.parkour.menus.menu;

import me.relend.parkour.configuration.Permission;
import me.relend.parkour.menus.ItemBuilder;
import me.relend.parkour.menus.Menu;
import me.relend.parkour.menus.MenuButton;
import me.relend.parkour.util.Util;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;

public class EasyParkourMenu extends Menu {

	public EasyParkourMenu() {
		super("Easy Parkour", 3);

		registerButton(new MenuButton(new ItemBuilder(Material.ARROW).setItemName(Util.colorize("&eParkour Menu")).build()).setWhenClicked(player -> {
			if (player.hasPermission(Permission.PARKOUR_ADMIN_CMD.toString())) {
				new ParkourAdminMenu().open(player);
			} else {
				new ParkourMenu().open(player);
			}
		}), 18);
		registerButton(new MenuButton(new ItemBuilder(Material.BARRIER).setItemName(Util.colorize("&cClose")).build()).setWhenClicked(HumanEntity::closeInventory), 22);
	}
}
