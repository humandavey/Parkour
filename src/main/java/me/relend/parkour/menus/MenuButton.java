package me.relend.parkour.menus;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class MenuButton {

	private ItemStack item;
	private Consumer<Player> whenClicked;

	public MenuButton(ItemStack item) {
		this.item = item;
	}

	public MenuButton setWhenClicked(Consumer<Player> whenClicked) {
		this.whenClicked = whenClicked;
		return this;
	}

	public Consumer<Player> getWhenClicked() {
		return whenClicked;
	}

	public ItemStack getItem() {
		return item;
	}
}
