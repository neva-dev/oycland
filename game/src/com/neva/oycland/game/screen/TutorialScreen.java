package com.neva.oycland.game.screen;

import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.game.actor.Villager;

import static com.neva.oycland.core.control.ActorUtils.placeTopCenter;
import static com.neva.oycland.core.gfx.GfxUtils.loadSprite;

public class TutorialScreen extends StageScreen {

    public static final String NAME = "tutorial";

    private final Villager villager;

    public TutorialScreen(AbstractGame game) {
        super(game);

        table.setBackground(loadSprite("images/map.jpg"));

        villager = new Villager();
        stage.addActor(villager);

        placeTopCenter(villager);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        villager.getController().control(player, delta);
    }

}
