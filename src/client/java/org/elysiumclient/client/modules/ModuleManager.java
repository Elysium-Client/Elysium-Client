package org.elysiumclient.client.modules;

import org.elysiumclient.client.modules.hud.FpsModule;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        modules.add(new FpsModule());
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getModulesByCategory(Category category) {
        return modules.stream()
                .filter(module -> module.getCategory() == category)
                .toList();
    }

    @SuppressWarnings("unchecked")
    public <T extends Module> T getModule(Class<T> clazz) {
        return (T) modules.stream()
                .filter(m -> m.getClass() == clazz)
                .findFirst()
                .orElse(null);
    }

}
