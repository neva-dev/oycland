package com.neva.oycland.game.actor;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.neva.oycland.core.gfx.AnimatedImage;

import java.util.Map;

public class Villager extends AnimatedImage {

    private static final float MOVE_SPEED = 150f;

    private static final float MOVE_CROSS_DELAY = 0.7071f; // 1 / square root of 2

    private static final VillagerFactory FACTORY = new VillagerFactory();

    private final Stage stage;

    public Villager(Stage stage) {
        super(FACTORY.getStand());

        this.stage = stage;
    }

    public void moveUp(float delta) {
        setAnimation(FACTORY.getMoveUp());
    }

    public void moveDown(float delta) {
        setAnimation(FACTORY.getMoveDown());
    }

    public void control(float delta, Map<Integer, Boolean> activeKeys) {
        if (activeKeys.get(Input.Keys.UP) && activeKeys.get(Input.Keys.LEFT)) {
            setAnimation(FACTORY.getMoveUpLeft());
            setX(Math.max(0, getX() - delta * MOVE_SPEED * MOVE_CROSS_DELAY));
            setY(Math.min(stage.getHeight() - getHeight(), getY() + delta * MOVE_SPEED * MOVE_CROSS_DELAY));
        } else if (activeKeys.get(Input.Keys.UP) && activeKeys.get(Input.Keys.RIGHT)) {
            setAnimation(FACTORY.getMoveUpRight());
            setX(Math.min(stage.getWidth() - getWidth(), getX() + delta * MOVE_SPEED * MOVE_CROSS_DELAY));
            setY(Math.min(stage.getHeight() - getHeight(), getY() + delta * MOVE_SPEED * MOVE_CROSS_DELAY));
        } else if (activeKeys.get(Input.Keys.DOWN) && activeKeys.get(Input.Keys.LEFT)) {
            setAnimation(FACTORY.getMoveDownLeft());
            setX(Math.max(0, getX() - delta * MOVE_SPEED * MOVE_CROSS_DELAY));
            setY(Math.max(0, getY() - delta * MOVE_SPEED * MOVE_CROSS_DELAY));
        } else if (activeKeys.get(Input.Keys.DOWN) && activeKeys.get(Input.Keys.RIGHT)) {
            setAnimation(FACTORY.getMoveDownRight());
            setY(Math.max(0, getY() - delta * MOVE_SPEED * MOVE_CROSS_DELAY));
            setX(Math.min(stage.getWidth() - getWidth(), getX() + delta * MOVE_SPEED * MOVE_CROSS_DELAY));
        } else if (activeKeys.get(Input.Keys.LEFT)) {
            setAnimation(FACTORY.getMoveLeft());
            setX(Math.max(0, getX() - delta * MOVE_SPEED));
        } else if (activeKeys.get(Input.Keys.RIGHT)) {
            setAnimation(FACTORY.getMoveRight());
            setX(Math.min(stage.getWidth() - getWidth(), getX() + delta * MOVE_SPEED));
        } else if (activeKeys.get(Input.Keys.DOWN)) {
            setAnimation(FACTORY.getMoveDown());
            setY(Math.max(0, getY() - delta * MOVE_SPEED));
        } else if (activeKeys.get(Input.Keys.UP)) {
            setAnimation(FACTORY.getMoveUp());
            setY(Math.min(stage.getHeight() - getHeight(), getY() + delta * MOVE_SPEED));
        } else {
            setAnimation(FACTORY.getStand());
        }
    }
}
