package com.neva.oycland.game.screen.level;

import com.neva.oycland.game.OyclandGame;
import com.neva.oycland.game.actor.Ghost;
import com.neva.oycland.game.actor.Villager;
import com.neva.oycland.game.screen.LevelScreen;

import static com.neva.oycland.core.gfx.ActorUtils.placeCenter;
import static com.neva.oycland.core.gfx.ActorUtils.placeOnRandomEdge;
import static com.neva.oycland.core.gfx.GfxUtils.loadSprite;

public class GraveyardScreen extends LevelScreen {

    @Override
    public String getName() {
        return "Graveyard";
    }

    public GraveyardScreen(OyclandGame game) {
        super(game);

        ui.setBackground(loadSprite("images/graveyard.png"));

        Villager villager = new Villager(player);
        stage.addActor(villager);
        placeCenter(villager);

        for (int i = 0; i < 20; i++) {
            Ghost ghost = new Ghost();
            stage.addActor(ghost);
            placeOnRandomEdge(ghost);
        }
    }

}
