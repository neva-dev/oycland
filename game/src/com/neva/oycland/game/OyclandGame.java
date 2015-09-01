package com.neva.oycland.game;

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

    public void start(Class<? extends LevelScreen> levelClass) {
        screens.unload(levelClass);
        LevelScreen level = (LevelScreen) screens.load(this, levelClass);
        progress.changeLevel(level);

        super.setScreen(level);
    }

    public Progress getProgress() {
        return progress;
    }
}
