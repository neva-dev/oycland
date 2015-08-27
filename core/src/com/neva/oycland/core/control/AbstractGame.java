package com.neva.oycland.core.control;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.neva.oycland.core.control.screen.AbstractScreen;
import com.neva.oycland.core.control.screen.ScreenManager;
import com.neva.oycland.core.gfx.GfxContext;

public abstract class AbstractGame extends Game {

    protected GfxContext gfx;

    protected ScreenManager screenMgr;

    public abstract AbstractScreen getStartupScreen();

    @Override
    public void create() {
        this.gfx = new GfxContext();
        this.screenMgr = new ScreenManager();

        setScreen(getStartupScreen());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        super.render();
    }

    public GfxContext getGfxContext() {
        return gfx;
    }

    public ScreenManager getScreenMgr() {
        return screenMgr;
    }
}
