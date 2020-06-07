package cigo.kasa;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Random;

public class crateopen implements Listener {


    public void CrateOpenEvent(PlayerInteractEvent event) {

        Player p = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            if (event.getClickedBlock().getType().equals(Material.ENDER_CHEST)) {

                if (event.getPlayer().getItemInHand().getType().equals(Material.EMERALD)) {

                    int a;
                    for (a=0; a < variables.kasanames.size(); a++) {

                        if (variables.kasaloc.containsKey(variables.kasanames.get(a))) {

                            if (variables.kasaloc.get(variables.kasanames.get(a)).contains(event.getClickedBlock().getLocation())) {

                                int b = getRandomNumberInRange(0, variables.kasalar.get(variables.kasanames.get(a)).size());

                                p.getInventory().addItem(variables.kasalar.get(variables.kasanames.get(a)).get(b));
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &aÖdülünüz başarıyla verildi"));

                            }
                        }

                    }
                }
            }
        }
    }


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("min max'dan fazla olmak zorunda");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
