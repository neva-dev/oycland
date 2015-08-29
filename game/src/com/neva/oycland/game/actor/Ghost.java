package com.neva.oycland.game.actor;

import com.neva.oycland.core.gfx.AnimatedImage;

public class Ghost extends AnimatedImage {

    private static final GhostFactory FACTORY = new GhostFactory();

    public Ghost() {
        super(FACTORY.getStand());

    }

}
