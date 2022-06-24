package com.nftworlds.wrldcommands;

import com.nftworlds.wallet.objects.Network;
import com.nftworlds.wrldcommands.payloads.ExampleTeleportPayload;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;


public class CommandServerRequestWRLD implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 2) {
            sender.sendMessage("usage: /createrequest <amount> <reason>");
            return false;
        }
        Player p = (Player) sender;

        ExampleTeleportPayload n = new ExampleTeleportPayload(p.getLocation());
        try {
            WRLDPaymentsCommands.getPayments().getNFTPlayer((Player) sender).getPrimaryWallet().requestWRLD(
                    Double.parseDouble(args[0]), Network.POLYGON, args[1], false, n
            );
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
