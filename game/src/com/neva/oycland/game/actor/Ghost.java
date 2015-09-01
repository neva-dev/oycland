package com.neva.oycland.game.actor;

import com.neva.oycland.core.control.player.AiRandom;
import com.neva.oycland.game.Progress;

public class Ghost extends AbstractActor {

    private static final GhostFactory FACTORY = new GhostFactory();

    public Ghost(Progress progress) {
        super(progress, new AiRandom(), FACTORY);

        this.moveSpeed = 50f;
        this.resize(0.2f);
    }
}
