package com.neva.oycland.game.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.core.control.screen.AbstractScreen;

public class MainMenuScreen extends AbstractScreen {

    private Texture img = new Texture("badlogic.jpg");

    public MainMenuScreen(AbstractGame game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        final SpriteBatch batch = game.getGfxContext().getBatch();

        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }
}


