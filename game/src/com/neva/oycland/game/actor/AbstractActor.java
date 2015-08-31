package com.neva.oycland.game.actor;

import com.neva.oycland.core.control.Controller;
import com.neva.oycland.core.gfx.AnimatedImage;
import com.neva.oycland.core.gfx.AnimationFactory;
import com.neva.oycland.core.gfx.BoundingBox;
import com.neva.oycland.game.Progress;

public class AbstractActor extends AnimatedImage {

    protected final Progress progress;

    public AbstractActor(Progress progress, Controller controller, AnimationFactory animationFactory) {
        super(controller, animationFactory);

        this.progress = progress;
    }

    public BoundingBox getBoundingBox() {
        return new BoundingBox(this);
    }

    public boolean isColliding(AbstractActor actor) {
        return getBoundingBox().overlaps(actor.getBoundingBox());
    }

}
