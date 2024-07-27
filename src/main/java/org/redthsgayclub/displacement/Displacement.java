package org.redthsgayclub.displacement;

import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.events.event.Stage;
import cc.polyfrost.oneconfig.events.event.TickEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Vec3;
import org.redthsgayclub.displacement.config.Config;
import cc.polyfrost.oneconfig.events.event.InitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * The entrypoint of the Example Mod that initializes it.
 *
 * @see Mod
 * @see InitializationEvent
 */
@Mod(modid = Displacement.MODID, name = Displacement.NAME, version = Displacement.VERSION)
public class Displacement {

    // Sets the variables from `gradle.properties`. See the `blossom` config in `build.gradle.kts`.
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Mod.Instance(MODID)
    public static Displacement INSTANCE; // Adds the instance of the mod, so we can access other variables.
    public static Config config;
    public static List<Vec3> trailList = new ArrayList<>();
    public static boolean isRecording = false;
    public static int tickCount = 0;

    // Register the config and commands.
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        EventManager.INSTANCE.register(this);
        config = new Config();
    }

    @Subscribe
    public void onTick(TickEvent event) {
        if (event.stage == Stage.START) return;
        if (!isRecording) return;
        trailList.add(Minecraft.getMinecraft().thePlayer.getPositionVector());

    }


}
