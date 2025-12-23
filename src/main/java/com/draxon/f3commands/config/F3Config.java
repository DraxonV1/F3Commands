package com.draxon.f3commands.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class F3Config {

    // Configuration Fields
    public boolean enableTimeWorld = true;
    public boolean enableTargetInfo = true;
    public boolean enableDebugToggles = true;
    public boolean enablePerformance = true;
    public boolean enablePlayerInfo = true;
    public boolean enableF3RootCommand = true;

    private static F3Config INSTANCE;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = FabricLoader.getInstance().getConfigDir().resolve("f3commands.json").toFile();

    /**
     * Returns the current config instance. Loads from disk if not already initialized.
     */
    public static F3Config get() {
        if (INSTANCE == null) {
            INSTANCE = load();
        }
        return INSTANCE;
    }

    /**
     * Loads config from the f3commands.json file.
     */
    private static F3Config load() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                return GSON.fromJson(reader, F3Config.class);
            } catch (IOException e) {
                System.err.println("[F3 Commands] Failed to load config, using defaults.");
                e.printStackTrace();
            }
        }
        return new F3Config(); // Return default if file doesn't exist
    }

    /**
     * Saves the current configuration to disk.
     * Called by the "SavingRunnable" in ModMenuIntegration.
     */
    public void save() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(this, writer);
        } catch (IOException e) {
            System.err.println("[F3 Commands] Failed to save config.");
            e.printStackTrace();
        }
    }

    private F3Config() {}
}
