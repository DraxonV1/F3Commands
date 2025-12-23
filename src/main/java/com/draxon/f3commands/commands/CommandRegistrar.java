package com.draxon.f3commands.commands;

import com.draxon.f3commands.commands.debug.DebugCommands;
import com.draxon.f3commands.commands.help.F3HelpCommand;
import com.draxon.f3commands.commands.info.InfoCommands;
import com.draxon.f3commands.commands.performance.PerformanceCommands;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public final class CommandRegistrar {

    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, access) -> {
            InfoCommands.register(dispatcher);
            DebugCommands.register(dispatcher);
            PerformanceCommands.register(dispatcher);
            F3HelpCommand.register(dispatcher);
        });
    }

    private CommandRegistrar() {}
}
