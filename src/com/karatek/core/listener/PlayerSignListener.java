package com.karatek.core.listener;

import com.karatek.core.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerSignListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        if(e.getClickedBlock().getState() instanceof Sign) {
            Sign s = (Sign) e.getClickedBlock().getState();

            if(s.getLine(0).equalsIgnoreCase("Hier klicken!")) {
                int slots = 27;

                try{
                    slots = Integer.valueOf(s.getLine(3));
                } catch (NumberFormatException e1) {
                    slots = 27;
                }
                Inventory inv = Bukkit.createInventory(null, 27, Main.pre);

                String[] args = s.getLine(1).split(";");

                int id = Integer.valueOf(args[0]);
                int data = 0;

                if(args.length > 1 ) {
                    data = Integer.valueOf(args[1]);
                }

                @SuppressWarnings("deprecation")
                ItemStack item = new ItemStack(id, 1, (byte) data);

                int count = 1;

                try{
                    count = Integer.valueOf(s.getLine(2));
                } catch (NumberFormatException e1) {
                    count = item.getMaxStackSize();
                }


                item.setAmount(count);

                for(int i = 0; i < slots; i++) {
                    inv.setItem(i, item);
                }
                e.getPlayer().openInventory(inv);
            }


        }

    }

    @EventHandler
    public void onSign(SignChangeEvent e){
        if(e.getLine(0).equalsIgnoreCase("ess")){
            if(e.getPlayer().hasPermission("karatek.createsign")) {
                e.setLine(0, "Hier klicken!");

            } else {
                e.getPlayer().sendMessage("§cDazu hast du keine Rechte!");
                e.setLine(0, "§cDazu hast");
                e.setLine(1, "§c keine");
                e.setLine(2, "§c Rechte!");
                e.setLine(3, "");
            }
        }
    }

}