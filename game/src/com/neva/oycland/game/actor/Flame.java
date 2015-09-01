package com.neva.oycland.game.actor;

import com.neva.oycland.game.Progress;

public class Flame extends AbstractActor {

    private static final FlameFactory FACTORY = new FlameFactory();

    public Flame(Progress progress) {
        super(progress, FACTORY);

        this.moveSpeed = 50f;
        this.resize(0.2f);
    }
}
