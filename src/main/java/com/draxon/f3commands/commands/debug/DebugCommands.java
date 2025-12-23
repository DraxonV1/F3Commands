package com.draxon.f3commands.commands.debug;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

/**
 * IMPORTANT:
 * Minecraft 1.21.5 does NOT expose hitbox / chunk border toggles.
 * These commands are READ-ONLY or SAFE toggles only.
 */
public final class DebugCommands {

    public static void register(CommandDispatcher<FabricClientCommandSource> d) {

        d.register(literal("advancedtooltipsinfo").executes(ctx -> {
            boolean v = mc().options.advancedItemTooltips;
            ctx.getSource().sendFeedback(Text.literal(
                    "Advanced tooltips: " + v));
            return 1;
        }));

        d.register(literal("toggleadvancedtooltips").executes(ctx -> {
            mc().options.advancedItemTooltips =
                    !mc().options.advancedItemTooltips;
            ctx.getSource().sendFeedback(Text.literal(
                    "Advanced tooltips: " + mc().options.advancedItemTooltips));
            return 1;
        }));

        d.register(literal("reloadchunksclient").executes(ctx -> {
            mc().worldRenderer.reload();
            ctx.getSource().sendFeedback(Text.literal("Chunks reloaded"));
            return 1;
        }));

        d.register(literal("reloadresourcesclient").executes(ctx -> {
            mc().reloadResources();
            ctx.getSource().sendFeedback(Text.literal("Resources reloading"));
            return 1;
        }));

        d.register(literal("clearchatclient").executes(ctx -> {
            mc().inGameHud.getChatHud().clear(false);
            ctx.getSource().sendFeedback(Text.literal("Chat cleared"));
            return 1;
        }));

        d.register(literal("fullscreeninfo").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "Fullscreen: " + mc().getWindow().isFullscreen()));
            return 1;
        }));

        d.register(literal("vsyncinfo").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "VSync: " + mc().options.getEnableVsync().getValue()));
            return 1;
        }));

        d.register(literal("fovinfo").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "FOV: " + mc().options.getFov().getValue()));
            return 1;
        }));

        d.register(literal("renderdistanceinfo").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "Render distance: " + mc().options.getViewDistance().getValue()));
            return 1;
        }));

        d.register(literal("debugavailability").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "Hitboxes / chunk borders require vanilla F3 keys in 1.21.5"));
            return 1;
        }));
    }

    private static MinecraftClient mc() {
        return MinecraftClient.getInstance();
    }

    private DebugCommands() {}
}
