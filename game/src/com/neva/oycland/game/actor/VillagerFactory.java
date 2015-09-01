package com.neva.oycland.game.actor;

import com.neva.oycland.core.gfx.animation.AbstractMoveFactory;
import com.neva.oycland.core.gfx.animation.MoveTextureRegionSettings;

public class VillagerFactory extends AbstractMoveFactory {

    private static final MoveTextureRegionSettings REGION_SETTINGS;

    static {
        REGION_SETTINGS = new MoveTextureRegionSettings();
        REGION_SETTINGS.assetPath = "images/villager.png";
        REGION_SETTINGS.frameCols = 13;
        REGION_SETTINGS.frameRows = 8;
        REGION_SETTINGS.standRow = 0;
        REGION_SETTINGS.standCol = 4;
        REGION_SETTINGS.moveDown = 0;
        REGION_SETTINGS.moveDownLeft = 1;
        REGION_SETTINGS.moveDownRight = 2;
        REGION_SETTINGS.moveLeft = 3;
        REGION_SETTINGS.moveUp = 4;
        REGION_SETTINGS.moveUpLeft = 5;
        REGION_SETTINGS.moveUpRight = 6;
        REGION_SETTINGS.moveRight = 7;
    }

    public VillagerFactory() {
        super(REGION_SETTINGS);
    }
}
