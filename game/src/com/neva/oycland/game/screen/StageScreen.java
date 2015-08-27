package com.neva.oycland.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.core.control.screen.AbstractScreen;

public abstract class StageScreen extends AbstractScreen {

    public static final int WORLD_WIDTH = 100;

    public static final int WORLD_HEIGHT = 100;

    private OrthographicCamera camera;

    public StageScreen(AbstractGame game) {
        super(game);

        setupCamera();
    }

    @Override
    public void show() {
        super.show();

        setupCamera();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        updateCamera();
    }

    private void setupCamera() {
        final float w = Gdx.graphics.getWidth();
        final float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(WORLD_WIDTH, WORLD_HEIGHT * (h / w));
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();
    }

    private void updateCamera() {
        camera.update();
        game.getGfx().getBatch().setProjectionMatrix(camera.combined);
    }
}
