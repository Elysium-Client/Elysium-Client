package org.elysiumclient.client.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.elysiumclient.client.utils.FpsTrackerUtil;

public class FpsOverlayHud {
    public static void render(GuiGraphics context) {
        Minecraft client = Minecraft.getInstance();

        if (client.options.hideGui || client.getDebugOverlay().showDebugScreen()) {
            return;
        }

        int fps = FpsTrackerUtil.getCurrentFps();
        String fpsString = "FPS: " + fps;

        context.drawString(
                client.font,
                fpsString,
                0,
                0,
                0xFFFFFFFF,
                true
        );

    }
}