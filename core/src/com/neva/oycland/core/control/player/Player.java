package com.neva.oycland.core.control.player;

import com.badlogic.gdx.InputAdapter;

public class Player extends InputAdapter {

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
}
