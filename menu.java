package cigo.kasa;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class menu implements Listener {


    public static void MainCrateMenuOpen(Player player) {

        variables.MainCrateInventory = Bukkit.createInventory(null,54, ChatColor.translateAlternateColorCodes('&',"&6İşte Kasaların Tüm Listesi"));
        int a;

        for (a = 0; a < variables.kasalar.size(); a++) {

            variables.MainCrateInventory.setItem(a,new ItemStack(Material.CHEST));
            variables.MainCrateInventory.getItem(a).getItemMeta().setDisplayName(variables.kasanames.get(a));
        }
        player.openInventory(variables.MainCrateInventory);

    }


    public static void SelectedCrateMenuOpen(Player pl, String s) {

        Inventory SelectedCrateInventory = Bukkit.createInventory(null,54,ChatColor.GREEN + "KASA" + ChatColor.WHITE + s);
        int a;
        for (a = 0; a < variables.kasalar.get(s).size(); a++) {

            SelectedCrateInventory.setItem(a,variables.kasalar.get(s).get(a));
        }
        pl.openInventory(variables.MainCrateInventory);


    }
}
