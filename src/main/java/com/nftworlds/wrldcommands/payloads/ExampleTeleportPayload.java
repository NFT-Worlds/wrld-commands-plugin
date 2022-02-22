package com.nftworlds.wrldcommands.payloads;

import org.bukkit.Location;

// This example transaction payload allows passing a Bukkit location object to your transaction handler.
// This test plugin will interpret this payload by teleporting the player back to where they ran createrequest.
public class ExampleTeleportPayload {
    public Location location;
    public ExampleTeleportPayload(Location l) {
        this.location = l;
    }
}
