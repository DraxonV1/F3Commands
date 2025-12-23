package com.draxon.f3commands.commands.info;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public final class InfoCommands {

    public static void register(CommandDispatcher<FabricClientCommandSource> d) {

        d.register(literal("coordsinfo").executes(c -> {
            var p = mc().player;
            c.getSource().sendFeedback(Text.literal(
                    String.format("XYZ: %.2f %.2f %.2f", p.getX(), p.getY(), p.getZ())));
            return 1;
        }));

        d.register(literal("dimensioninfo").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "Dimension: " + mc().world.getRegistryKey().getValue()));
            return 1;
        }));

        d.register(literal("biomeinfo").executes(c -> {
            var biome = mc().world.getBiome(mc().player.getBlockPos())
                    .getKey().map(k -> k.getValue().toString()).orElse("unknown");
            c.getSource().sendFeedback(Text.literal("Biome: " + biome));
            return 1;
        }));

        d.register(literal("directioninfo").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "Facing: " + mc().player.getHorizontalFacing()));
            return 1;
        }));

        d.register(literal("daytimeinfo").executes(c -> {
            long t = mc().world.getTimeOfDay() % 24000;
            c.getSource().sendFeedback(Text.literal("Day time: " + t));
            return 1;
        }));

        d.register(literal("healthinfo").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "Health: " + mc().player.getHealth()));
            return 1;
        }));

        d.register(literal("foodinfo").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "Food: " + mc().player.getHungerManager().getFoodLevel()));
            return 1;
        }));

        d.register(literal("armorinfo").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "Armor: " + mc().player.getArmor()));
            return 1;
        }));

        d.register(literal("ongroundinfo").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "On ground: " + mc().player.isOnGround()));
            return 1;
        }));

        d.register(literal("velocityinfo").executes(c -> {
            var v = mc().player.getVelocity();
            c.getSource().sendFeedback(Text.literal(
                    String.format("Velocity: %.3f %.3f %.3f", v.x, v.y, v.z)));
            return 1;
        }));
    }

    private static MinecraftClient mc() {
        return MinecraftClient.getInstance();
    }

    private InfoCommands() {}
}
