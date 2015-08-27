package com.neva.oycland.core.control.screen;

import com.badlogic.gdx.Screen;
import com.neva.oycland.core.control.AbstractGame;

public class AbstractScreen implements Screen {

    public AbstractGame game;

    public AbstractScreen(AbstractGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        // nothing to do
    }

    @Override
    public void render(float delta) {
        // nothing to do
    }

    @Override
    public void resize(int width, int height) {
        // nothing to do
    }

    @Override
    public void pause() {
        // nothing to do
    }

    @Override
    public void resume() {
        // nothing to do
    }

    @Override
    public void hide() {
        // nothing to do
    }

    @Override
    public void dispose() {
        // nothing to do
    }
}
