package com.neva.oycland.core.gfx.animation;

import com.badlogic.gdx.graphics.g2d.Animation;

public interface AnimatedMoveFactory extends AnimationFactory {

    Animation getMoveRight();

    Animation getMoveLeft();

    Animation getMoveUp();

    Animation getMoveDown();

    Animation getStand();

    Animation getMoveUpLeft();

    Animation getMoveUpRight();

    Animation getMoveDownLeft();

    Animation getMoveDownRight();

}
