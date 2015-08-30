package com.neva.oycland.game.ui;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.neva.oycland.game.OyclandGame;
import com.neva.oycland.game.screen.LevelScreen;
import com.neva.oycland.game.screen.PauseScreen;

public class UiInput extends InputAdapter {

    private final OyclandGame game;

    public UiInput(OyclandGame game) {
        this.game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                if (game.getScreen() instanceof LevelScreen) {
                    game.getProgress().setCurrentLevel((LevelScreen) game.getScreen());
                    game.setScreen(PauseScreen.class);
                } else if (game.getProgress().getCurrentLevel() != null) {
                    game.setScreen(game.getProgress().getCurrentLevel());
                }
                break;
            default:
                return false;
        }

        return true;
    }
}
