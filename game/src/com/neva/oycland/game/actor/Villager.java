package com.neva.oycland.game.actor;

import com.neva.oycland.core.gfx.AnimatedImage;
import com.neva.oycland.core.gfx.AnimatedImageController;

public class Villager extends AnimatedImage {

    private static final float MOVE_SPEED = 150f;

    private static final VillagerFactory FACTORY = new VillagerFactory();

    private final AnimatedImageController imageController;

    public Villager() {
        super(FACTORY.getStand());

        this.imageController = new AnimatedImageController(this, FACTORY, MOVE_SPEED);
    }

    public AnimatedImageController getController() {
        return imageController;
    }
}
