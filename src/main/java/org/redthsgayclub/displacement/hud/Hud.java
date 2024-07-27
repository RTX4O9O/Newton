package org.redthsgayclub.displacement.hud;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import net.minecraft.client.Minecraft;
import org.redthsgayclub.displacement.Displacement;
import org.redthsgayclub.displacement.config.Config;

/**
 * An example OneConfig HUD that is started in the config and displays text.
 *
 * @see Config#hud
 */
public class Hud extends SingleTextHud {
    /*public Hud() {
        super("位移", true);
    }

    @Override
    public String getText(boolean example) {
        if (Displacement.pos == null) {
            return "null";
        }
        return String.valueOf(Displacement.pos.distanceTo(Minecraft.getMinecraft().thePlayer.getPositionVector()));
    }*/

    public Hud() {
        super("Recording", true);
    }

    @Override
    public String getText(boolean example) {
        return Displacement.isRecording ? "Yes " + Displacement.trailList.size() : "No " + 0;
    }
}
