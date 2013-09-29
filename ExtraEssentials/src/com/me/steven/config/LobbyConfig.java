package com.me.steven.config;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

import com.me.steven.core.ExtraEssentials;

public class LobbyConfig {
	
	private ExtraEssentials plugin;
	 
	public LobbyConfig(ExtraEssentials plugin) {
		this.plugin = plugin;
	}
	
	/*
	public World getLobbyWorldName(String lobbyname) {
		
	}
	/*/
	
	
	//Add a lobby to the config
	public boolean addLobby(String lobbyname) {
		FileConfiguration config = plugin.getConfig();
		if(config.isConfigurationSection("Lobbys." + lobbyname)) {
			return false;
		} else {
			config.createSection("Lobbys." + lobbyname);
			plugin.saveConfig();
			return true;
		}
	}
	
	
	//Set the max players
	public boolean setMaxPlayers(String lobbyname, int maxplayers) {
		FileConfiguration config = plugin.getConfig();
		if(config.isConfigurationSection("Lobbys." + lobbyname)) {
			config.createSection("Lobbys." + lobbyname + ".MaxPlayers");
			config.set("Lobbys." + lobbyname + ".MaxPlayers", maxplayers);
			plugin.saveConfig();
			return true;
		} else {
			return false;
		}
	}

	//Set a lobbys spawn location
	public boolean setSpawnLocation(String lobbyname, Location spawnloc) {
		FileConfiguration config = plugin.getConfig();
		if(isLobby(lobbyname)) {
			if(config.isConfigurationSection("Lobbys." + lobbyname + ".SpawnPoint")) {
				config.set("Lobbys." + lobbyname + ".SpawnPoint", spawnloc);
				plugin.saveConfig();
				return true;
			} else {
				config.createSection("Lobbys." + lobbyname + ".SpawnPoint");
				config.set("Lobbys." + lobbyname + ".SpawnPoint", spawnloc);
				plugin.saveConfig();
				return true;
			}
		}
		return false;
	}
	
	//Return if the world specified is a lobby in the config
	public boolean isLobby(String lobbyname) {
		FileConfiguration config = plugin.getConfig();
		if(config.isConfigurationSection("Lobbys." + lobbyname)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isConfigSection(String path) {
		FileConfiguration config = plugin.getConfig();
		if(config.isConfigurationSection(path)) {
			return true;
		}
		return false;
	}
	
	public boolean isInt(String path) {
		FileConfiguration config = plugin.getConfig();
		if(config.isInt(path)) {
			return true;
		}
		return false;
	}
	
	public int getInt(String path) {
		FileConfiguration config = plugin.getConfig();
		int amt = 0;
		if(isInt(path)) {
			config.getInt(path);
		}
		return amt;
	}
	
}
