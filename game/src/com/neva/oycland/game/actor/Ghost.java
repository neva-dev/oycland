package com.neva.oycland.game.actor;

import com.neva.oycland.core.control.player.Ai;
import com.neva.oycland.core.gfx.AnimatedImage;
import com.neva.oycland.core.gfx.AnimatedImageController;

public class Ghost extends AnimatedImage {

    private static final float MOVE_SPEED = 100f;

    private static final GhostFactory FACTORY = new GhostFactory();

    private final AnimatedImageController controller;

    public Ghost() {
        super(FACTORY.getStand());

        this.controller = new AnimatedImageController(new Ai(), this, FACTORY, MOVE_SPEED);
    }

    public AnimatedImageController getController() {
        return controller;
    }
}
