package com.fivew14.nomoonpatch.mixin;

import com.fivew14.nomoonpatch.Nomoonpatch;
import net.mcreator.nomoon.procedures.EntityTickProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;
import java.util.function.Predicate;

@Mixin(EntityTickProcedure.class)
public class EntityTickProcedureMixin {
    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;getEntitiesOfClass(Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;"), method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V")
    private static <T extends Entity> List<T> removeLookupEveryTick(LevelAccessor instance, Class<T> aClass, AABB aabb, Predicate<T> predicate) {
        if (Nomoonpatch.entityMixinSkipExpensiveCalls)
            return List.of();

        return instance.getEntitiesOfClass(aClass, aabb, predicate);
    }
}
