package com.nftworlds.wrldcommands;

import com.nftworlds.wallet.objects.Network;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandMintNFT implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String contract = args[0];
        int id = Integer.parseInt(args[1]);

        WRLDPaymentsCommands.getPayments().getNFTPlayer((Player) sender)
                .getPrimaryWallet().mintERC1155NFT(contract, Network.POLYGON, "{}", id);

        return true;
    }
}
