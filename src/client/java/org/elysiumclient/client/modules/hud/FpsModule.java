package org.elysiumclient.client.modules.hud;

import org.elysiumclient.client.modules.Category;
import org.elysiumclient.client.modules.Module;

public class FpsModule extends Module {
    public FpsModule() {
        super("FPS DISPLAY", Category.HUD);
        this.setToggled(true);
    }
}