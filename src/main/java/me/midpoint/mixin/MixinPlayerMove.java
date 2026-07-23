package me.midpoint.mixin;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerMoveC2SPacket.class)
public class MixinPlayerMove {
    @Shadow protected float yaw;
    private float lastYaw = 0;

    @Inject(at = @At("HEAD"), method = "write", cancellable = true)
    public void onWrite(CallbackInfo ci) {
        float delta = this.yaw - lastYaw;
        if (Math.abs(delta) > 0.5f) {
            this.yaw += (float) (Math.random() * 0.1f - 0.05f);
        }
        lastYaw = this.yaw;
    }
}
