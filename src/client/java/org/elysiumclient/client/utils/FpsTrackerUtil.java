package org.elysiumclient.client.utils;

import net.minecraft.client.Minecraft;

public class FpsTrackerUtil {
    public static int getCurrentFps() {
        Minecraft client = Minecraft.getInstance();
        return client.getFps();
    }
}