package me.midpoint.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class RotationUtils {
    public static void rotateToEntity(MinecraftClient client, LivingEntity target, float swing) {
        Vec3d targetPos = target.getPos().add(0, target.getHeight() / 2, 0);
        Vec3d playerPos = client.player.getEyePos();
        
        double diffX = targetPos.x - playerPos.x;
        double diffY = targetPos.y - playerPos.y;
        double diffZ = targetPos.z - playerPos.z;
        
        double distance = Math.sqrt(diffX * diffX + diffZ * diffZ);
        float targetYaw = (float) (MathHelper.atan2(diffZ, diffX) * 180.0 / Math.PI) - 90.0f;
        float targetPitch = (float) (-MathHelper.atan2(diffY, distance) * 180.0 / Math.PI);
        
        // Плавное сглаживание
        float currentYaw = client.player.getYaw();
        float currentPitch = client.player.getPitch();
        
        float deltaYaw = MathHelper.wrapDegrees(targetYaw - currentYaw);
        float deltaPitch = MathHelper.wrapDegrees(targetPitch - currentPitch);
        
        float step = 30.0f + swing * 20.0f;
        client.player.setYaw(currentYaw + MathHelper.clamp(deltaYaw, -step, step));
        client.player.setPitch(currentPitch + MathHelper.clamp(deltaPitch, -step, step));
    }
}
