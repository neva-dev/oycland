package com.neva.oycland.game.actor;

import com.neva.oycland.core.control.Controller;
import com.neva.oycland.core.gfx.AnimatedImage;
import com.neva.oycland.core.gfx.AnimationFactory;
import com.neva.oycland.core.gfx.BBox;
import com.neva.oycland.game.Progress;

public class AbstractActor extends AnimatedImage {

    protected final Progress progress;

    public AbstractActor(Progress progress, Controller controller, AnimationFactory animationFactory) {
        super(controller, animationFactory);

        this.progress = progress;
    }

    public BBox getBBox() {
        return new BBox(getX(), getY(), getWidth(), getHeight());
    }

    public boolean isColliding(AbstractActor actor) {
        return getBBox().overlaps(actor.getBBox());
    }

}
