package com.nftworlds.wrldcommands;

import com.nftworlds.wallet.api.WalletAPI;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public class WRLDPaymentsCommands extends JavaPlugin {
    private static WRLDPaymentsCommands plugin;
    private static WalletAPI wallet;

    public static WRLDPaymentsCommands getInstance() {
        return plugin;
    }
    public static WalletAPI getPayments() {
        return wallet;
    }

    public void onEnable() {
        plugin = this;
        wallet = new WalletAPI();

        Objects.requireNonNull(getCommand("createrequest")).setExecutor(new CommandServerRequestWRLD());
        Objects.requireNonNull(getCommand("listrequests")).setExecutor(new CommandListPendingRequests());
        Objects.requireNonNull(getCommand("simulatetx")).setExecutor(new CommandSimulateWRLDTransaction());
        Objects.requireNonNull(getCommand("payplayer")).setExecutor(new CommandPayPlayer());
        Objects.requireNonNull(getCommand("listnfts")).setExecutor(new CommandListNFTs());
        Objects.requireNonNull(getCommand("mintnft")).setExecutor(new CommandMintNFT());

        getServer().getPluginManager().registerEvents(new PlayerTransactEventListener(), this);

        getServer().getLogger().info("NFT Worlds WRLD Payments Commands enabled!");
    }
}
