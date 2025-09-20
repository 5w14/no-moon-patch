package com.fivew14.nomoonpatch.mixin;

import net.mcreator.nomoon.network.NoMoonModVariables;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NoMoonModVariables.WorldVariables.class)
public class CasinoSyncWorldMixin {
    @Inject(at=@At("HEAD"),method = "syncData",cancellable = true,remap = false)
    public void sync(LevelAccessor world, CallbackInfo ci) {
        if (RandomSource.create().nextFloat() > 1/8f) // Don't laugh. Nvm, do laugh:)
            ci.cancel();
    }

}
