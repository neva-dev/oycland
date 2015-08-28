package com.neva.oycland.core.control;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.neva.oycland.core.control.screen.AbstractScreen;
import com.neva.oycland.core.control.screen.ScreenManager;
import com.neva.oycland.core.gfx.GfxContext;

public abstract class AbstractGame extends Game {

    protected GfxContext gfx;

    protected ScreenManager screens;

    protected AssetManager assets;

    protected InputMultiplexer input;

    public abstract void init();

    @Override
    public void create() {
        this.gfx = new GfxContext();
        this.screens = new ScreenManager();
        this.assets = new AssetManager();
        this.input = new InputMultiplexer();

        init();
        setScreen(screens.getFirst());

        Gdx.input.setInputProcessor(input);
    }

    @Override
    public void render() {
        gl();

        super.render();
    }

    protected void gl() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }

    public GfxContext getGfx() {
        return gfx;
    }

    public ScreenManager getScreens() {
        return screens;
    }

    public AssetManager getAssets() {
        return assets;
    }

    public void setScreen(String name) {
        AbstractScreen screen = screens.byName(name);
        Gdx.app.debug(getClass().getSimpleName(), String.format("Setting game screen: '%s'", name));
        setScreen(screen);
    }

    public InputMultiplexer getInput() {
        return input;
    }
}
