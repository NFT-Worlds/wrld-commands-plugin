package com.nftworlds.wrldcommands;

import com.nftworlds.wallet.objects.Network;
import com.nftworlds.wrldcommands.payloads.ExampleTeleportPayload;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandPayPlayer implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(args.length >= 3)) {
            sender.sendMessage("usage: /payplayer <player> <amount> <reason>");
            return false;
        }

        Player payee = Bukkit.getPlayer(args[0]);
        double amount = Double.parseDouble(args[1]);
        StringBuilder reason = new StringBuilder(args[2]);
        for (int i = 3; i < args.length; i++) {
            reason.append(" ").append(args[i]);
        }

        WRLDPaymentsCommands.getPayments().getNFTPlayer(payee).getPrimaryWallet().payWRLD(amount, Network.POLYGON, reason.toString());
        return true;
    }
}
