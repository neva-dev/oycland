package com.neva.oycland.game.screen;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.neva.oycland.game.OyclandGame;
import com.neva.oycland.game.ui.Hud;

import static com.neva.oycland.core.gfx.GfxUtils.loadSprite;

public class SummaryScreen extends StageScreen {

    public SummaryScreen(final OyclandGame game) {
        super(game);

        ui.setBackground(loadSprite("images/main-menu.jpg"));
        ui.center();

        {
            Label label = new Label("Game over", skin);
            label.setFontScale(2f);

            ui.add(label).row();
        }

        {
            Label label = new Label(Hud.formatScore(game.getProgress().getScore()), skin);
            ui.add(label).padBottom(5f).row();
        }

        {
            Label label = new Label(Hud.formatTime(game.getProgress().getTimeElapsed()), skin);
            ui.add(label).padBottom(5f).row();
        }

        {
            TextButton btn = new TextButton("Try again", skin);
            btn.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.start(game.getProgress().getLastLevel());
                }
            });

            ui.add(btn).row();
        }

        {
            TextButton btn = new TextButton("Back to main menu", skin);
            btn.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.setScreen(MainMenuScreen.class);
                }
            });

            ui.add(btn).row();
        }
    }
}


