package com.neva.oycland.game.actor;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.neva.oycland.core.control.Controller;
import com.neva.oycland.game.Progress;

public class Villager extends AbstractActor {

    private static final VillagerFactory FACTORY = new VillagerFactory();

    public Villager(Progress progress, Controller controller) {
        super(progress, controller, FACTORY);

        this.moveSpeed = 150f;
        this.resize(0.5f);
    }

    @Override
    public void act(float delta) {
        for (Actor actor : getStage().getActors()) {
            if (actor instanceof Ghost) {
                Ghost ghost = (Ghost) actor;

                if (isColliding(ghost)) {
                    progress.endGame();
                }
            }
        }

        super.act(delta);
    }
}
