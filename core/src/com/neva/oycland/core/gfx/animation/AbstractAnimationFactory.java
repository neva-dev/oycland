package com.neva.oycland.core.gfx.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.neva.oycland.core.gfx.GfxUtils;
import com.neva.oycland.core.gfx.TextureRegionSettings;

public class AbstractAnimationFactory implements AnimationFactory {

    private final TextureRegionSettings settings;

    private TextureRegion[] frames;

    public AbstractAnimationFactory(TextureRegionSettings settings) {
        this.settings = settings;

        Texture texture = new Texture(Gdx.files.internal(settings.assetPath));
        TextureRegion[][] regions = TextureRegion.split(texture, texture.getWidth() / settings.frameCols, texture.getHeight() / settings.frameRows);

        frames = GfxUtils.flattenRegions(settings, regions);
    }

    @Override
    public Animation getAnimation() {
        return new Animation(settings.animationFrameDelay, frames);
    }

}
