package me.relend.parkour.menus;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

	private ItemStack item;
	private ItemMeta meta;

	public ItemBuilder(Material material) {
		item = new ItemStack(material);
		meta = item.getItemMeta();
	}

	public ItemBuilder() {
		item = new ItemStack(Material.BARRIER);
		meta = item.getItemMeta();
	}

	public ItemStack build() {
		item.setItemMeta(meta);
		return item;
	}

	public ItemBuilder setAmount(int amount) {
		item.setAmount(amount);
		return this;
	}

	public ItemBuilder setMaterial(Material material) {
		item.setType(material);
		return this;
	}

	public ItemBuilder setItemName(String name) {
		meta.setDisplayName(name);
		return this;
	}

	public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
		meta.addEnchant(enchantment, level, true);
		return this;
	}

	public ItemBuilder setLore(List<String> lore) {
		meta.setLore(lore);
		return this;
	}

	public ItemBuilder setLore(String... lore) {
		meta.setLore(List.of(lore));
		return this;
	}
}
