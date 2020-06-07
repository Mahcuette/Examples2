package cigo.kasa;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class cratemenu implements Listener {

    @EventHandler (priority = EventPriority.HIGH)
    public void CrateMenuClick(InventoryClickEvent event) {

        if (event.getInventory().getTitle().startsWith(ChatColor.GREEN + "KASA")) {

            event.getWhoClicked().closeInventory();
            event.setCancelled(true);
            event.getWhoClicked().openInventory(event.getInventory());

        }

    }
}
