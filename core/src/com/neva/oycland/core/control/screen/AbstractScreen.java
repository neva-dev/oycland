package com.neva.oycland.core.control.screen;

import com.badlogic.gdx.ScreenAdapter;
import com.neva.oycland.core.control.AbstractGame;

public abstract class AbstractScreen extends ScreenAdapter {

    public AbstractGame game;

    public AbstractScreen(AbstractGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
    }
}
