package cigo.kasa;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class selectedmenu implements Listener {

    @EventHandler (priority = EventPriority.HIGH)
    public void SelectedMenuClick(InventoryClickEvent event) {

        Player p = (Player)event.getWhoClicked();

        if (event.getInventory().getTitle().equals(ChatColor.translateAlternateColorCodes('&',"&6İşte Kasaların Tüm Listesi"))) {
            if (event.getCurrentItem().getType().equals(Material.CHEST)) {

            if (event.getClick().isRightClick()) {

                event.getWhoClicked().closeInventory();
                event.setCancelled(true);
                Inventory inv = event.getWhoClicked().getInventory();
                ItemStack item = new ItemStack(Material.ENDER_CHEST);
                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.setDisplayName(event.getCurrentItem().getItemMeta().getDisplayName());
                ArrayList<String> lore = new ArrayList<String>();
                lore.add("TEST ITEM FOR ALPHA");
                itemMeta.setLore(lore);
                item.setItemMeta(itemMeta);
                inv.addItem(item);
            }

            if (event.getClick().isLeftClick()) {

                event.getWhoClicked().closeInventory();
                event.setCancelled(true);
                cigo.kasa.menu.SelectedCrateMenuOpen(p,event.getCurrentItem().getItemMeta().getDisplayName());
            }
        }else {
                event.getWhoClicked().closeInventory();
                event.setCancelled(true);
                event.getWhoClicked().openInventory(event.getInventory());
            }
        }

    }
}
