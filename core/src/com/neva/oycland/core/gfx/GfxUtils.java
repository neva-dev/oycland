package com.neva.oycland.core.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public final class GfxUtils {

    public static SpriteDrawable asSprite(Texture texture) {
        return new SpriteDrawable(new Sprite(texture));
    }

    public static SpriteDrawable loadSprite(String path) {
        return asSprite(new Texture(Gdx.files.internal(path)));
    }
}
