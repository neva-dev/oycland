package com.neva.oycland.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Timer;
import com.neva.oycland.core.control.player.Player;
import com.neva.oycland.game.OyclandGame;
import com.neva.oycland.game.ui.Hud;

public abstract class LevelScreen extends StageScreen {

    protected Music music;

    protected Player player;

    protected Hud hud;

    public LevelScreen(final OyclandGame game) {
        super(game);

        player = new Player();

        hud = new Hud(this, skin);
        stage.addActor(hud);

        music = Gdx.audio.newMusic(Gdx.files.internal("music/graveyard.mp3"));

        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                game.getProgress().incrementTime();
            }
        }, 0, 1);
    }

    public abstract String getName();

    @Override
    public void show() {
        super.show();

        player.getActiveKeys().clear();
        game.getInput().addProcessor(player);

        music.setLooping(true);
        music.play();
    }

    @Override
    public void hide() {
        super.hide();

        game.getInput().removeProcessor(player);

        music.pause();
    }
}
