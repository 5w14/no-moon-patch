package com.fivew14.nomoonpatch;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;

@Mod(Nomoonpatch.MODID)
@Mod.EventBusSubscriber
public class Nomoonpatch {
    public static final String MODID = "no_moon_network_patch";
    public Nomoonpatch(FMLJavaModLoadingContext context) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static boolean mapSynced = false;
    public static ConcurrentSkipListSet<UUID> playerSynced = new ConcurrentSkipListSet<>();
    public static ConcurrentSkipListSet<ResourceLocation> dimensionSynced = new ConcurrentSkipListSet<>();

    @SubscribeEvent
    public void onTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.type != TickEvent.Type.SERVER) {
            return;
        }

        mapSynced = false;
        playerSynced.clear();
        dimensionSynced.clear();
    }
}
