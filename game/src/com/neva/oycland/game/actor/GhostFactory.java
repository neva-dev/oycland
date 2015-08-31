package com.neva.oycland.game.actor;

import com.neva.oycland.core.gfx.AbstractAnimationFactory;

public class GhostFactory extends AbstractAnimationFactory {

    private static final RegionSettings REGION_SETTINGS;

    static {
        REGION_SETTINGS = new RegionSettings();
        REGION_SETTINGS.assetPath = "images/ghost.png";
        REGION_SETTINGS.frameCols = 6;
        REGION_SETTINGS.frameRows = 8;
        REGION_SETTINGS.standRow = 0;
        REGION_SETTINGS.standCol = 0;
        REGION_SETTINGS.moveDown = 0;
        REGION_SETTINGS.moveDownLeft = 1;
        REGION_SETTINGS.moveLeft = 2;
        REGION_SETTINGS.moveDownRight = 6;
        REGION_SETTINGS.moveUp = 4;
        REGION_SETTINGS.moveUpLeft = 3;
        REGION_SETTINGS.moveUpRight = 5;
        REGION_SETTINGS.moveRight = 7;
    }

    public GhostFactory() {
        super(REGION_SETTINGS);
    }
}
