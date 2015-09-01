package com.neva.oycland.core.gfx;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;
import org.apache.commons.lang3.RandomUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public final class ActorUtils {

    public static Actor placeCenterX(Actor actor) {
        Stage stage = actor.getStage();
        actor.setX(stage.getWidth() / 2 - actor.getWidth() / 2);

        return actor;
    }

    public static Actor placeCenterY(Actor actor) {
        Stage stage = actor.getStage();
        actor.setY(stage.getHeight() / 2 - actor.getHeight() / 2);

        return actor;
    }

    public static Actor placeCenter(Actor actor) {
        placeCenterX(actor);
        placeCenterY(actor);

        return actor;
    }

    public static Actor placeTop(Actor actor) {
        Stage stage = actor.getStage();
        actor.setY(stage.getHeight() - actor.getHeight());

        return actor;
    }

    public static Actor placeBottom(Actor actor) {
        actor.setY(0);

        return actor;
    }

    public static Actor placeLeft(Actor actor) {
        actor.setX(0);

        return actor;
    }

    public static Actor placeRight(Actor actor) {
        Stage stage = actor.getStage();
        actor.setX(stage.getWidth() - actor.getWidth());

        return actor;
    }

    public static Actor placeRandomX(Actor actor) {
        Stage stage = actor.getStage();
        actor.setX(RandomUtils.nextFloat(0, stage.getWidth() - actor.getWidth()));

        return actor;
    }

    public static Actor placeRandomY(Actor actor) {
        Stage stage = actor.getStage();
        actor.setY(RandomUtils.nextFloat(0, stage.getHeight() - actor.getHeight()));

        return actor;
    }

    public static Actor placeOnRandomEdge(Actor actor) {
        switch (new Random().nextInt(4)) {
            case 0:
                placeRandomX(placeTop(actor));
                break;
            case 1:
                placeRandomY(placeRight(actor));
                break;
            case 2:
                placeRandomX(placeBottom(actor));
                break;
            case 3:
                placeRandomY(placeLeft(actor));
                break;
        }

        return actor;
    }

    public static Actor placeRandom(Actor actor) {
        return placeRandomY(placeRandomX(actor));
    }

    public static double getDistance(Actor a1, Actor a2) {
        double dx = Math.pow((a1.getX() + a1.getWidth() / 2) - (a2.getX() + a2.getWidth() / 2), 2);
        double dy = Math.pow((a1.getY() + a1.getHeight() / 2) - (a2.getY() + a2.getHeight() / 2), 2);

        return Math.sqrt(dx + dy);
    }

    public static <T, U extends Actor> List<T> ofType(Iterable<U> actors, final Class<T> clazz) {
        //@formatter:off
        return FluentIterable.from(actors)
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

    public static <T extends Actor> List<T> nearestTo(Actor target, Iterable<Actor> actors, Class<T> clazz) {
        return sortActorsByDistance(target, ofType(actors, clazz));
    }

    protected static <T extends Actor> List<T> sortActorsByDistance(final Actor target, List<T> actors) {
        return FluentIterable.from(actors).toSortedList(new Comparator<T>() {
            @Override
            public int compare(T a1, T a2) {
                return Double.valueOf(getDistance(target, a1)).compareTo(getDistance(target, a2));
            }
        });
    }

}
