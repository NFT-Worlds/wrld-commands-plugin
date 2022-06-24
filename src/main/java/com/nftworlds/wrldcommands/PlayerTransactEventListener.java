package com.nftworlds.wrldcommands;

import com.nftworlds.wallet.event.PlayerTransactEvent;
import com.nftworlds.wallet.event.PlayerWalletReadyEvent;
import com.nftworlds.wrldcommands.payloads.ExampleTeleportPayload;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class PlayerTransactEventListener implements Listener {
    @EventHandler
    public void onPlayerTransactEvent(PlayerTransactEvent event) {
        if (event.getPayload() instanceof ExampleTeleportPayload examplePayload) {
            handleExampleTeleportPayload(event.getPlayer(), examplePayload.location);
        }
    }

    @EventHandler
    public void onPlayerReady(PlayerWalletReadyEvent e) {
        WRLDPaymentsCommands.getInstance().getLogger().info("PlayerWalletReadyEvent for " + e.getPlayer());
    }

    private void handleExampleTeleportPayload(Player p, Location l) {
        p.teleport(l);
        p.sendMessage("You have been teleported to the location at which you ran /createrequest!");
        p.sendMessage("Now, go forth and write your own transaction payloads!");
    }
}
