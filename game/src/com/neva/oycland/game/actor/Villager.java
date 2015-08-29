package com.neva.oycland.game.actor;

import com.neva.oycland.core.control.Controller;
import com.neva.oycland.core.gfx.AnimatedImage;

public class Villager extends AnimatedImage {

    private static final VillagerFactory FACTORY = new VillagerFactory();

    public Villager(Controller controller) {
        super(FACTORY, controller);

        this.moveSpeed = 150f;
    }
}
