package com.neva.oycland.game.actor;

import com.neva.oycland.core.control.player.Controller;
import com.neva.oycland.core.gfx.AnimatedImage;
import com.neva.oycland.core.gfx.AnimatedImageController;

public class Villager extends AnimatedImage {

    private static final float MOVE_SPEED = 150f;

    private static final VillagerFactory FACTORY = new VillagerFactory();

    private final AnimatedImageController controller;

    public Villager(Controller controller) {
        super(FACTORY.getStand());

        this.controller = new AnimatedImageController(controller, this, FACTORY, MOVE_SPEED);
    }

    public AnimatedImageController getController() {
        return controller;
    }
}
