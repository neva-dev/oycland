package com.neva.oycland.core.control;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.google.common.collect.Maps;

import java.util.Map;

public class Player extends InputAdapter {

    private final Map<Integer, Boolean> activeKeys = Maps.newHashMap();

    public Player() {
        activeKeys.put(Input.Keys.LEFT, false);
        activeKeys.put(Input.Keys.RIGHT, false);
        activeKeys.put(Input.Keys.UP, false);
        activeKeys.put(Input.Keys.DOWN, false);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (!activeKeys.containsKey(keycode)) {
            return false;
        }

        activeKeys.put(keycode, true);

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (!activeKeys.containsKey(keycode)) {
            return false;
        }

        activeKeys.put(keycode, false);

        return true;
    }

    public Map<Integer, Boolean> getActiveKeys() {
        return activeKeys;
    }
}
