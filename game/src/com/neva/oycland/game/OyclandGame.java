package com.neva.oycland.game;

import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.game.screen.MainMenuScreen;
import com.neva.oycland.game.screen.TutorialScreen;

public class OyclandGame extends AbstractGame {

    @Override
    public void init() {
        screens.register(new TutorialScreen(this));
        screens.register(new MainMenuScreen(this));
    }
}
