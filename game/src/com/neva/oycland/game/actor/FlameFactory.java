package com.neva.oycland.game.actor;

import com.neva.oycland.core.gfx.TextureRegionSettings;
import com.neva.oycland.core.gfx.animation.AbstractAnimationFactory;

public class FlameFactory extends AbstractAnimationFactory {

    private static final TextureRegionSettings REGION_SETTINGS;

    static {
        REGION_SETTINGS = new TextureRegionSettings();
        REGION_SETTINGS.assetPath = "images/flame.png";
        REGION_SETTINGS.frameCols = 4;
        REGION_SETTINGS.frameRows = 4;
    }

    public FlameFactory() {
        super(REGION_SETTINGS);
    }

}
