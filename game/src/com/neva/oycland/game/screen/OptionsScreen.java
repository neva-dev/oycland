package com.neva.oycland.game.screen;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.neva.oycland.game.OyclandGame;

import static com.neva.oycland.core.gfx.GfxUtils.loadSprite;

public class OptionsScreen extends StageScreen {

    public OptionsScreen(final OyclandGame game) {
        super(game);

        table.setBackground(loadSprite("images/map.jpg"));
        table.center();

        {
            Label label = new Label("Paused", skin);
            label.setFontScale(2f);

            table.add(label).row();
        }

        {
            TextButton btn = new TextButton("Resume game", skin);
            btn.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.setScreen(game.getProgress().getCurrentLevel());
                }
            });

            table.add(btn).row();
        }

        {
            TextButton btn = new TextButton("Return to main menu", skin);
            btn.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.getScreens().unload(game.getProgress().getCurrentLevel().getClass());
                    game.setScreen(MainMenuScreen.class);
                }
            });

            table.add(btn).row();
        }
    }
}


