package me.midpoint.modules;

import me.midpoint.MidpointClient;
import me.midpoint.utils.RotationUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;

import java.util.List;

public class KillAuraModule {
    private static long lastAttackTime = 0;

    public static void tick(MinecraftClient client) {
        if (client.player == null || client.world == null) return;

        long now = System.currentTimeMillis();
        if (now - lastAttackTime < MidpointClient.CONFIG.killAuraDelay) return;

        Box box = client.player.getBoundingBox().expand(MidpointClient.CONFIG.killAuraRange);
        List<Entity> targets = client.world.getOtherEntities(client.player, box, 
            e -> e instanceof LivingEntity && e.isAlive() && e != client.player
        );

        if (targets.isEmpty()) return;

        LivingEntity target = (LivingEntity) targets.get(0);
        RotationUtils.rotateToEntity(client, target, MidpointClient.CONFIG.killAuraSwing);
        client.interactionManager.attackEntity(client.player, target);
        client.player.swingHand(Hand.MAIN_HAND);
        lastAttackTime = now;
    }
}
