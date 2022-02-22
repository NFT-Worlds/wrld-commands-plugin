package com.nftworlds.wrldcommands;

import com.nftworlds.wallet.event.PlayerTransactEvent;
import com.nftworlds.wallet.objects.payments.PaymentRequest;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CommandSimulateWRLDTransaction implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 1) {
            sender.sendMessage("usage: /simulatetx <id>");
            return false;
        }
        PaymentRequest paymentRequest = PaymentRequest.getPaymentRequests().get(Integer.parseInt(args[0]));
        if (paymentRequest != null) {
            paymentRequest.finalizeTransaction();
            PaymentRequest.getPaymentRequests().remove(paymentRequest);
        }
        return true;
    }
}
