package com.neva.oycland.game.screen;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.neva.oycland.game.OyclandGame;

import static com.neva.oycland.core.gfx.GfxUtils.loadSprite;

public class PauseScreen extends StageScreen {

    public PauseScreen(final OyclandGame game) {
        super(game);

        ui.setBackground(loadSprite("images/main-menu.jpg"));
        ui.center();

        {
            Label label = new Label("Pause", skin);
            label.setFontScale(2f);

            ui.add(label).row();
        }

        {
            TextButton btn = new TextButton("Resume game", skin);
            btn.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.setScreen(game.getProgress().getCurrentLevel());
                }
            });

            ui.add(btn).row();
        }

        {
            TextButton btn = new TextButton("Back to main menu", skin);
            btn.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.getScreens().unload(game.getProgress().getCurrentLevel().getClass());
                    game.setScreen(MainMenuScreen.class);
                }
            });

            ui.add(btn).row();
        }
    }
}


