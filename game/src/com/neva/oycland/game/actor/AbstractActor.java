package com.neva.oycland.game.actor;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.neva.oycland.core.control.Controller;
import com.neva.oycland.core.gfx.ActorUtils;
import com.neva.oycland.core.gfx.BoundingBox;
import com.neva.oycland.core.gfx.animation.AnimatedImage;
import com.neva.oycland.core.gfx.animation.AnimatedMoveFactory;
import com.neva.oycland.core.gfx.animation.AnimationFactory;
import com.neva.oycland.game.Progress;

import java.util.List;

public class AbstractActor extends AnimatedImage {

    protected final Progress progress;

    public AbstractActor(Progress progress, AnimationFactory animationFactory) {
        super(animationFactory);

        this.progress = progress;
    }

    public AbstractActor(Progress progress, Controller controller, AnimatedMoveFactory animatedMoveFactory) {
        super(controller, animatedMoveFactory);

        this.progress = progress;
    }

    public BoundingBox getBoundingBox() {
        return new BoundingBox(this);
    }

    public boolean isColliding(AbstractActor actor) {
        return getBoundingBox().overlaps(actor.getBoundingBox());
    }

    public List<AbstractActor> getColliding() {
        //@formatter:off
        return FluentIterable.from(ActorUtils.ofType(getStage().getActors(), AbstractActor.class))
                .filter(new Predicate<AbstractActor>() {
                    @Override
                    public boolean apply(AbstractActor actor) {
                        return isColliding(actor);
                    }
                })
                .toList();
        //@formatter:on
    }
}
