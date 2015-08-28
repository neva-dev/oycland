package com.neva.oycland.game.actor;

import com.neva.oycland.core.control.Player2Axis;
import com.neva.oycland.core.gfx.AnimatedImage;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

public class Villager extends AnimatedImage implements Player2Axis {

    private static final int MOVE_DISTANCE = 100;

    private static final float MOVE_DURATION = 1f;

    private static final VilagerFactory FACTORY = new VilagerFactory();

    public Villager() {
        super(FACTORY.getMoveDown());
    }

    public void moveLeft() {
        setAnimation(FACTORY.getMoveLeft());
        addAction(moveTo(getX() - MOVE_DISTANCE, getY(), MOVE_DURATION));
    }

    public void moveRight() {
        setAnimation(FACTORY.getMoveRight());
        addAction(moveTo(getX() + MOVE_DISTANCE, getY(), MOVE_DURATION));
    }

    public void moveUp() {
        setAnimation(FACTORY.getMoveUp());
        addAction(moveTo(getX(), getY() + MOVE_DISTANCE, MOVE_DURATION));
    }

    public void moveDown() {
        setAnimation(FACTORY.getMoveDown());
        addAction(moveTo(getX(), getY() - MOVE_DISTANCE, MOVE_DURATION));
    }
}
