package com.neva.oycland.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.neva.oycland.game.OyclandGame;
import com.neva.oycland.game.screen.level.GraveyardScreen;

import static com.neva.oycland.core.gfx.GfxUtils.loadSprite;

public class MainMenuScreen extends StageScreen {

    public MainMenuScreen(final OyclandGame game) {
        super(game);

        ui.setBackground(loadSprite("images/main-menu.jpg"));
        ui.center();

        {
            Label label = new Label("Oycland", skin);
            label.setFontScale(2f);

            ui.add(label).row();
        }

        {
            TextButton btn = new TextButton("New game", skin);
            btn.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.setScreen(GraveyardScreen.class);
                }
            });

            ui.add(btn).row();
        }

        {
            TextButton btn = new TextButton("Quit", skin);
            btn.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    Gdx.app.exit();
                }
            });

            ui.add(btn).row();
        }
    }
}


