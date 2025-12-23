package com.draxon.f3commands;

import com.draxon.f3commands.commands.CommandRegistrar;
import com.draxon.f3commands.commands.performance.PerformanceTracker;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class F3CommandsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CommandRegistrar.register();
        ClientTickEvents.END_CLIENT_TICK.register(client -> PerformanceTracker.tick());
    }
}
