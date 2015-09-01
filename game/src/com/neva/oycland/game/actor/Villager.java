package com.neva.oycland.game.actor;

import com.neva.oycland.core.control.Controller;
import com.neva.oycland.core.gfx.ActorUtils;
import com.neva.oycland.game.Progress;

import java.util.List;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Villager extends AbstractActor {

    private static final float FLAME_KILL_RATIO = 0.1f;

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
                final Flame flame = (Flame) actor;
                if (flame.activate()) {
                    progress.increaseScore(50);
                    killGhostsAndRemoveFlame(flame);
                }
            }
        }

        super.act(delta);
    }

    protected void killGhostsAndRemoveFlame(Flame flame) {
        final List<Ghost> all = ActorUtils.nearestTo(this, getStage().getActors(), Ghost.class);
        final int toKill = Math.round(FLAME_KILL_RATIO * all.size());
        final List<Ghost> killed = all.subList(0, Math.min(all.size(), toKill));

        for (Ghost ghost : killed) {
            ghost.addAction(sequence(fadeOut(0.5f), removeActor()));
        }

        flame.addAction(sequence(fadeOut(1.5f), removeActor()));
    }

}
