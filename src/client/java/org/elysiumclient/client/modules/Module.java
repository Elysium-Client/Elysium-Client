package org.elysiumclient.client.modules;

import net.minecraft.client.Minecraft;

public abstract class Module {
    private final String name;
    private final Category category;
    private boolean toggled;
    protected final Minecraft mc = Minecraft.getInstance();

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
        this.toggled = false;
    }

    public String getName() { return name; }
    public Category getCategory() { return  category; }
    public boolean isToggled() { return toggled; }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
        if (toggled) onEnable(); else onDisable();
    }

    public void toggle() {
        setToggled(!this.toggled);
    }

    public void onEnable() {}
    public void onDisable() {}

}
