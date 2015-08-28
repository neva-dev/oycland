package com.neva.oycland.game.actor;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.neva.oycland.core.control.Player2Axis;
import com.neva.oycland.core.gfx.AnimatedImage;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Villager extends AnimatedImage implements Player2Axis {

    private static final int MOVE_DISTANCE = 100;

    private static final float MOVE_DURATION = 1f;

    private static final VilagerFactory FACTORY = new VilagerFactory();

    private final Stage stage;

    public Villager(Stage stage) {
        super(FACTORY.getStand());

        this.stage = stage;
    }

    public void moveLeft() {
        setAnimation(FACTORY.getMoveLeft());
        moveAndStand(moveTo(Math.max(0, getX() - MOVE_DISTANCE), getY(), MOVE_DURATION));
    }

    public void moveRight() {
        setAnimation(FACTORY.getMoveRight());
        moveAndStand(moveTo(Math.min(stage.getWidth() - getWidth(), getX() + MOVE_DISTANCE), getY(), MOVE_DURATION));
    }

    public void moveUp() {
        setAnimation(FACTORY.getMoveUp());
        moveAndStand(moveTo(getX(), Math.min(stage.getHeight() - getHeight(), getY() + MOVE_DISTANCE), MOVE_DURATION));
    }

    public void moveDown() {
        setAnimation(FACTORY.getMoveDown());
        moveAndStand(moveTo(getX(), Math.max(0, getY() - MOVE_DISTANCE), MOVE_DURATION));
    }

    private void moveAndStand(MoveToAction move) {
        addAction(sequence(move, run(new Runnable() {
            @Override
            public void run() {
                setAnimation(FACTORY.getStand());
            }
        })));
    }
}
