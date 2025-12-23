package com.draxon.f3commands.commands.help;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public final class F3HelpCommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> d) {
        d.register(literal("f3help").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal("§6=== F3 Commands Help ==="));
            ctx.getSource().sendFeedback(Text.literal("§e/f3info §7- Show info commands"));
            ctx.getSource().sendFeedback(Text.literal("§e/f3debug §7- Show debug commands"));
            ctx.getSource().sendFeedback(Text.literal("§e/f3perf §7- Show performance commands"));
            return 1;
        }));

        d.register(literal("f3info").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal("§6=== Info Commands ==="));
            ctx.getSource().sendFeedback(Text.literal("§aPosition:§f /mycoords /myblockpos /mychunkpos /myrotation"));
            ctx.getSource().sendFeedback(Text.literal("§aWorld:§f /mydimension /mybiome /myfacing /currenttime"));
            ctx.getSource().sendFeedback(Text.literal("§aPlayer:§f /myhealth /myhunger /myarmor /myxplevel"));
            ctx.getSource().sendFeedback(Text.literal("§aMovement:§f /amionground /myvelocity /myspeed"));
            ctx.getSource().sendFeedback(Text.literal("§aEnvironment:§f /lightlevel /currentweather /moonphase"));
            return 1;
        }));

        d.register(literal("f3debug").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal("§6=== Debug Commands ==="));
            ctx.getSource().sendFeedback(Text.literal("§aTooltips:§f /advtooltips /switchtooltips"));
            ctx.getSource().sendFeedback(Text.literal("§aReload:§f /rechunks /reresources /clearchat"));
            ctx.getSource().sendFeedback(Text.literal("§aGraphics:§f /checkfullscreen /checkvsync /checkfov"));
            ctx.getSource().sendFeedback(Text.literal("§aSettings:§f /checkrenderdist /checkgraphics /checkguiscale"));
            ctx.getSource().sendFeedback(Text.literal("§aDisplay:§f /windowinfo /viewlimitations"));
            return 1;
        }));

        d.register(literal("f3perf").executes(ctx -> {
            ctx.getSource().sendFeedback(Text.literal("§6=== Performance Commands ==="));
            ctx.getSource().sendFeedback(Text.literal("§aFPS:§f /currentfps /avgfps /maxfps /minfps /fpsreport"));
            ctx.getSource().sendFeedback(Text.literal("§aMemory:§f /memused /memmax /memusage /memreport"));
            ctx.getSource().sendFeedback(Text.literal("§aChunks:§f /chunksloaded /chunkupdates /chunkstats"));
            ctx.getSource().sendFeedback(Text.literal("§aSystem:§f /cpucores /javaversion /sysreport"));
            ctx.getSource().sendFeedback(Text.literal("§aOverview:§f /perfstatus"));
            return 1;
        }));
    }

    private F3HelpCommand() {}
}