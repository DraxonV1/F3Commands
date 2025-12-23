package com.draxon.f3commands.commands.info;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public final class InfoCommands {

    public static void register(CommandDispatcher<FabricClientCommandSource> d) {

        // Position Commands
        d.register(literal("mycoords").executes(c -> {
            var p = mc().player;
            c.getSource().sendFeedback(Text.literal(
                    String.format("§6Position: §f%.2f %.2f %.2f", p.getX(), p.getY(), p.getZ())));
            return 1;
        }));

        d.register(literal("myblockpos").executes(c -> {
            BlockPos pos = mc().player.getBlockPos();
            c.getSource().sendFeedback(Text.literal(
                    String.format("§6Block Position: §f%d %d %d", pos.getX(), pos.getY(), pos.getZ())));
            return 1;
        }));

        d.register(literal("mychunkpos").executes(c -> {
            BlockPos pos = mc().player.getBlockPos();
            c.getSource().sendFeedback(Text.literal(
                    String.format("§6Chunk: §f%d %d", pos.getX() >> 4, pos.getZ() >> 4)));
            return 1;
        }));

        d.register(literal("myrotation").executes(c -> {
            var p = mc().player;
            c.getSource().sendFeedback(Text.literal(
                    String.format("§6Rotation: §fYaw %.1f° Pitch %.1f°", p.getYaw(), p.getPitch())));
            return 1;
        }));

        // World Info Commands
        d.register(literal("mydimension").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "§6Dimension: §f" + mc().world.getRegistryKey().getValue()));
            return 1;
        }));

        d.register(literal("mybiome").executes(c -> {
            var biome = mc().world.getBiome(mc().player.getBlockPos())
                    .getKey().map(k -> k.getValue().toString()).orElse("unknown");
            c.getSource().sendFeedback(Text.literal("§6Biome: §f" + biome));
            return 1;
        }));

        d.register(literal("myfacing").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "§6Facing: §f" + mc().player.getHorizontalFacing()));
            return 1;
        }));

        d.register(literal("currenttime").executes(c -> {
            long t = mc().world.getTimeOfDay() % 24000;
            c.getSource().sendFeedback(Text.literal("§6Time of Day: §f" + t));
            return 1;
        }));

        d.register(literal("worldday").executes(c -> {
            long day = mc().world.getTimeOfDay() / 24000;
            c.getSource().sendFeedback(Text.literal("§6World Day: §f" + day));
            return 1;
        }));

        d.register(literal("moonphase").executes(c -> {
            int phase = mc().world.getMoonPhase();
            String[] phases = {"Full Moon", "Waning Gibbous", "Last Quarter", "Waning Crescent",
                    "New Moon", "Waxing Crescent", "First Quarter", "Waxing Gibbous"};
            c.getSource().sendFeedback(Text.literal("§6Moon Phase: §f" + phases[phase]));
            return 1;
        }));

        // Player State Commands
        d.register(literal("myhealth").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    String.format("§6Health: §f%.1f / %.1f", 
                    mc().player.getHealth(), mc().player.getMaxHealth())));
            return 1;
        }));

        d.register(literal("myhunger").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "§6Hunger: §f" + mc().player.getHungerManager().getFoodLevel() + " / 20"));
            return 1;
        }));

        d.register(literal("mysaturation").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    String.format("§6Saturation: §f%.1f", 
                    mc().player.getHungerManager().getSaturationLevel())));
            return 1;
        }));

        d.register(literal("myarmor").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "§6Armor: §f" + mc().player.getArmor()));
            return 1;
        }));

        d.register(literal("myair").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "§6Air: §f" + mc().player.getAir() + " / " + mc().player.getMaxAir()));
            return 1;
        }));

        d.register(literal("myxplevel").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "§6Experience Level: §f" + mc().player.experienceLevel));
            return 1;
        }));

        d.register(literal("myxpbar").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    String.format("§6Experience Progress: §f%.1f%%", 
                    mc().player.experienceProgress * 100)));
            return 1;
        }));

        // Movement Commands
        d.register(literal("amionground").executes(c -> {
            c.getSource().sendFeedback(Text.literal(
                    "§6On Ground: §f" + mc().player.isOnGround()));
            return 1;
        }));

        d.register(literal("myvelocity").executes(c -> {
            var v = mc().player.getVelocity();
            c.getSource().sendFeedback(Text.literal(
                    String.format("§6Velocity: §fX %.3f Y %.3f Z %.3f", v.x, v.y, v.z)));
            return 1;
        }));

        d.register(literal("myspeed").executes(c -> {
            var v = mc().player.getVelocity();
            double speed = Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z);
            c.getSource().sendFeedback(Text.literal(
                    String.format("§6Speed: §f%.3f m/s", speed * 20)));
            return 1;
        }));

        d.register(literal("myhorizontalspeed").executes(c -> {
            var v = mc().player.getVelocity();
            double speed = Math.sqrt(v.x * v.x + v.z * v.z);
            c.getSource().sendFeedback(Text.literal(
                    String.format("§6Horizontal Speed: §f%.3f m/s", speed * 20)));
            return 1;
        }));

        // Environmental Commands
        d.register(literal("lightlevel").executes(c -> {
            BlockPos pos = mc().player.getBlockPos();
            int light = mc().world.getLightLevel(pos);
            c.getSource().sendFeedback(Text.literal("§6Light Level: §f" + light));
            return 1;
        }));

        d.register(literal("skylightlevel").executes(c -> {
            BlockPos pos = mc().player.getBlockPos();
            int light = mc().world.getLightLevel(net.minecraft.world.LightType.SKY, pos);
            c.getSource().sendFeedback(Text.literal("§6Sky Light: §f" + light));
            return 1;
        }));

        d.register(literal("blocklightlevel").executes(c -> {
            BlockPos pos = mc().player.getBlockPos();
            int light = mc().world.getLightLevel(net.minecraft.world.LightType.BLOCK, pos);
            c.getSource().sendFeedback(Text.literal("§6Block Light: §f" + light));
            return 1;
        }));

        d.register(literal("currentweather").executes(c -> {
            boolean raining = mc().world.isRaining();
            boolean thundering = mc().world.isThundering();
            String weather = thundering ? "Thundering" : raining ? "Raining" : "Clear";
            c.getSource().sendFeedback(Text.literal("§6Weather: §f" + weather));
            return 1;
        }));
    }

    private static MinecraftClient mc() {
        return MinecraftClient.getInstance();
    }

    private InfoCommands() {}
}