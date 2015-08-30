package com.neva.oycland.game.actor;

import com.neva.oycland.core.control.player.AiRandom;
import com.neva.oycland.core.gfx.AnimatedImage;

public class Ghost extends AnimatedImage {

    private static final GhostFactory FACTORY = new GhostFactory();

    public Ghost() {
        super(FACTORY, new AiRandom());

        this.moveSpeed = 50f;

        resize(0.2f);
    }
}
