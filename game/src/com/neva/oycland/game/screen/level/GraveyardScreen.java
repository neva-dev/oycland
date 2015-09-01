package com.neva.oycland.game.screen.level;

import com.neva.oycland.game.OyclandGame;
import com.neva.oycland.game.Progress;
import com.neva.oycland.game.actor.Flame;
import com.neva.oycland.game.actor.Ghost;
import com.neva.oycland.game.actor.Villager;
import com.neva.oycland.game.screen.LevelScreen;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.neva.oycland.core.gfx.ActorUtils.placeCenter;
import static com.neva.oycland.core.gfx.ActorUtils.placeOnRandomEdge;
import static com.neva.oycland.core.gfx.GfxUtils.loadSprite;

public class GraveyardScreen extends LevelScreen {

    private static final int GHOST_ADD_DELAY = 3;

    private float stateTime = 0;

    public GraveyardScreen(OyclandGame game) {
        super(game);

        ui.setBackground(loadSprite("images/graveyard.png"));

        final Progress progress = game.getProgress();

        Villager villager = new Villager(progress, player);
        stage.addActor(villager);
        placeCenter(villager);

        Flame flame = new Flame(progress);
        stage.addActor(flame);
        placeCenter(flame);
    }

    @Override
    public String getName() {
        return "Graveyard";
    }

    @Override
    public void render(float delta) {
        stateTime += delta;

        if (stateTime == 0 || stateTime >= GHOST_ADD_DELAY) {
            stateTime = 0;
            addGhosts(1);
        }

        super.render(delta);
    }

    private void addGhosts(int count) {
        final Progress progress = ((OyclandGame) game).getProgress();

        for (int i = 0; i < count; i++) {
            Ghost ghost = new Ghost(progress);
            stage.addActor(ghost);

            ghost.setColor(ghost.getColor().set(ghost.getColor().r, ghost.getColor().g, ghost.getColor().b, 0));
            ghost.addAction(fadeIn(30f));

            placeOnRandomEdge(ghost);
        }
    }
}
