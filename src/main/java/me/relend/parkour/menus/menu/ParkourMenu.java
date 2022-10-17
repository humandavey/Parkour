package me.relend.parkour.menus.menu;

import me.relend.parkour.menus.ItemBuilder;
import me.relend.parkour.menus.Menu;
import me.relend.parkour.menus.MenuButton;
import me.relend.parkour.util.Util;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;

public class ParkourMenu extends Menu {

	public ParkourMenu() {
		super("Parkour Menu", 3);

		registerButton(new MenuButton(new ItemBuilder(Material.GREEN_TERRACOTTA).setItemName(Util.colorize("&aEasy Parkours")).setLore("", Util.colorize("&7Click to play easy parkours!")).build()).setWhenClicked(player -> {
			new EasyParkourMenu().open(player);
		}), 10);
		registerButton(new MenuButton(new ItemBuilder(Material.BARRIER).setItemName(Util.colorize("&cClose")).build()).setWhenClicked(HumanEntity::closeInventory), 22);
	}
}
