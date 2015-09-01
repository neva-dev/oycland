package com.neva.oycland.core.gfx.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AbstractMoveFactory implements AnimatedMoveFactory {

    private final MoveTextureRegionSettings settings;

    private TextureRegion[][] regions;

    public AbstractMoveFactory(MoveTextureRegionSettings settings) {
        this.settings = settings;

        Texture texture = new Texture(Gdx.files.internal(settings.assetPath));
        this.regions = TextureRegion.split(texture, texture.getWidth() / settings.frameCols, texture.getHeight() / settings.frameRows);
    }

    @Override
    public Animation getAnimation() {
        return getStand();
    }

    public Animation getMoveRight() {
        return new Animation(settings.animationFrameDelay, regions[settings.moveRight]);
    }

    public Animation getMoveLeft() {
        return new Animation(settings.animationFrameDelay, regions[settings.moveLeft]);
    }

    public Animation getMoveUp() {
        return new Animation(settings.animationFrameDelay, regions[settings.moveUp]);
    }

    public Animation getMoveDown() {
        return new Animation(settings.animationFrameDelay, regions[settings.moveDown]);
    }

    public Animation getStand() {
        return new Animation(settings.animationFrameDelay, regions[settings.standRow][settings.standCol]);
    }

    public Animation getMoveUpLeft() {
        return new Animation(settings.animationFrameDelay, regions[settings.moveUpLeft]);
    }

    public Animation getMoveUpRight() {
        return new Animation(settings.animationFrameDelay, regions[settings.moveUpRight]);
    }

    public Animation getMoveDownLeft() {
        return new Animation(settings.animationFrameDelay, regions[settings.moveDownLeft]);
    }

    public Animation getMoveDownRight() {
        return new Animation(settings.animationFrameDelay, regions[settings.moveDownRight]);
    }


}
