package com.neva.oycland.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.neva.oycland.core.control.AbstractGame;

import static com.neva.oycland.core.gfx.GfxUtils.loadSprite;

public class MainMenuScreen extends StageScreen {

    public static String NAME = "Main menu";

    public MainMenuScreen(final AbstractGame game) {
        super(game);

        table.setBackground(loadSprite("images/map.jpg"));
        table.center();

        {
            Label label = new Label("Oycland", skin);
            label.setFontScale(2f);

            table.add(label).row();
        }

        {
            TextButton btn = new TextButton("New game", skin);
            btn.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    game.setScreen(TutorialScreen.NAME);
                }
            });

            table.add(btn).row();
        }

        {
            TextButton btn = new TextButton("Quit", skin);
            btn.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    Gdx.app.exit();
                }
            });

            table.add(btn).row();
        }
    }

    @Override
    public String getName() {
        return NAME;
    }
}


