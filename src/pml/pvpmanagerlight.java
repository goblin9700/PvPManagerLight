package pml;

import java.io.File;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.plugin.java.JavaPlugin;

public class pvpmanagerlight extends JavaPlugin{
	private JavaPlugin plugin;
	protected String messReload;
	protected String messNoPerm;
	protected String messNoCreatPvp;
	protected String messNoFlyPvp;
	protected String messNoGodPvp;
	public void onEnable() {
		
		saveDefaultConfig();
		loadConfig();
		
		getServer().getPluginManager().registerEvents(new PvPListener(null, null), this);
		Log.info("PvPManagerLight has enabled.");
	}
	
	public void loadConfig() {	
		
		FileConfiguration config = YamlConfiguration.loadConfiguration(new File(this.getDataFolder(),"config.yml"));
		
		messReload = ChatColor.translateAlternateColorCodes('&', config.getString("messages.reload"));
		messNoPerm = ChatColor.translateAlternateColorCodes('&', config.getString("messages.nopermission"));
		messNoCreatPvp = ChatColor.translateAlternateColorCodes('&', config.getString("messages.nocreatpvp"));
		messNoFlyPvp = ChatColor.translateAlternateColorCodes('&', config.getString("messages.noflypvp"));
		messNoGodPvp = ChatColor.translateAlternateColorCodes('&', config.getString("messages.nogodpvp"));
		
		saveConfig();
		plugin.getLogger().info("Configuration succeful loaded.");
	}
	
	public void onDisable() {
		Log.info("PvPManagerLight has disabled");
	}
	

}
