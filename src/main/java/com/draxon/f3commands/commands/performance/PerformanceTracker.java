package com.draxon.f3commands.commands.performance;

import net.minecraft.client.MinecraftClient;

public final class PerformanceTracker {

    private static final int MAX_SAMPLES = 20 * 60 * 10; // 10 minutes
    private static final int[] fpsSamples = new int[MAX_SAMPLES];
    private static int index = 0;
    private static boolean filled = false;

    public static void tick() {
        fpsSamples[index++] = MinecraftClient.getInstance().getCurrentFps();
        if (index >= MAX_SAMPLES) {
            index = 0;
            filled = true;
        }
    }

    public static int[] data() {
        return fpsSamples;
    }

    public static int count() {
        return filled ? MAX_SAMPLES : index;
    }

    private PerformanceTracker() {}
}
