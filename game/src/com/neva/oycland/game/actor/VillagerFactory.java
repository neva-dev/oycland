package com.neva.oycland.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.neva.oycland.core.gfx.AnimatedMoveFactory;

public class VillagerFactory implements AnimatedMoveFactory {

    private static final String ASSET_PATH = "images/villager.png";

    private static final int FRAME_COLS = 13;

    private static final int FRAME_ROWS = 8;

    private static final int STAND_ROW = 0;

    private static final int STAND_COL = 4;

    private static final int MOVE_DOWN = 0;

    private static final int MOVE_DOWN_LEFT = 1;

    private static final int MOVE_DOWN_RIGHT = 2;

    private static final int MOVE_LEFT = 3;

    private static final int MOVE_UP = 4;

    private static final int MOVE_UP_LEFT = 5;

    private static final int MOVE_UP_RIGHT = 6;

    private static final int MOVE_RIGHT = 7;

    private static final float ANIMATION_FRAME_DELAY = 0.05f;

    private TextureRegion[][] regions;

    public VillagerFactory() {
        Texture texture = new Texture(Gdx.files.internal(ASSET_PATH));

        this.regions = TextureRegion.split(texture, texture.getWidth() / FRAME_COLS, texture.getHeight() / FRAME_ROWS);
    }

    public Animation getMoveRight() {
        return  new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_RIGHT]);
    }

    public Animation getMoveLeft() {
        return new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_LEFT]);
    }

    public Animation getMoveUp() {
        return new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_UP]);
    }

    public Animation getMoveDown() {
        return new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_DOWN]);
    }

    public Animation getStand() {
        return new Animation(ANIMATION_FRAME_DELAY, regions[STAND_ROW][STAND_COL]);
    }

    public Animation getMoveUpLeft() {
        return new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_UP_LEFT]);
    }

    public Animation getMoveUpRight() {
        return new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_UP_RIGHT]);
    }

    public Animation getMoveDownLeft() {
        return new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_DOWN_LEFT]);
    }

    public Animation getMoveDownRight() {
        return new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_DOWN_RIGHT]);
    }
}
