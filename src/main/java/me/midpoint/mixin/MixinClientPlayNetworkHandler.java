package me.midpoint.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class MixinClientPlayNetworkHandler {
    @Inject(at = @At("RETURN"), method = "onEntitySpawn")
    private void onEntitySpawn(EntitySpawnS2CPacket packet, CallbackInfo ci) {
        // Перехват спавна сущностей для ESP
        // Реальная логика в ESPModule
    }
}
