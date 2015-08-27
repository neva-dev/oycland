package com.neva.oycland.gfx;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GfxContext {

    private SpriteBatch batch = new SpriteBatch();

    private BitmapFont font = new BitmapFont();

    public SpriteBatch getBatch() {
        return batch;
    }

    public BitmapFont getFont() {
        return font;
    }
}
