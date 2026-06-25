package org.elysiumclient.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.elysiumclient.client.ElysiumClient;
import org.elysiumclient.client.modules.Category;
import org.elysiumclient.client.modules.Module;
import org.elysiumclient.client.modules.ModuleManager;
import org.lwjgl.glfw.GLFW;

public class ClickGuiScreen extends Screen {
    private final ModuleManager manager;

    public ClickGuiScreen() {
        super(Component.literal("Elysium Module Manager"));
        this.manager = ElysiumClient.getModuleManager();
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics, mouseX, mouseY, partialTick);

        int startX = 30;
        int panelWidth = 110;

        for (Category category : Category.values()) {
            int startY = 40;

            graphics.fill(startX, startY, startX + panelWidth, startY + 16, 0xFF151515);
            graphics.drawString(this.font, category.name(), startX + 6, startY + 4, 0xFFFFAA00);
            startY += 18;

            for (Module mod : manager.getModulesByCategory(category)) {
                int componentColor = mod.isToggled() ? 0xFF2D7D46 : 0xFF2A2A2A;
                int textColor = mod.isToggled() ? 0xFFFFFFFF : 0xFF888888;

                graphics.fill(startX, startY, startX + panelWidth, startY + 14, componentColor);
                graphics.drawString(this.font, mod.getName(), startX + 6, startY + 3, textColor);

                startY += 16;
            }

            startX += panelWidth + 20;
        }

        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == GLFW.GLFW_MOUSE_BUTTON_1) {
            int startX = 30;
            int panelWidth = 110;

            for (Category category : Category.values()) {
                int startY = 58;

                for (Module mod : manager.getModulesByCategory(category)) {
                    if (mouseX >= startX && mouseX <= startX + panelWidth && mouseY >= startY && mouseY <= startY + 14) {
                        mod.toggle();
                        return true;
                    }
                    startY += 16;
                }
                startX += panelWidth + 20;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}