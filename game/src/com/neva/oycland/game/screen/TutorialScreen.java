package com.neva.oycland.game.screen;

import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.core.control.Player2Axis;
import com.neva.oycland.core.gfx.GfxUtils;
import com.neva.oycland.game.actor.Villager;

public class TutorialScreen extends StageScreen {

    public static final String NAME = "tutorial";

    private final Player2Axis player2Axis;

    private final Villager villager;

    public TutorialScreen(AbstractGame game) {
        super(game);

        villager = new Villager(stage);
        player2Axis = new Player2Axis();

        table.setBackground(GfxUtils.loadDrawableSprite("images/map.jpg"));
        table.add(villager);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        villager.control(delta, player2Axis.getActiveKeys());
    }

    @Override
    public void show() {
        super.show();

        game.getInput().addProcessor(player2Axis);
    }

    @Override
    public void hide() {
        super.hide();

        game.getInput().removeProcessor(player2Axis);
    }
}
