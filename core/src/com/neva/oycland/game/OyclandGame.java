package com.neva.oycland.game;

import com.neva.oycland.control.AbstractGame;
import com.neva.oycland.control.screen.AbstractScreen;
import com.neva.oycland.game.screen.MainMenuScreen;

public class OyclandGame extends AbstractGame {

    public AbstractScreen getStartupScreen() {
        return new MainMenuScreen(this);
    }
}
