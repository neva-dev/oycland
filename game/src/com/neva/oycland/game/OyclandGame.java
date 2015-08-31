package com.neva.oycland.game;

import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.game.screen.MainMenuScreen;
import com.neva.oycland.game.ui.UiInput;

public class OyclandGame extends AbstractGame {

    protected Progress progress;

    @Override
    public void init() {
        progress = new Progress(this);
        input.addProcessor(new UiInput(this));

        setScreen(MainMenuScreen.class);
    }

    public Progress getProgress() {
        return progress;
    }
}
