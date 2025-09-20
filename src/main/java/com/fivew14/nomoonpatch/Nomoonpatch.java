package com.fivew14.nomoonpatch;

import net.minecraft.util.RandomSource;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Nomoonpatch.MODID)
public class Nomoonpatch {
    public static final String MODID = "no_moon_network_patch";
    public Nomoonpatch(IEventBus modEventBus, ModContainer modContainer) {
        RANDOM = RandomSource.create();
    }

    public static final float PACKET_DROP_CHANCE = 7f/8f;
    private static RandomSource RANDOM;

    public static boolean shouldDropPacket() {
        // Don't laugh. Nevermind, do laugh. :)
        return RANDOM.nextFloat() < PACKET_DROP_CHANCE;
    }
}
