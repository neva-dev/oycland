package com.neva.oycland.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.neva.oycland.core.control.screen.AbstractScreen;
import com.neva.oycland.game.OyclandGame;

public abstract class StageScreen extends AbstractScreen {

    public static final int WIDTH = 800;

    public static final int HEIGHT = 450;

    public static final String SKIN_PATH = "skin/uiskin.json";

    protected final Skin skin;

    protected final Table table;

    protected final Stage stage;

    public StageScreen(OyclandGame game) {
        super(game);

        skin = new Skin(Gdx.files.internal(SKIN_PATH));

        table = new Table(skin);
        table.setFillParent(true);

        stage = new Stage(new FitViewport(WIDTH, HEIGHT));
        stage.addActor(table);
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
    public void show() {
        super.show();

        game.getInput().addProcessor(stage);
    }

    @Override
    public void hide() {
        super.hide();

        game.getInput().removeProcessor(stage);
    }

    @Override
    public void dispose() {
        super.dispose();

        stage.dispose();
    }
}
