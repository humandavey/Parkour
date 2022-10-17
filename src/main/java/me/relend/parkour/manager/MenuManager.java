package me.relend.parkour.manager;

import me.relend.parkour.menus.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MenuManager {

	private final Map<UUID, Menu> openMenus;

	public MenuManager() {
		this.openMenus = new HashMap<>();
	}

	public void registerMenu(UUID register, Menu menu) {
		openMenus.put(register, menu);
	}

	public void unregisterMenu(UUID unregister) {
		openMenus.remove(unregister);
	}

	public Menu matchMenu(UUID uuid) {
		return openMenus.get(uuid);
	}
}
