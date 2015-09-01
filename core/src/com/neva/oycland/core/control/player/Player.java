package com.neva.oycland.core.control.player;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.neva.oycland.core.control.Command;
import com.neva.oycland.core.control.Controller;

public class Player extends InputAdapter implements Controller {

    private final PlayerKeys activeKeys = new PlayerKeys();

    @Override
    public boolean keyDown(int keycode) {
        activeKeys.put(keycode, true);

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        activeKeys.put(keycode, false);

        return true;
    }

    public PlayerKeys getActiveKeys() {
        return activeKeys;
    }

    @Override
    public Command control(float delta) {
        Command command = Command.IDLE;

        if (activeKeys.isPressed(Input.Keys.UP) && activeKeys.isPressed(Input.Keys.LEFT)) {
            command = Command.MOVE_UP_LEFT;
        } else if (activeKeys.isPressed(Input.Keys.UP) && activeKeys.isPressed(Input.Keys.RIGHT)) {
            command = Command.MOVE_UP_RIGHT;
        } else if (activeKeys.isPressed(Input.Keys.DOWN) && activeKeys.isPressed(Input.Keys.LEFT)) {
            command = Command.MOVE_DOWN_LEFT;
        } else if (activeKeys.isPressed(Input.Keys.DOWN) && activeKeys.isPressed(Input.Keys.RIGHT)) {
            command = Command.MOVE_DOWN_RIGHT;
        } else if (activeKeys.isPressed(Input.Keys.LEFT)) {
            command = Command.MOVE_LEFT;
        } else if (activeKeys.isPressed(Input.Keys.RIGHT)) {
            command = Command.MOVE_RIGHT;
        } else if (activeKeys.isPressed(Input.Keys.DOWN)) {
            command = Command.MOVE_DOWN;
        } else if (activeKeys.isPressed(Input.Keys.UP)) {
            command = Command.MOVE_UP;
        }

        return command;
    }
}
