package com.neva.oycland.core.gfx.animation;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.neva.oycland.core.control.Command;
import com.neva.oycland.core.control.Controller;

public class AnimatedImageController {

    private static final float CROSS_DELAY = 0.7071f; // 1 / square root of 2

    private final Controller controller;

    private final AnimatedImage actor;

    private final AnimatedMoveFactory moveFactory;

    public AnimatedImageController(AnimatedImage actor, AnimatedMoveFactory moveFactory, Controller controller) {
        this.controller = controller;
        this.actor = actor;
        this.moveFactory = moveFactory;
    }

    public void control(float delta) {
        final Command command = controller.control(delta);
        final Stage stage = actor.getStage();
        final float moveSpeed = actor.getMoveSpeed();

        switch (command) {
            case MOVE_UP_LEFT:
                actor.setAnimation(moveFactory.getMoveUpLeft());
                actor.setX(Math.max(0, actor.getX() - delta * moveSpeed * CROSS_DELAY));
                actor.setY(Math.min(stage.getHeight() - actor.getHeight(), actor.getY() + delta * moveSpeed * CROSS_DELAY));
                break;
            case MOVE_UP_RIGHT:
                actor.setAnimation(moveFactory.getMoveUpRight());
                actor.setX(Math.min(stage.getWidth() - actor.getWidth(), actor.getX() + delta * moveSpeed * CROSS_DELAY));
                actor.setY(Math.min(stage.getHeight() - actor.getHeight(), actor.getY() + delta * moveSpeed * CROSS_DELAY));
                break;
            case MOVE_DOWN_LEFT:
                actor.setAnimation(moveFactory.getMoveDownLeft());
                actor.setX(Math.max(0, actor.getX() - delta * moveSpeed * CROSS_DELAY));
                actor.setY(Math.max(0, actor.getY() - delta * moveSpeed * CROSS_DELAY));
                break;
            case MOVE_DOWN_RIGHT:
                actor.setAnimation(moveFactory.getMoveDownRight());
                actor.setY(Math.max(0, actor.getY() - delta * moveSpeed * CROSS_DELAY));
                actor.setX(Math.min(stage.getWidth() - actor.getWidth(), actor.getX() + delta * moveSpeed * CROSS_DELAY));
                break;
            case MOVE_LEFT:
                actor.setAnimation(moveFactory.getMoveLeft());
                actor.setX(Math.max(0, actor.getX() - delta * moveSpeed));
                break;
            case MOVE_RIGHT:
                actor.setAnimation(moveFactory.getMoveRight());
                actor.setX(Math.min(stage.getWidth() - actor.getWidth(), actor.getX() + delta * moveSpeed));
                break;
            case MOVE_UP:
                actor.setAnimation(moveFactory.getMoveUp());
                actor.setY(Math.min(stage.getHeight() - actor.getHeight(), actor.getY() + delta * moveSpeed));
                break;
            case MOVE_DOWN:
                actor.setAnimation(moveFactory.getMoveDown());
                actor.setY(Math.max(0, actor.getY() - delta * moveSpeed));
                break;
            case IDLE:
            default:
                actor.setAnimation(moveFactory.getStand());
                break;
        }
    }
}
