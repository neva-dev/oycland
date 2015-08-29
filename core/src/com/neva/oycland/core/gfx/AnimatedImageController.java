package com.neva.oycland.core.gfx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.neva.oycland.core.control.player.Player;
import com.neva.oycland.core.control.player.PlayerKeys;

public class AnimatedImageController {

    private static final float CROSS_DELAY = 0.7071f; // 1 / square root of 2

    private final AnimatedImage actor;

    private final AnimatedMoveFactory moveFactory;

    private final float moveSpeed;

    public AnimatedImageController(AnimatedImage actor, AnimatedMoveFactory moveFactory, float moveSpeed) {
        this.actor = actor;
        this.moveFactory = moveFactory;
        this.moveSpeed = moveSpeed;
    }

    public void control(Player player, float delta) {
        final PlayerKeys activeKeys = player.getActiveKeys();
        final Stage stage = actor.getStage();

        if (activeKeys.isPressed(Input.Keys.UP) && activeKeys.isPressed(Input.Keys.LEFT)) {
            actor.setAnimation(moveFactory.getMoveUpLeft());
            actor.setX(Math.max(0, actor.getX() - delta * moveSpeed * CROSS_DELAY));
            actor.setY(Math.min(stage.getHeight() - actor.getHeight(), actor.getY() + delta * moveSpeed * CROSS_DELAY));
        } else if (activeKeys.isPressed(Input.Keys.UP) && activeKeys.isPressed(Input.Keys.RIGHT)) {
            actor.setAnimation(moveFactory.getMoveUpRight());
            actor.setX(Math.min(stage.getWidth() - actor.getWidth(), actor.getX() + delta * moveSpeed * CROSS_DELAY));
            actor.setY(Math.min(stage.getHeight() - actor.getHeight(), actor.getY() + delta * moveSpeed * CROSS_DELAY));
        } else if (activeKeys.isPressed(Input.Keys.DOWN) && activeKeys.isPressed(Input.Keys.LEFT)) {
            actor.setAnimation(moveFactory.getMoveDownLeft());
            actor.setX(Math.max(0, actor.getX() - delta * moveSpeed * CROSS_DELAY));
            actor.setY(Math.max(0, actor.getY() - delta * moveSpeed * CROSS_DELAY));
        } else if (activeKeys.isPressed(Input.Keys.DOWN) && activeKeys.isPressed(Input.Keys.RIGHT)) {
            actor.setAnimation(moveFactory.getMoveDownRight());
            actor.setY(Math.max(0, actor.getY() - delta * moveSpeed * CROSS_DELAY));
            actor.setX(Math.min(stage.getWidth() - actor.getWidth(), actor.getX() + delta * moveSpeed * CROSS_DELAY));
        } else if (activeKeys.isPressed(Input.Keys.LEFT)) {
            actor.setAnimation(moveFactory.getMoveLeft());
            actor.setX(Math.max(0, actor.getX() - delta * moveSpeed));
        } else if (activeKeys.isPressed(Input.Keys.RIGHT)) {
            actor.setAnimation(moveFactory.getMoveRight());
            actor.setX(Math.min(stage.getWidth() - actor.getWidth(), actor.getX() + delta * moveSpeed));
        } else if (activeKeys.isPressed(Input.Keys.DOWN)) {
            actor.setAnimation(moveFactory.getMoveDown());
            actor.setY(Math.max(0, actor.getY() - delta * moveSpeed));
        } else if (activeKeys.isPressed(Input.Keys.UP)) {
            actor.setAnimation(moveFactory.getMoveUp());
            actor.setY(Math.min(stage.getHeight() - actor.getHeight(), actor.getY() + delta * moveSpeed));
        } else {
            actor.setAnimation(moveFactory.getStand());
        }
    }
}
