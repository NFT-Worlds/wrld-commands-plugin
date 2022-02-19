package com.nftworlds.wrldcommands;

import com.nftworlds.wallet.objects.Network;
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
        WRLDPaymentsCommands.getPayments().getNFTPlayer((Player) sender).requestWRLD(
                Double.parseDouble(args[0]), Network.POLYGON, args[1]
        );
        return true;
    }
}
