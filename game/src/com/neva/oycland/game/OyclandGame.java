package com.neva.oycland.game;

import com.badlogic.gdx.Screen;
import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.game.screen.LevelScreen;
import com.neva.oycland.game.ui.UiInput;

public class OyclandGame extends AbstractGame {

    protected Progress progress;

    @Override
    public void init() {
        input.addProcessor(new UiInput(this));

        progress = new Progress(this);
        progress.startGame();
    }

    @Override
    public void setScreen(Screen screen) {
        if (screen instanceof LevelScreen) {
            progress.setCurrentLevel((LevelScreen) screen);
        }

        super.setScreen(screen);
    }

    public Progress getProgress() {
        return progress;
    }
}
