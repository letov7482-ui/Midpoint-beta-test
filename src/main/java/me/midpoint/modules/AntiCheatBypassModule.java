package me.midpoint.modules;

import me.midpoint.MidpointClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;

public class AntiCheatBypassModule {
    public static void tick(MinecraftClient client) {
        if (!MidpointClient.CONFIG.antiCheatBypass) return;
        if (client.player == null) return;

        Vec3d vel = client.player.getVelocity();
        float boost = MidpointClient.CONFIG.speedMultiplier;
        
        if (client.player.isOnGround() && client.player.isSprinting()) {
            double deltaX = vel.x + (Math.random() - 0.5) * boost;
            double deltaZ = vel.z + (Math.random() - 0.5) * boost;
            client.player.setVelocity(deltaX, vel.y, deltaZ);
        }
    }
}
