/*
 * PvPManagerLight - a bukkit plugin
 * Copyright 2015  goblin9700  (email: alexgrist@yandex.ua)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pml;

import java.io.File;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
//import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.plugin.java.JavaPlugin;

public class pvpmanagerlight extends JavaPlugin{
	protected String messReload;
	protected String messNoPerm;
	private Boolean enable;

	public void onEnable() {
		getConfig().options().copyDefaults(true);
	    saveDefaultConfig();
		loadConfig();
		if (enable) {
		    getCommand("pvpmanagerlight").setExecutor(new PvPCommands(this));		
		    getServer().getPluginManager().registerEvents(new PvPListener(null, null), this);
		
		    //Log.info("PvPManagerLight has enabled.");
		} else {
			//Log.info("PvPManagerLight has disabled.");
		}
	}
	
	public void loadConfig() {	
		
		FileConfiguration config = YamlConfiguration.loadConfiguration(new File(this.getDataFolder(),"config.yml"));
		enable = config.getBoolean("enable");
		messReload = ChatColor.translateAlternateColorCodes('&', config.getString("messages.reload"));
		messNoPerm = ChatColor.translateAlternateColorCodes('&', config.getString("messages.nopermission"));
	}
	
	public void onDisable() {
		//Log.info("PvPManagerLight has disabled");
	}
	

}
