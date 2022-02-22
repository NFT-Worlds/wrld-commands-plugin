package com.nftworlds.wrldcommands;

import com.nftworlds.wallet.event.PlayerTransactEvent;
import com.nftworlds.wrldcommands.payloads.ExamplePayload;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class PlayerTransactEventListener implements Listener {
    @EventHandler
    public void onPlayerTransactEvent(PlayerTransactEvent event) {
        if (event.getPayload() == null) {
            return;
        }
        if (event.getPayload() instanceof ExamplePayload examplePayload) {
            System.out.println(examplePayload.location);
        }
    }

    private void playerBuyAppleFromWorld(PlayerTransactEvent event) {
        event.getPlayer().getInventory().addItem(new ItemStack(Material.APPLE));
        event.getPlayer().sendMessage(ChatColor.GOLD + "Purchase complete! Enjoy your apple!");
    }

    private void playerBuyXPFromWorld(PlayerTransactEvent event) {
        event.getPlayer().giveExp(1000);
        event.getPlayer().sendMessage(ChatColor.GOLD + "Purchase complete! You've gained some XP.");
    }
}
