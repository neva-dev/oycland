package com.neva.oycland.core.control;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public final class ActorUtils {

    public static void placeTopCenter(Actor actor) {
        Stage stage = actor.getStage();
        actor.setPosition(stage.getWidth() / 2 - actor.getWidth() / 2, stage.getHeight() - actor.getHeight());
    }

}
