package com.neva.oycland.game.actor;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import com.neva.oycland.core.control.Controller;
import com.neva.oycland.core.gfx.BoundingBox;
import com.neva.oycland.core.gfx.animation.AnimatedImage;
import com.neva.oycland.core.gfx.animation.AnimatedMoveFactory;
import com.neva.oycland.core.gfx.animation.AnimationFactory;
import com.neva.oycland.game.Progress;

import java.util.Comparator;
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
        return FluentIterable.from(getActorsOfType(AbstractActor.class)).filter(new Predicate<AbstractActor>() {
            @Override
            public boolean apply(AbstractActor actor) {
                return isColliding(actor);
            }
        }).toList();
    }

    public double getDistance(AbstractActor actor) {
        double dx = Math.pow((getX() + getWidth() / 2) - (actor.getX() + actor.getWidth() / 2), 2);
        double dy = Math.pow((getY() + getHeight() / 2) - (actor.getY() + actor.getHeight() / 2), 2);

        return Math.sqrt(dx + dy);
    }

    public <T> List<T> getActorsOfType(final Class<T> clazz) {
        //@formatter:off
        return FluentIterable.from(getStage().getActors())
                .transform(new Function<Actor, T>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public T apply(Actor actor) {
                        if (clazz.isAssignableFrom(actor.getClass())) {
                            return (T) actor;
                        }

                        return null;
                    }
                })
                .filter(Predicates.notNull())
                .toList();
        //@formatter:on
    }

    public <T extends AbstractActor> List<T> getNearestActorsOfType(Class<T> clazz) {
        return sortActorsByDistance(getActorsOfType(clazz));
    }

    protected <T extends AbstractActor> List<T> sortActorsByDistance(List<T> actors) {
        return FluentIterable.from(actors).toSortedList(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Double.valueOf(o1.getDistance(AbstractActor.this)).compareTo(o2.getDistance(AbstractActor.this));
            }
        });
    }

}
