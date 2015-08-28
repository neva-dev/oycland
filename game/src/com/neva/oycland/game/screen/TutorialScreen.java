package com.neva.oycland.game.screen;

import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.core.gfx.GfxUtils;

public class TutorialScreen extends StageScreen {

    static final String NAME = "tutorial";

    public TutorialScreen(AbstractGame game) {
        super(game);

        table.setBackground(GfxUtils.loadDrawableSprite("images/map.jpg"));
    }

    @Override
    public String getName() {
        return NAME;
    }
}
