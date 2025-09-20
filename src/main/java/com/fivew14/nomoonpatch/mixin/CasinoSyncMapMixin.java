package com.fivew14.nomoonpatch.mixin;

import com.fivew14.nomoonpatch.Nomoonpatch;
import net.mcreator.nomoon.network.NoMoonModVariables;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NoMoonModVariables.MapVariables.class)
public class CasinoSyncMapMixin {
    @Inject(at=@At("HEAD"),method = "syncData",cancellable = true,remap = false)
    public void sync(LevelAccessor world, CallbackInfo ci) {
        if (RandomSource.create().nextFloat() < Nomoonpatch.PACKET_DROP_CHANCE)
            ci.cancel();
    }
}
