package pml;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PvPCommands implements CommandExecutor {
	private pvpmanagerlight plugin;


	protected PvPCommands (pvpmanagerlight plugin) {
		this.plugin = plugin;
	}

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if (sender instanceof Player) {
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("reload")) {
					if (sender.hasPermission("pvpmanagerlight.reload")) {
						plugin.reloadConfig();
						plugin.loadConfig();
						sender.sendMessage(plugin.messReload);
					}else{
						sender.sendMessage(plugin.messNoPerm);
					}
				}
			}
		} else {
			sender.sendMessage("PvPManagerLight " + "This is an in-game only command");
			return true;
		}
		return true;
	}
	

}
