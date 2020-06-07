package cigo.kasa;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;

public class kasabreak implements Listener {


    @EventHandler (priority = EventPriority.HIGH)
    public void KasaBreakEvent(BlockBreakEvent event) {

        ArrayList<Location> locs = new ArrayList<Location>();

        Player p = event.getPlayer();

        if (event.getBlock().getType().equals(Material.ENDER_CHEST)) {

            int a;
            for (a=0; a < variables.kasanames.size(); a++) {

                if (variables.kasaloc.containsKey(variables.kasanames.get(a))) {

                    if (variables.kasaloc.get(variables.kasanames.get(a)).contains(event.getBlock().getLocation())) {

                        if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {

                            if (event.getPlayer().isSneaking()) {

                            variables.kasaloc.remove(variables.kasanames.get(a));
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kasa başarıyla kırıldı."));
                        }else  {

                                event.setCancelled(true);
                            }
                    } else {
                            event.setCancelled(true);
                        }
                    }
                }
            }




        }


    }
}
