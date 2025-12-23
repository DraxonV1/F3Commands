package com.draxon.f3commands.commands.help;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public final class F3HelpCommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> d) {
        d.register(literal("f3").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal("§6F3 Commands"));
            ctx.getSource().sendFeedback(Text.literal(
                    "/coordsinfo /biomeinfo /daytimeinfo"));
            ctx.getSource().sendFeedback(Text.literal(
                    "/togglehitboxes /togglechunkborders"));
            ctx.getSource().sendFeedback(Text.literal(
                    "/fpscurrent /fpsaverage /fpsmax /fpsmin"));
            return 1;
        }));
    }

    private F3HelpCommand() {}
}
