package org.elysiumclient.client;

import net.fabricmc.api.ClientModInitializer;
import org.elysiumclient.client.modules.ModuleManager;

public class ElysiumClient implements ClientModInitializer {
	private static ModuleManager moduleManager;

	@Override
	public void onInitializeClient() {
		moduleManager = new ModuleManager();
	}

	public static ModuleManager getModuleManager() {
		return moduleManager;
	}
}