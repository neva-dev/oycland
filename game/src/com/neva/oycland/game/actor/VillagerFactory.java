package com.neva.oycland.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.neva.oycland.core.gfx.AnimatedImage;

public class VillagerFactory {

    private static final String ASSET_PATH = "images/villager.png";

    private static final int FRAME_COLS = 13;

    private static final int FRAME_ROWS = 8;

    private static final int STAND_ROW = 0;

    private static final int STAND_COL = 4;

    private static final int MOVE_UP = 4;

    private static final int MOVE_DOWN = 0;

    private static final int MOVE_LEFT = 3;

    private static final int MOVE_RIGHT = 7;

    private static final float ANIMATION_FRAME_DELAY = 0.05f;

    private final Animation moveRight;

    private final Animation moveLeft;

    private final Animation moveUp;

    private final Animation moveDown;

    private final Animation stand;

    public VillagerFactory() {
        Texture texture = new Texture(Gdx.files.internal(ASSET_PATH));
        TextureRegion[][] regions = TextureRegion.split(texture, texture.getWidth() / FRAME_COLS, texture.getHeight() / FRAME_ROWS);

        this.stand = new Animation(ANIMATION_FRAME_DELAY, regions[STAND_ROW][STAND_COL]);
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
}
