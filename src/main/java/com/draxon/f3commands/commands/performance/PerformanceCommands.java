package com.draxon.f3commands.commands.performance;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public final class PerformanceCommands {

    public static void register(CommandDispatcher<FabricClientCommandSource> d) {

        // FPS Commands
        d.register(literal("currentfps").executes(ctx -> {
            send(ctx.getSource(), "Current FPS", mc().getCurrentFps());
            return 1;
        }));

        d.register(literal("avgfps").executes(ctx -> {
            send(ctx.getSource(), "Average FPS", avg());
            return 1;
        }));

        d.register(literal("maxfps").executes(ctx -> {
            send(ctx.getSource(), "Max FPS", max());
            return 1;
        }));

        d.register(literal("minfps").executes(ctx -> {
            send(ctx.getSource(), "Min FPS", min());
            return 1;
        }));

        d.register(literal("fpsreport").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal("§6=== FPS Report ==="));
            ctx.getSource().sendFeedback(Text.literal("§6Current: §f" + mc().getCurrentFps()));
            ctx.getSource().sendFeedback(Text.literal("§6Average: §f" + avg()));
            ctx.getSource().sendFeedback(Text.literal("§6Maximum: §f" + max()));
            ctx.getSource().sendFeedback(Text.literal("§6Minimum: §f" + min()));
            return 1;
        }));

        // Memory Commands
        d.register(literal("memused").executes(ctx -> {
            send(ctx.getSource(), "Memory Used (MB)", usedMem());
            return 1;
        }));

        d.register(literal("memmax").executes(ctx -> {
            send(ctx.getSource(), "Memory Max (MB)", maxMem());
            return 1;
        }));

        d.register(literal("memfree").executes(ctx -> {
            send(ctx.getSource(), "Memory Free (MB)", freeMem());
            return 1;
        }));

        d.register(literal("memusage").executes(ctx -> {
            int used = usedMem();
            int max = maxMem();
            int percent = (int)((used / (float)max) * 100);
            ctx.getSource().sendFeedback(Text.literal(
                    String.format("§6Memory Usage: §f%d MB / %d MB (§c%d%%§f)", used, max, percent)));
            return 1;
        }));

        d.register(literal("memreport").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal("§6=== Memory Report ==="));
            ctx.getSource().sendFeedback(Text.literal("§6Used: §f" + usedMem() + " MB"));
            ctx.getSource().sendFeedback(Text.literal("§6Free: §f" + freeMem() + " MB"));
            ctx.getSource().sendFeedback(Text.literal("§6Max: §f" + maxMem() + " MB"));
            int percent = (int)((usedMem() / (float)maxMem()) * 100);
            ctx.getSource().sendFeedback(Text.literal("§6Usage: §c" + percent + "%"));
            return 1;
        }));

        // Chunk Commands
        d.register(literal("chunkupdates").executes(ctx -> {
            int updates = mc().worldRenderer != null ? mc().worldRenderer.getCompletedChunkCount() : 0;
            ctx.getSource().sendFeedback(Text.literal("§6Chunk Updates: §f" + updates));
            return 1;
        }));

        d.register(literal("chunksloaded").executes(ctx -> {
            int loaded = mc().world != null ? mc().world.getChunkManager().getLoadedChunkCount() : 0;
            ctx.getSource().sendFeedback(Text.literal("§6Chunks Loaded: §f" + loaded));
            return 1;
        }));

        d.register(literal("chunkstats").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal("§6=== Chunk Statistics ==="));
            int loaded = mc().world != null ? mc().world.getChunkManager().getLoadedChunkCount() : 0;
            ctx.getSource().sendFeedback(Text.literal("§6Loaded: §f" + loaded));
            int updates = mc().worldRenderer != null ? mc().worldRenderer.getCompletedChunkCount() : 0;
            ctx.getSource().sendFeedback(Text.literal("§6Rendered: §f" + updates));
            return 1;
        }));

        // Entity Commands
        d.register(literal("entitycount").executes(ctx -> {
            int count = mc().world != null ? mc().world.getRegularEntityCount() : 0;
            ctx.getSource().sendFeedback(Text.literal("§6Total Entities: §f" + count));
            return 1;
        }));

        d.register(literal("particlecount").executes(ctx -> {
            String debugStr = mc().particleManager != null ? mc().particleManager.getDebugString() : "0";
            ctx.getSource().sendFeedback(Text.literal("§6Particle Info: §f" + debugStr));
            return 1;
        }));

        // System Commands
        d.register(literal("javaversion").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal(
                    "§6Java Version: §f" + System.getProperty("java.version")));
            return 1;
        }));

        d.register(literal("cpucores").executes(ctx -> {
            int cores = Runtime.getRuntime().availableProcessors();
            ctx.getSource().sendFeedback(Text.literal("§6CPU Cores: §f" + cores));
            return 1;
        }));

        d.register(literal("osinfo").executes(ctx -> {
            String os = System.getProperty("os.name") + " " + System.getProperty("os.version");
            ctx.getSource().sendFeedback(Text.literal("§6OS: §f" + os));
            return 1;
        }));

        d.register(literal("sysreport").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal("§6=== System Report ==="));
            ctx.getSource().sendFeedback(Text.literal("§6OS: §f" + System.getProperty("os.name")));
            ctx.getSource().sendFeedback(Text.literal("§6Java: §f" + System.getProperty("java.version")));
            ctx.getSource().sendFeedback(Text.literal("§6CPU Cores: §f" + Runtime.getRuntime().availableProcessors()));
            return 1;
        }));

        // Performance Reset
        d.register(literal("resetfpstracker").executes(ctx -> {
            PerformanceTracker.reset();
            ctx.getSource().sendFeedback(Text.literal("§6FPS tracker reset"));
            return 1;
        }));

        // Combined Performance Report
        d.register(literal("perfstatus").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal("§6=== Performance Status ==="));
            ctx.getSource().sendFeedback(Text.literal("§6FPS: §f" + mc().getCurrentFps() + " (avg: " + avg() + ")"));
            int used = usedMem();
            int max = maxMem();
            int percent = (int)((used / (float)max) * 100);
            ctx.getSource().sendFeedback(Text.literal(
                    String.format("§6Memory: §f%d/%d MB (§c%d%%§f)", used, max, percent)));
            int chunks = mc().world != null ? mc().world.getChunkManager().getLoadedChunkCount() : 0;
            ctx.getSource().sendFeedback(Text.literal("§6Chunks: §f" + chunks));
            return 1;
        }));
    }

    private static void send(FabricClientCommandSource src, String name, int val) {
        src.sendFeedback(Text.literal("§6" + name + ": §f" + val));
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

    private static int freeMem() {
        return maxMem() - usedMem();
    }

    private static MinecraftClient mc() {
        return MinecraftClient.getInstance();
    }

    private PerformanceCommands() {}
}