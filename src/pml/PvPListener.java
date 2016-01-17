package pml;

import net.ess3.api.IEssentials;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.earth2me.essentials.User;

public class PvPListener implements Listener{
	
	private IEssentials ess;
	public pvpmanagerlight plugin;

	protected PvPListener (IEssentials ess, pvpmanagerlight plugin) {
		this.ess = ess;
		this.plugin = plugin;
	}
	
	   @EventHandler
	   public void onAttack(EntityDamageByEntityEvent e) {
	      if(e.getDamager() instanceof Player & e.getEntity() instanceof Player) {
	         Player p = (Player)e.getDamager();
	         if(!p.hasPermission("pvpmanagerlight.bypass")) {
	            if(p.getGameMode() == GameMode.CREATIVE) {
	               p.sendMessage(plugin.messNoCreatPvp);
	               e.setCancelled(true);
	               return;
	            }

	            if(p.isFlying()) {
	               p.sendMessage(plugin.messNoFlyPvp);
	               e.setCancelled(true);
	               return;
	            }

	            if(p.hasMetadata("god")) {
	               p.sendMessage(plugin.messNoGodPvp);
	               e.setCancelled(true);
	               return;
	            }

	            User user = this.ess.getUser(p);
	            if(user.isGodModeEnabled()) {
	               p.sendMessage(plugin.messNoGodPvp);
	               e.setCancelled(true);
	               return;
	            }
	         }
	      }

	   }

}
