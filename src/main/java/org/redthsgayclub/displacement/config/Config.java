package org.redthsgayclub.displacement.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.core.OneKeyBind;
import net.minecraft.util.Vec3;
import org.redthsgayclub.displacement.Displacement;
import org.redthsgayclub.displacement.FileUtil;
import org.redthsgayclub.displacement.hud.Hud;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;


/**
 * The main Config entrypoint that extends the Config type and inits the config options.
 * See <a href="https://docs.polyfrost.cc/oneconfig/config/adding-options">this link</a> for more config Options
 */
public class Config extends cc.polyfrost.oneconfig.config.Config {
/*    @HUD(
            name = "位移HUD"
    )
    public Hud hud = new Hud();*/
    @HUD(
            name = "Record HUD"
    )
    public Hud hud = new Hud();

    @KeyBind(
            name = "Start Recording"
    )
    public OneKeyBind keyBind = new OneKeyBind();

    public Config() {
        super(new Mod(Displacement.NAME, ModType.UTIL_QOL), Displacement.MODID + ".json");
        initialize();
        registerKeyBind(keyBind, () -> {
            if (enabled) {
                Displacement.isRecording = !Displacement.isRecording;
                if (Displacement.isRecording) {
                    Displacement.trailList.clear();



                    FileUtil.writeToFile(FileUtil.getTime(), true);
                } else {

                /*StringBuilder sb = new StringBuilder();
                sb.append("```");
                Displacement.trailMap.forEach((k, v) -> {
                    sb.append(k).append(": ").append(v).append("\n");
                });
                sb.append("```");
                System.out.println(sb.toString());
                DiscordWebhook.sendWebhookMessage(sb.toString());*/

                /*System.out.println(Displacement.trailMap.toString());
                DiscordWebhook.sendWebhookMessage(Displacement.trailMap.toString());*/

                    double xMax = 0;
                    double yMax = 0;
                    double zMax = 0;
                    double xMin = 0;
                    double yMin = 0;
                    double zMin = 0;

                    for (Vec3 vec3 : Displacement.trailList) {
                        if (vec3.xCoord > xMax) xMax = vec3.xCoord;
                        if (vec3.yCoord > yMax) yMax = vec3.yCoord;
                        if (vec3.zCoord > zMax) zMax = vec3.zCoord;
                        if (vec3.xCoord < xMin) xMin = vec3.xCoord;
                        if (vec3.yCoord < yMin) yMin = vec3.yCoord;
                        if (vec3.zCoord < zMin) zMin = vec3.zCoord;

                        FileUtil.writeToFile(vec3.toString(), false);
                    }
                    FileUtil.writeToFile("Max X: " + xMax + " Max Y: " + yMax + " Max Z: " + zMax, false);


                }
            }

        });
    }
}

