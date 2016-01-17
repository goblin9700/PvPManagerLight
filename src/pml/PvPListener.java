package pml;

import net.ess3.api.IEssentials;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvPListener implements Listener{
	
	public pvpmanagerlight plugin;

	protected PvPListener (IEssentials ess, pvpmanagerlight plugin) {

		this.plugin = plugin;
	}
	
	   @EventHandler(priority = EventPriority.HIGHEST)
	   public void onAttack(EntityDamageByEntityEvent e) {
	      if(e.getDamager() instanceof Player & e.getEntity() instanceof Player) {
	         Player p = (Player)e.getDamager();
	         if(!p.hasPermission("pvpmanagerlight.bypass")) {
	            if(p.getGameMode() == GameMode.CREATIVE) {
	               e.setCancelled(true);
	               return;
	            }

	            if(p.isFlying()) {
	               e.setCancelled(true);
	               return;
	            }

	            if(p.hasMetadata("god")) {
	               e.setCancelled(true);
	               return;
	            }
	         }
	      }

	   }

}
