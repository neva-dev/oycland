package com.neva.oycland.core.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public final class GfxUtils {

    public static SpriteDrawable loadDrawableSprite(String path) {
        return new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal(path))));
    }

}
