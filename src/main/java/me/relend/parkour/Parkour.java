package me.relend.parkour;

import me.relend.parkour.listeners.PKPlayerListener;
import me.relend.parkour.manager.PlayerManager;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Parkour extends JavaPlugin {

	private static Parkour instance;
	private PlayerManager playerManager;
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
	}

	private void registerListeners() {
		getServer().getPluginManager().registerEvents(new PKPlayerListener(), this);
	}

	private void registerCommands() {

	}

	public PlayerManager getPlayerManager() {
		return playerManager;
	}

	public FileConfiguration getMessages() {
		return messagesConfig;
	}

	public static Parkour getInstance() {
		return instance;
	}
}
