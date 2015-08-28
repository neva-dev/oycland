package com.neva.oycland.core.control;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends InputAdapter {

    private final Actor actor;

    public Player(Actor actor) {
        this.actor = actor;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (actor instanceof Player2Axis) {
            return handle2axis(keycode);
        }

        return false;
    }

    private boolean handle2axis(int keycode) {
        Player2Axis player2Axis = (Player2Axis) this.actor;

        switch (keycode) {
            case Input.Keys.LEFT:
                player2Axis.moveLeft();
                break;
            case Input.Keys.RIGHT:
                player2Axis.moveRight();
                break;
            case Input.Keys.UP:
                player2Axis.moveUp();
                break;
            case Input.Keys.DOWN:
                player2Axis.moveDown();
                break;
        }

        return true;
    }

    public Actor getActor() {
        return actor;
    }
}
