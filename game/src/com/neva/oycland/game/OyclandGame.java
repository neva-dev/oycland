package com.neva.oycland.game;

import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.game.screen.MainMenuScreen;

public class OyclandGame extends AbstractGame {

    private Progress progress;

    @Override
    public void init() {
        progress = new Progress();
        input.addProcessor(new UserInterface(this));

        setScreen(MainMenuScreen.class);
    }

    public Progress getProgress() {
        return progress;
    }
}
