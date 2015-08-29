package com.neva.oycland.game.screen.level;

import com.neva.oycland.game.OyclandGame;
import com.neva.oycland.game.actor.Ghost;
import com.neva.oycland.game.actor.Villager;
import com.neva.oycland.game.screen.LevelScreen;

import static com.neva.oycland.core.control.ActorUtils.placeTopCenter;
import static com.neva.oycland.core.gfx.GfxUtils.loadSprite;

public class TutorialScreen extends LevelScreen {

    private final Villager villager;

    private final Ghost ghost;

    public TutorialScreen(OyclandGame game) {
        super(game);

        table.setBackground(loadSprite("images/map.jpg"));

        villager = new Villager(player);
        stage.addActor(villager);

        ghost = new Ghost();
        stage.addActor(ghost);

        placeTopCenter(villager);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        villager.getController().control(delta);
        ghost.getController().control(delta);
    }

}
