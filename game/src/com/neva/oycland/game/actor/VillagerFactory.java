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

    private final Animation moveRight;

    private final Animation moveLeft;

    private final Animation moveUp;

    private final Animation moveDown;

    private final Animation stand;

    private final Animation moveUpLeft;

    private final Animation moveUpRight;

    private final Animation moveDownLeft;

    private final Animation moveDownRight;

    public VillagerFactory() {
        Texture texture = new Texture(Gdx.files.internal(ASSET_PATH));
        TextureRegion[][] regions = TextureRegion.split(texture, texture.getWidth() / FRAME_COLS, texture.getHeight() / FRAME_ROWS);

        this.stand = new Animation(ANIMATION_FRAME_DELAY, regions[STAND_ROW][STAND_COL]);

        this.moveUpLeft = new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_UP_LEFT]);
        this.moveUpRight = new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_UP_RIGHT]);
        this.moveDownLeft = new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_DOWN_LEFT]);
        this.moveDownRight = new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_DOWN_RIGHT]);

        this.moveLeft = new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_LEFT]);
        this.moveRight = new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_RIGHT]);
        this.moveUp = new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_UP]);
        this.moveDown = new Animation(ANIMATION_FRAME_DELAY, regions[MOVE_DOWN]);
    }

    public Animation getMoveRight() {
        return moveRight;
    }

    public Animation getMoveLeft() {
        return moveLeft;
    }

    public Animation getMoveUp() {
        return moveUp;
    }

    public Animation getMoveDown() {
        return moveDown;
    }

    public Animation getStand() {
        return stand;
    }

    public Animation getMoveUpLeft() {
        return moveUpLeft;
    }

    public Animation getMoveUpRight() {
        return moveUpRight;
    }

    public Animation getMoveDownLeft() {
        return moveDownLeft;
    }

    public Animation getMoveDownRight() {
        return moveDownRight;
    }
}
