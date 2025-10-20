package com.fivew14.nomoonpatch.mixin.dedicatedFixes;

import ca.weblite.objc.Client;
import com.mojang.logging.LogUtils;
import net.mcreator.nomoon.configuration.ClientConfiguration;
import net.mcreator.nomoon.procedures.PlayerTickNewProcedure;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.forgespi.Environment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerTickNewProcedure.class)
@SuppressWarnings("unchecked")
public class PlayerTickProcedureMixin {
    @Redirect(
            at=@At(value = "INVOKE", target = "Lnet/minecraftforge/common/ForgeConfigSpec$ConfigValue;get()Ljava/lang/Object;"),
            method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V",
            remap = false
    )
    private static <T> T overrideClientConfigCalls(ForgeConfigSpec.ConfigValue<T> instance) {
        if (Environment.get().getDist().isClient())
            return instance.get();

        if (ClientConfiguration.CHASE_EFFECTS_CF.equals(instance))
            return (T) ClientConfiguration.CHASE_EFFECTS_CF.getDefault();
        if (ClientConfiguration.CHAT_DISABLED_CF.equals(instance))
            return (T) ClientConfiguration.CHAT_DISABLED_CF.getDefault();
        if (ClientConfiguration.DISPLAY_STATIC_CF.equals(instance))
            return (T) ClientConfiguration.DISPLAY_STATIC_CF.getDefault();
        if (ClientConfiguration.FLASHING_LIGHTS_CF.equals(instance))
            return (T) ClientConfiguration.FLASHING_LIGHTS_CF.getDefault();
        if (ClientConfiguration.FORCE_REACTION_CF.equals(instance))
            return (T) ClientConfiguration.FORCE_REACTION_CF.getDefault();
        if (ClientConfiguration.SUN_WARNINGS_CF.equals(instance))
            return (T) ClientConfiguration.SUN_WARNINGS_CF.getDefault();
        if (ClientConfiguration.WINDOW_MANAGER_CF.equals(instance))
            return (T) ClientConfiguration.WINDOW_MANAGER_CF.getDefault();
        if (ClientConfiguration.NO_ESCAPE_CF.equals(instance))
            return (T) ClientConfiguration.NO_ESCAPE_CF.getDefault();

        return instance.get();
    }
}
