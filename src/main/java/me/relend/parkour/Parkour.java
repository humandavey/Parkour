package me.relend.parkour;

import me.relend.parkour.commands.command.ParkourCMD;
import me.relend.parkour.listeners.*;
import me.relend.parkour.manager.*;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Parkour extends JavaPlugin {

	private static Parkour instance;
	private PlayerManager playerManager;
	private MenuManager menuManager;
	private FileConfiguration messagesConfig;

	@Override
	public void onEnable() {
		instance = this;

		setupManagers();
		setupConfigs();

		registerListeners();
		registerCommands();
	}

	private void setupConfigs() {
		getConfig().options().copyDefaults();
		saveDefaultConfig();

		File messagesFile = new File(getDataFolder(), "messages.yml");
		if (!messagesFile.exists()) {
			messagesFile.getParentFile().mkdirs();
			saveResource("messages.yml", false);
		}

		messagesConfig = new YamlConfiguration();
		try {
			messagesConfig.load(messagesFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	private void setupManagers() {
		playerManager = new PlayerManager();
		menuManager = new MenuManager();
	}

	private void registerListeners() {
		getServer().getPluginManager().registerEvents(new PKPlayerListener(), this);
		getServer().getPluginManager().registerEvents(new MenuListener(), this);
	}

	private void registerCommands() {
		new ParkourCMD();
	}

	public PlayerManager getPlayerManager() {
		return playerManager;
	}

	public MenuManager getMenuManager() {
		return menuManager;
	}

	public FileConfiguration getMessages() {
		return messagesConfig;
	}

	public static Parkour getInstance() {
		return instance;
	}
}
