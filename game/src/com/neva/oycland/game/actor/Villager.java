package com.neva.oycland.game.actor;

import com.neva.oycland.core.control.Controller;
import com.neva.oycland.game.Progress;

import java.util.List;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Villager extends AbstractActor {

    private static final float FLAME_KILL_RATIO = 0.25f;

    private static final VillagerFactory FACTORY = new VillagerFactory();

    public Villager(Progress progress, Controller controller) {
        super(progress, controller, FACTORY);

        this.moveSpeed = 150f;
        this.resize(0.5f);
    }

    @Override
    public void act(float delta) {
        for (AbstractActor actor : getColliding()) {
            if (actor instanceof Ghost) {
                progress.endGame();
            } else if (actor instanceof Flame) {
                progress.increaseScore(500);

                killGhosts();
            }
        }

        super.act(delta);
    }

    private void killGhosts() {
        List<Ghost> all = getNearestActorsOfType(Ghost.class);
        int ghostToKill = Math.round(FLAME_KILL_RATIO * all.size());
        List<Ghost> killed = all.subList(0, Math.min(all.size(), ghostToKill));

        for (Ghost ghost : killed) {
            ghost.addAction(sequence(fadeOut(0.5f), removeActor()));
        }
    }

}
