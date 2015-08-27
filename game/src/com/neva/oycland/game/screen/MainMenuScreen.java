package com.neva.oycland.game.screen;

import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.core.control.screen.AbstractScreen;

public class MainMenuScreen extends AbstractScreen {

    public static String NAME = "Main menu";

    public MainMenuScreen(AbstractGame game) {
        super(game);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void show() {
        // TODO initialize GUI
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        // TODO render GUI
    }
}


