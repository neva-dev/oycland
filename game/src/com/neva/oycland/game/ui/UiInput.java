package com.neva.oycland.game.ui;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.neva.oycland.game.OyclandGame;

public class UiInput extends InputAdapter {

    private final OyclandGame game;

    public UiInput(OyclandGame game) {
        this.game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                game.getProgress().togglePause();
                break;
            default:
                return false;
        }

        return true;
    }
}
