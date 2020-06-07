package cigo.kasa;

import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class variables implements Listener {

    public static HashMap<String,ArrayList<ItemStack>> kasalar = new HashMap<String, ArrayList<ItemStack>>();
    public static ArrayList<String> kasanames = new ArrayList<String>();
    public static HashMap<String, ArrayList<Location>> kasaloc = new HashMap<String, ArrayList<Location>>();
    public static Inventory MainCrateInventory;
}
