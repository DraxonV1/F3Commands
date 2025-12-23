package com.draxon.f3commands.commands.performance;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public final class PerformanceCommands {

    public static void register(CommandDispatcher<FabricClientCommandSource> d) {

        d.register(literal("fpscurrent").executes(ctx -> {
            send(ctx.getSource(), "FPS (current)", mc().getCurrentFps());
            return 1;
        }));

        d.register(literal("fpsaverage").executes(ctx -> {
            send(ctx.getSource(), "FPS (avg)", avg());
            return 1;
        }));

        d.register(literal("fpsmax").executes(ctx -> {
            send(ctx.getSource(), "FPS (max)", max());
            return 1;
        }));

        d.register(literal("fpsmin").executes(ctx -> {
            send(ctx.getSource(), "FPS (min)", min());
            return 1;
        }));

        d.register(literal("memoryused").executes(ctx -> {
            send(ctx.getSource(), "Memory used (MB)", usedMem());
            return 1;
        }));

        d.register(literal("memorymax").executes(ctx -> {
            send(ctx.getSource(), "Memory max (MB)", maxMem());
            return 1;
        }));
    }

    private static void send(FabricClientCommandSource src, String name, int val) {
        src.sendFeedback(Text.literal(name + ": " + val));
    }

    private static int avg() {
        int sum = 0, n = PerformanceTracker.count();
        for (int i = 0; i < n; i++) sum += PerformanceTracker.data()[i];
        return n == 0 ? 0 : sum / n;
    }

    private static int max() {
        int m = 0;
        for (int i : PerformanceTracker.data()) m = Math.max(m, i);
        return m;
    }

    private static int min() {
        int m = Integer.MAX_VALUE;
        for (int i : PerformanceTracker.data())
            if (i > 0) m = Math.min(m, i);
        return m == Integer.MAX_VALUE ? 0 : m;
    }

    private static int usedMem() {
        return (int) ((Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory()) / 1024 / 1024);
    }

    private static int maxMem() {
        return (int) (Runtime.getRuntime().maxMemory() / 1024 / 1024);
    }

    private static MinecraftClient mc() {
        return MinecraftClient.getInstance();
    }

    private PerformanceCommands() {}
}
