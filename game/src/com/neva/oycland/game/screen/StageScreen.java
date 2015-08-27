package com.neva.oycland.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.neva.oycland.core.control.AbstractGame;
import com.neva.oycland.core.control.screen.AbstractScreen;

public abstract class StageScreen extends AbstractScreen {

    public static final int WIDTH = 800;

    public static final int HEIGHT = 450;

    protected final Skin skin;

    protected Table table;

    protected Stage stage;

    public StageScreen(AbstractGame game) {
        super(game);

        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        table = new Table(skin);
        table.setFillParent(true);

        stage = new Stage(new FitViewport(WIDTH, HEIGHT));
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        stage.getViewport().update(width, height, true);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();

        stage.dispose();
    }
}
