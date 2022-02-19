package com.nftworlds.wrldcommands;

import com.nftworlds.wallet.objects.payments.PaymentRequest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandListPendingRequests implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        ArrayList<PaymentRequest> paymentRequests = PaymentRequest.getPaymentRequests();
        sender.sendMessage("There are " + paymentRequests.size() + " pending payments.");
        for (int i = 0; i < paymentRequests.size(); i++) {
            PaymentRequest p = paymentRequests.get(i);
            String associatedPlayerName = Bukkit.getPlayer(p.getAssociatedPlayer()).getName();
            String line = "[" + ChatColor.GREEN + i + ChatColor.WHITE + "] " + ChatColor.GRAY +
                    paymentRequests.get(i).getReason() + ChatColor.WHITE + " | " + ChatColor.BLUE + associatedPlayerName;
            sender.sendMessage(line);
        }
        sender.sendMessage("To simulate the results of a pending transaction being paid run /simulatetx <id>");
        return true;
    }
}
