package com.fivew14.nomoonpatch.mixin;

import com.fivew14.nomoonpatch.Nomoonpatch;
import net.mcreator.nomoon.network.NoMoonModVariables;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NoMoonModVariables.WorldVariables.class)
public class CasinoSyncWorldMixin {
    @Inject(at=@At("HEAD"),method = "syncData",cancellable = true,remap = false)
    public void sync(LevelAccessor world, CallbackInfo ci) {
        if (!(world instanceof Level level)) return;

        var dimension = level.dimension().location();

        if (Nomoonpatch.dimensionSynced.contains(dimension)) {
            ci.cancel();
            return;
        }

        Nomoonpatch.dimensionSynced.add(dimension);
    }
}
