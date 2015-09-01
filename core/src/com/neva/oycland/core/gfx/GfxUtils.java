package com.neva.oycland.core.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public final class GfxUtils {

    public static SpriteDrawable asSprite(Texture texture) {
        return new SpriteDrawable(new Sprite(texture));
    }

    public static SpriteDrawable loadSprite(String path) {
        return asSprite(new Texture(Gdx.files.internal(path)));
    }

    public static TextureRegion[] flattenRegions(TextureRegionSettings settings, TextureRegion[][] regions) {
        int k = 0;
        TextureRegion[] frames = new TextureRegion[settings.frameCols * settings.frameRows];
        for (int i = 0; i < settings.frameRows; i++) {
            for (int j = 0; j < settings.frameCols; j++) {
                frames[k] = regions[i][j];
                k++;
            }
        }

        return frames;
    }
}
