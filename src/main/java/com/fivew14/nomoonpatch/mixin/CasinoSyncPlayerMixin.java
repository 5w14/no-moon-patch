package com.fivew14.nomoonpatch.mixin;

import com.fivew14.nomoonpatch.Nomoonpatch;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import net.mcreator.nomoon.network.NoMoonModVariables;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NoMoonModVariables.PlayerVariables.class)
public class CasinoSyncPlayerMixin {
    @Inject(at=@At("HEAD"),method = "syncPlayerVariables",cancellable = true,remap = false)
    public void sync(Entity entity, CallbackInfo ci) {
        if (Nomoonpatch.shouldDropPacket())
            ci.cancel();
    }
}
