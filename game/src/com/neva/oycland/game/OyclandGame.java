package com.neva.oycland.game;

import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.core.control.screen.AbstractScreen;
import com.neva.oycland.core.control.screen.ScreenFactory;
import com.neva.oycland.game.screen.MainMenuScreen;
import com.neva.oycland.game.screen.TutorialScreen;

public class OyclandGame extends AbstractGame {

    @Override
    public void init() {
        setScreen(MainMenuScreen.class, false);
    }

}
