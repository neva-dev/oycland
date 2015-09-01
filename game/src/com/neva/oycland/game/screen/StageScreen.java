package com.neva.oycland.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.neva.oycland.core.control.screen.AbstractScreen;
import com.neva.oycland.game.OyclandGame;
import com.neva.oycland.game.ui.Ui;

public abstract class StageScreen extends AbstractScreen {

    public static final int WIDTH = 800;

    public static final int HEIGHT = 450;

    public static final String SKIN_PATH = "skin/uiskin.json";

    protected final Stage stage;

    protected final Skin skin;

    protected final Ui ui;

    protected final Timer timer;

    public StageScreen(OyclandGame game) {
        super(game);

        stage = new Stage(new FitViewport(WIDTH, HEIGHT));

        skin = new Skin(Gdx.files.internal(SKIN_PATH));

        ui = new Ui(skin);
        stage.addActor(ui);

        timer = new Timer();
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

        timer.start();
        game.getInput().addProcessor(stage);
    }

    @Override
    public void hide() {
        super.hide();

        timer.stop();
        game.getInput().removeProcessor(stage);
    }

    @Override
    public void dispose() {
        super.dispose();

        stage.dispose();
    }

    public Timer getTimer() {
        return timer;
    }
}
