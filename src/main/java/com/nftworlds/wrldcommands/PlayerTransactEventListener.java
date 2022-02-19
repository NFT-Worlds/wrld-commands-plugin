package com.nftworlds.wrldcommands;

import com.nftworlds.wallet.event.PlayerTransactEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class PlayerTransactEventListener implements Listener {
    @EventHandler
    public void onPlayerTransactEvent(PlayerTransactEvent event) {
        WRLDPaymentsCommands.getInstance().getLogger().info(event.getReason() + " exe");
        try {
            ExampleTransactionType type = ExampleTransactionType.valueOf(event.getReason());
            switch (type) {
                case PLAYER_BUY_APPLE_FROM_WORLD -> playerBuyAppleFromWorld(event);
                case PLAYER_BUY_XP_FROM_WORLD -> playerBuyXPFromWorld(event);
            }
        } catch (IllegalArgumentException e) {
            WRLDPaymentsCommands.getInstance().getLogger().warning("Received transaction type not in transaction type enum.");
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
