package com.neva.oycland.game.screen;

import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.core.control.Player;
import com.neva.oycland.core.gfx.GfxUtils;
import com.neva.oycland.game.actor.Villager;

public class TutorialScreen extends StageScreen {

    public static final String NAME = "tutorial";

    private final Player player;

    public TutorialScreen(AbstractGame game) {
        super(game);

        player = new Player(new Villager(stage));

        table.setBackground(GfxUtils.loadDrawableSprite("images/map.jpg"));
        table.add(player.getActor());
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
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
