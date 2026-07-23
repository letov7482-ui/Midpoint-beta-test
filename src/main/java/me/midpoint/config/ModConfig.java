package me.midpoint.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModConfig {
    public boolean killAuraEnabled = true;
    public float killAuraRange = 4.2f;
    public int killAuraDelay = 180;
    public float killAuraSwing = 0.15f;

    public boolean mysticFinderEnabled = true;
    public float mysticFinderRange = 64.0f;
    public boolean mysticShowDistance = true;

    public boolean espEnabled = true;
    public float espRange = 32.0f;
    public boolean espShowPlayers = true;
    public boolean espShowEntities = false;

    public boolean antiCheatBypass = true;
    public float speedMultiplier = 0.015f;

    public static ModConfig load() {
        File file = new File(FabricLoader.getInstance().getConfigDir().toFile(), "midpoint.json");
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                return new Gson().fromJson(reader, ModConfig.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ModConfig();
    }

    public void save() {
        File file = new File(FabricLoader.getInstance().getConfigDir().toFile(), "midpoint.json");
        try (FileWriter writer = new FileWriter(file)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
