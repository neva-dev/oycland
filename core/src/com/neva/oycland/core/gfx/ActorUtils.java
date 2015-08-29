package com.neva.oycland.core.gfx;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public final class ActorUtils {

    public static Actor placeXCenter(Actor actor) {
        Stage stage = actor.getStage();
        actor.setX(stage.getWidth() / 2 - actor.getWidth() / 2);

        return actor;
    }

    public static Actor placeYCenter(Actor actor) {
        Stage stage = actor.getStage();
        actor.setY(stage.getHeight() / 2 - actor.getHeight() / 2);

        return actor;
    }

    public static Actor placeCenter(Actor actor) {
        placeXCenter(actor);
        placeYCenter(actor);

        return actor;
    }

    public static Actor placeTop(Actor actor) {
        Stage stage = actor.getStage();
        actor.setY(stage.getHeight() - actor.getHeight());

        return actor;
    }

}
