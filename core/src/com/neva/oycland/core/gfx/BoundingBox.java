package com.neva.oycland.core.gfx;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BoundingBox extends Rectangle {

    public BoundingBox(Actor actor) {
        super(actor.getX() + actor.getWidth() * 0.25f, actor.getY() + actor.getHeight() * 0.25f, actor.getWidth() * 0.5f, actor.getHeight() * 0.5f);
    }
}
