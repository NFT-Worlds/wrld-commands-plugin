package com.nftworlds.wrldcommands;

import com.nftworlds.wallet.objects.Network;
import com.nftworlds.wrldcommands.payloads.ExamplePayload;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class CommandServerRequestWRLD implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 2) {
            sender.sendMessage("usage: /createrequest <amount> <reason>");
            return false;
        }
        Player p = (Player) sender;

        ExamplePayload n = new ExamplePayload(p.getLocation());
        WRLDPaymentsCommands.getPayments().getNFTPlayer((Player) sender).getPrimaryWallet().requestWRLD(
                Double.parseDouble(args[0]), Network.POLYGON, args[1], n
        );
        return true;
    }
}
