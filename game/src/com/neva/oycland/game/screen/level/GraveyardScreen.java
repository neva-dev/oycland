package com.neva.oycland.game.screen.level;

import com.badlogic.gdx.utils.Timer;
import com.neva.oycland.game.OyclandGame;
import com.neva.oycland.game.Progress;
import com.neva.oycland.game.actor.Flame;
import com.neva.oycland.game.actor.Ghost;
import com.neva.oycland.game.actor.Villager;
import com.neva.oycland.game.screen.LevelScreen;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import static com.neva.oycland.core.gfx.ActorUtils.*;
import static com.neva.oycland.core.gfx.GfxUtils.loadSprite;

public class GraveyardScreen extends LevelScreen {

    public GraveyardScreen(OyclandGame game) {
        super(game);

        ui.setBackground(loadSprite("images/graveyard.png"));

        final Progress progress = game.getProgress();

        Villager villager = new Villager(progress, player);
        stage.addActor(villager);
        placeCenter(villager);

        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                addGhosts(1);
                progress.increaseScore(5);
            }
        }, 1, 3);

        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                addFlame();
            }
        }, 10, 10);
    }

    @Override
    public String getName() {
        return "Graveyard";
    }

    protected void addFlame() {
        final Progress progress = ((OyclandGame) game).getProgress();
        final Flame flame = new Flame(progress);

        stage.addActor(flame);
        placeRandom(flame);
        flame.getColor().a = 0;
        flame.addAction(sequence(fadeIn(3f)));
    }

    protected void addGhosts(int count) {
        final Progress progress = ((OyclandGame) game).getProgress();

        for (int i = 0; i < count; i++) {
            Ghost ghost = new Ghost(progress);
            stage.addActor(ghost);

            ghost.getColor().a = 0;
            ghost.addAction(fadeIn(30f));

            placeOnRandomEdge(ghost);
        }
    }
}
