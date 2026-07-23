package me.midpoint;

import me.midpoint.config.ModConfig;
import me.midpoint.modules.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class MidpointClient implements ClientModInitializer {
    public static final String MOD_ID = "midpoint";
    public static ModConfig CONFIG;
    public static KeyBinding menuKey;

    @Override
    public void onInitializeClient() {
        CONFIG = ModConfig.load();
        
        menuKey = KeyBindingHelper.registerKeyBinding(
            new KeyBinding("key.midpoint.menu", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_P, "category.midpoint.general")
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.world == null) return;
            
            if (CONFIG.killAuraEnabled) KillAuraModule.tick(client);
            if (CONFIG.mysticFinderEnabled) MysticFinderModule.tick(client);
            if (CONFIG.espEnabled) ESPModule.tick(client);
            if (CONFIG.antiCheatBypass) AntiCheatBypassModule.tick(client);
        });

        System.out.println("[Midpoint] Божественный клиент загружен!");
    }
}
