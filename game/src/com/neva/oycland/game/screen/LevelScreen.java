package com.neva.oycland.game.screen;

import com.neva.oycland.core.control.player.Player;
import com.neva.oycland.game.OyclandGame;

public abstract class LevelScreen extends StageScreen {

    protected final Player player;

    public LevelScreen(OyclandGame game) {
        super(game);

        player = new Player();
    }

    @Override
    public void show() {
        super.show();

        game.getInput().addProcessor(player);
    }

    @Override
    public void hide() {
        super.hide();

        game.getInput().removeProcessor(player);
    }
}
