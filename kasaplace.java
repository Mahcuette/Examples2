package cigo.kasa;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;

public class kasaplace implements Listener {

    @EventHandler (priority = EventPriority.HIGH)
    public void KasaPlaceEvent(BlockPlaceEvent event) {

        Player p = event.getPlayer();

        if (event.getBlockPlaced().getType().equals(Material.ENDER_CHEST)) {

            try {

                if (event.getPlayer().getItemInHand().getItemMeta().getLore().contains("TEST ITEM FOR ALPHA")) {

                    if (variables.kasaloc.containsKey(event.getPlayer().getItemInHand().getItemMeta().getDisplayName())){

                        Location loc = event.getBlockPlaced().getLocation();
                        variables.kasaloc.get(event.getPlayer().getItemInHand().getItemMeta().getDisplayName()).add(loc);

                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &aKasa başarıyla yerleştirildi."));

                    }else {
                        Location loc = event.getBlockPlaced().getLocation();
                        variables.kasaloc.put(event.getPlayer().getItemInHand().getItemMeta().getDisplayName(),new ArrayList<Location>());
                        variables.kasaloc.get(event.getPlayer().getItemInHand().getItemMeta().getDisplayName()).add(loc);

                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &aKasa başarıyla yerleştirildi."));
                    }

                }

            }catch (Exception exception) {

                p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cBirşeyler ters gitti üzgünüm."));


            }

        }

    }
}
