package com.draxon.f3commands.commands.debug;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public final class DebugCommands {

    public static void register(CommandDispatcher<FabricClientCommandSource> d) {

        // Tooltip & Display Commands
        d.register(literal("advtooltips").executes(ctx -> {
            boolean v = mc().options.advancedItemTooltips;
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Advanced Tooltips: §f" + (v ? "Enabled" : "Disabled")));
            return 1;
        }));

        d.register(literal("switchtooltips").executes(ctx -> {
            mc().options.advancedItemTooltips = !mc().options.advancedItemTooltips;
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Advanced Tooltips: §f" + (mc().options.advancedItemTooltips ? "Enabled" : "Disabled")));
            return 1;
        }));

        // Client Reload Commands
        d.register(literal("rechunks").executes(ctx -> {
            mc().worldRenderer.reload();
            ctx.getSource().sendFeedback(Text.literal("§6Chunks reloaded"));
            return 1;
        }));

        d.register(literal("reresources").executes(ctx -> {
            mc().reloadResources();
            ctx.getSource().sendFeedback(Text.literal("§6Resources reloading..."));
            return 1;
        }));

        d.register(literal("clearchat").executes(ctx -> {
            mc().inGameHud.getChatHud().clear(false);
            ctx.getSource().sendFeedback(Text.literal("§6Chat cleared"));
            return 1;
        }));

        // Graphics Info Commands
        d.register(literal("checkfullscreen").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Fullscreen: §f" + (mc().getWindow().isFullscreen() ? "On" : "Off")));
            return 1;
        }));

        d.register(literal("checkvsync").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6VSync: §f" + (mc().options.getEnableVsync().getValue() ? "On" : "Off")));
            return 1;
        }));

        d.register(literal("checkfov").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6FOV: §f" + mc().options.getFov().getValue()));
            return 1;
        }));

        d.register(literal("checkrenderdist").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Render Distance: §f" + mc().options.getViewDistance().getValue() + " chunks"));
            return 1;
        }));

        d.register(literal("checksimuldist").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Simulation Distance: §f" + mc().options.getSimulationDistance().getValue() + " chunks"));
            return 1;
        }));

        d.register(literal("checkgraphics").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Graphics: §f" + mc().options.getGraphicsMode().getValue()));
            return 1;
        }));

        d.register(literal("checkframelimit").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Max Framerate: §f" + mc().options.getMaxFps().getValue()));
            return 1;
        }));

        d.register(literal("checkguiscale").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6GUI Scale: §f" + mc().options.getGuiScale().getValue()));
            return 1;
        }));

        d.register(literal("checkbrightness").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    String.format("§6Brightness: §f%.0f%%", 
                    mc().options.getGamma().getValue() * 100)));
            return 1;
        }));

        d.register(literal("checkentitydist").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Entity Distance: §f" + mc().options.getEntityDistanceScaling().getValue() + "%"));
            return 1;
        }));

        // Audio Info Commands
        d.register(literal("checkmastervol").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    String.format("§6Master Volume: §f%.0f%%", 
                    mc().options.getSoundVolume(net.minecraft.sound.SoundCategory.MASTER) * 100)));
            return 1;
        }));

        d.register(literal("checkmusicvol").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    String.format("§6Music Volume: §f%.0f%%", 
                    mc().options.getSoundVolume(net.minecraft.sound.SoundCategory.MUSIC) * 100)));
            return 1;
        }));

        // Performance Info Commands
        d.register(literal("checkmipmaplevel").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Mipmap Level: §f" + mc().options.getMipmapLevels().getValue()));
            return 1;
        }));

        d.register(literal("checkparticles").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Particles: §f" + mc().options.getParticles().getValue()));
            return 1;
        }));

        d.register(literal("checksmoothlighting").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Smooth Lighting: §f" + mc().options.getAo().getValue()));
            return 1;
        }));

        d.register(literal("checkclouds").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Clouds: §f" + mc().options.getCloudRenderMode().getValue()));
            return 1;
        }));

        d.register(literal("checkbiomeblend").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Biome Blend: §f" + mc().options.getBiomeBlendRadius().getValue() + " blocks"));
            return 1;
        }));

        d.register(literal("checkautosave").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Autosave Indicator: §f" + (mc().options.getShowAutosaveIndicator().getValue() ? "On" : "Off")));
            return 1;
        }));

        d.register(literal("viewlimitations").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Note: §fHitboxes and chunk borders require vanilla F3 keys in 1.21.5"));
            return 1;
        }));

        d.register(literal("windowinfo").executes(ctx -> {
            var w = mc().getWindow();
            ctx.getSource().sendFeedback(Text.literal(
                    String.format("§6Window: §f%dx%d (%dx%d scaled)", 
                    w.getFramebufferWidth(), w.getFramebufferHeight(),
                    w.getScaledWidth(), w.getScaledHeight())));
            return 1;
        }));
    }

    private static MinecraftClient mc() {
        return MinecraftClient.getInstance();
    }

    private DebugCommands() {}
}