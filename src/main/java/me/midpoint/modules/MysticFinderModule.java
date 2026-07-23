package me.midpoint.modules;

import me.midpoint.MidpointClient;
import me.midpoint.utils.RenderUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

import java.awt.*;

public class MysticFinderModule {
    public static void tick(MinecraftClient client) {
        for (Entity entity : client.world.getEntities()) {
            if (!(entity instanceof LivingEntity)) continue;
            if (entity == client.player) continue;

            double dist = client.player.distanceTo(entity);
            if (dist > MidpointClient.CONFIG.mysticFinderRange) continue;

            if (isMystic(entity)) {
                Vec3d pos = entity.getPos().add(0, entity.getHeight() + 0.5, 0);
                RenderUtils.drawText(pos, "M", Color.MAGENTA);
                
                if (MidpointClient.CONFIG.mysticShowDistance) {
                    RenderUtils.drawText(pos.add(0, -0.3, 0), 
                        String.format("%.1fм", dist), Color.WHITE);
                }
            }
        }
    }

    private static boolean isMystic(Entity entity) {
        if (entity.hasCustomName()) {
            String name = entity.getCustomName().getString();
            return name.contains("Мистик") || name.contains("Mystic") || name.equals("§eMystic");
        }
        return false;
    }
}
