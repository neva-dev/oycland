package com.neva.oycland.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.neva.oycland.core.control.AbstractGame;

public class TutorialScreen extends StageScreen {

    static final String NAME = "tutorial";

    private Sprite backgroundSprite;

    public TutorialScreen(AbstractGame game) {
        super(game);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void show() {
        initBackground();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        renderBackground();
    }

    private void initBackground() {
        backgroundSprite = new Sprite(new Texture(Gdx.files.internal("images/map.png")));
        backgroundSprite.setPosition(0, 0);
        backgroundSprite.setSize(WORLD_WIDTH, WORLD_HEIGHT);
    }

    private void renderBackground() {
        final SpriteBatch batch = game.getGfx().getBatch();

        batch.begin();
        backgroundSprite.draw(batch);
        batch.end();
    }
}
