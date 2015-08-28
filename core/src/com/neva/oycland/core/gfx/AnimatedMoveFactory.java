package com.neva.oycland.core.gfx;

import com.badlogic.gdx.graphics.g2d.Animation;

public interface AnimatedMoveFactory {

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
