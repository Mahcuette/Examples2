package cigo.kasa;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class main implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {

            Player p = (Player)commandSender;
            if (strings.length == 2) {

                if (strings[0].equals("olustur")) {

                    if (variables.kasalar.containsKey(strings[1])) {

                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cBu isimde bir kasa zaten var"));
                        return true;


                    }else {
                        if (variables.kasalar.size() == 54) {

                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cKasa oluşturma sınırına ulaşılmış. &7(&e54&7)"));
                            return true;}

                        if (variables.kasalar.size() < 54){

                            variables.kasalar.put(strings[1], new ArrayList<ItemStack>());
                            variables.kasanames.add(strings[1]);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kasa &7>> &aKasa başarıyla oluşturuldu &7(" + ChatColor.GRAY + strings[1] + ChatColor.GRAY + ")"));
                        }
                    }


                }

                if (strings[0].equals("esyaekle")) {

                    if (variables.kasalar.containsKey(strings[1])) {

                        if (p.getItemInHand().getType().equals(Material.AIR)) {

                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cKasaya eklemek için elinizde bir eşya tutmanız gerekiyor."));
                        }else {
                            if (variables.kasalar.get(strings[1]).size() == 54) {

                                p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cEşya ekleme sınırına ulaşılmış. &7(&e54&7)"));

                                return true;
                            }

                            if (variables.kasalar.get(strings[1]).size() < 54) {


                                variables.kasalar.get(strings[1]).add(p.getItemInHand());
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Kasa &7>> &aEşya başarıyla kasaya eklendi."));
                            }
                        }

                    }else {

                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cBöyle bir kasa bulunamadı."));
                        return true;
                    }
                }

                if (strings[0].equals("sil")) {

                    if (variables.kasalar.containsKey(strings[1])) {

                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &aKasa başarıyla kaldırıldı."));
                        variables.kasalar.remove(strings[1]);
                        variables.kasanames.remove(strings[1]);

                    }else {

                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cBöyle bir kasa bulunamadı."));
                        return true;

                    }
                }

                if (strings[0].equals("esyasil")) {

                    if (variables.kasalar.containsKey(strings[1])) {

                        if (variables.kasalar.get(strings[1]).contains(p.getItemInHand())) {

                            variables.kasalar.get(strings[1]).remove(p.getItemInHand());
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &aEşya başarıyla kaldırıldı."));



                        }else {

                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cBöyle bir eşya bulunamadı."));
                            return true;
                        }

                    }else {

                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cBöyle bir kasa bulunamadı."));
                        return true;

                    }
                }

            }

            if (strings.length == 1) {

                if (strings[0].equals("sil")) {

                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cBir kasa ismi girmeniz gerekiyor."));
                    return true;
                }

                if (strings[0].equals("olustur")) {

                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cBir kasa ismi girmeniz gerekiyor."));
                    return true;


                }

                if (strings[0].equals("esyaekle")) {

                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cBir kasa ismi girmeniz gerekiyor."));
                    return true;
                }

                if (strings[0].equals("esyasil")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &cBir kasa ismi girmeniz gerekiyor."));
                    return true;
                }

                if (strings[0].equals("anamenu")) {

                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Kasa &7>> &aAnamenü başarıyla açıldı."));
                    cigo.kasa.menu.MainCrateMenuOpen(p);

                }

            }
        }
        return false;
    }
}
