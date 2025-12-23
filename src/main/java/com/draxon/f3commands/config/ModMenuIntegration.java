package com.draxon.f3commands.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.minecraft.text.Text;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Text.literal("F3 Commands"));

            var entry = builder.entryBuilder();
            var cat = builder.getOrCreateCategory(Text.literal("General"));

            cat.addEntry(entry.startBooleanToggle(
                            Text.literal("Enable mod"), true)
                    .build());

            return builder.build();
        };
    }
}
