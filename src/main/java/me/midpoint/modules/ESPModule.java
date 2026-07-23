package me.midpoint.modules;

import me.midpoint.MidpointClient;
import me.midpoint.utils.RenderUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;

import java.awt.*;

public class ESPModule {
    public static void tick(MinecraftClient client) {
        for (Entity entity : client.world.getEntities()) {
            if (entity == client.player) continue;

            if (MidpointClient.CONFIG.espShowPlayers && entity instanceof PlayerEntity) {
                Box box = entity.getBoundingBox().offset(-entity.getPos().x, -entity.getPos().y, -entity.getPos().z);
                RenderUtils.drawBox(box, Color.CYAN);
            }

            if (MidpointClient.CONFIG.espShowEntities && !(entity instanceof PlayerEntity)) {
                Box box = entity.getBoundingBox().offset(-entity.getPos().x, -entity.getPos().y, -entity.getPos().z);
                RenderUtils.drawBox(box, Color.ORANGE);
            }
        }
    }
}
