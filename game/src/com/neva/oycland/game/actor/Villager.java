package com.neva.oycland.game.actor;

import com.neva.oycland.core.control.Player2Axis;
import com.neva.oycland.core.gfx.AnimatedImage;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

public class Villager extends AnimatedImage implements Player2Axis {

    private static final VilagerFactory FACTORY = new VilagerFactory();

    public Villager() {
        super(FACTORY.getStand());
    }

    public void moveLeft() {
        setAnimation(FACTORY.getMoveLeft());
        addAction(moveTo(getX() - 10, getY(), 1f));
    }

    public void moveRight() {
        setAnimation(FACTORY.getMoveRight());
        addAction(moveTo(getX() + 10, getY(), 1f));
    }

    public void moveUp() {
        setAnimation(FACTORY.getMoveUp());
        addAction(moveTo(getX(), getY() - 10, 1f));
    }

    public void moveDown() {
        setAnimation(FACTORY.getMoveDown());
        addAction(moveTo(getX(), getY() + 10, 1f));
    }
}
