package com.neva.oycland.core.gfx;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import org.apache.commons.lang3.RandomUtils;

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

}
