package com.neva.oycland.core.gfx;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GfxContext {

    private SpriteBatch spriteBatch = new SpriteBatch();

    private BitmapFont font = new BitmapFont();

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public BitmapFont getFont() {
        return font;
    }
}
