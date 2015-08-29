package com.neva.oycland.core.gfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AbstractAnimatedMoveFactory implements AnimatedMoveFactory {

    private final RegionSettings settings;

    private TextureRegion[][] regions;

    public AbstractAnimatedMoveFactory(RegionSettings settings) {
        this.settings = settings;

        Texture texture = new Texture(Gdx.files.internal(settings.assetPath));
        this.regions = TextureRegion.split(texture, texture.getWidth() / settings.frameCols, texture.getHeight() / settings.frameRows);
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

    public static class RegionSettings {

        public String assetPath;

        public int frameCols;

        public int frameRows;

        public int standRow;

        public int standCol;

        public int moveDown;

        public int moveDownLeft;

        public int moveLeft;

        public int moveDownRight;

        public int moveUp;

        public int moveUpLeft;

        public int moveUpRight;

        public int moveRight;

        public float animationFrameDelay = 0.05f;

    }
}
