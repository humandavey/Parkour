package me.relend.parkour.listeners;

import me.relend.parkour.Parkour;
import me.relend.parkour.manager.MenuManager;
import me.relend.parkour.menus.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MenuListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Menu matchedMenu = Parkour.getInstance().getMenuManager().matchMenu(event.getWhoClicked().getUniqueId());
		if (matchedMenu != null) {
			matchedMenu.handleClick(event);
		}
	}

	@EventHandler
	public void InventoryClose(InventoryCloseEvent event) {
		Menu matchedMenu = Parkour.getInstance().getMenuManager().matchMenu(event.getPlayer().getUniqueId());
		if (matchedMenu != null) {
			matchedMenu.handleClose((Player) event.getPlayer());
		}
		Parkour.getInstance().getMenuManager().unregisterMenu(event.getPlayer().getUniqueId());
	}

	@EventHandler
	public void PlayerQuit(PlayerQuitEvent event) {
		Menu matchedMenu = Parkour.getInstance().getMenuManager().matchMenu(event.getPlayer().getUniqueId());
		if (matchedMenu != null) {
			matchedMenu.handleClose(event.getPlayer());
		}
		Parkour.getInstance().getMenuManager().unregisterMenu(event.getPlayer().getUniqueId());
	}
}
