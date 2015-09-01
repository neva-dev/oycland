package com.neva.oycland.game.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.neva.oycland.game.OyclandGame;
import com.neva.oycland.game.Progress;
import com.neva.oycland.game.screen.LevelScreen;

public class Hud extends Table {

    protected final Progress progress;
    protected final Label scoreLabel;
    protected Label timeLabel;

    public Hud(LevelScreen level, Skin skin) {
        super(skin);

        this.progress = ((OyclandGame) level.getGame()).getProgress();

        setFillParent(true);

        timeLabel = new Label(formatTime(progress.getTimeElapsed()), skin);
        scoreLabel = new Label(formatScore(progress.getScore()), skin);

        add(timeLabel).expand().top().left().pad(10f);
        add(new Label(level.getName(), skin)).expand().top().pad(10f);
        add(scoreLabel).expand().top().right().pad(10f);
    }

    public static String formatScore(int score) {
        return "Score: " + String.format("%06d", score);
    }

    public static String formatTime(int seconds) {
        return "Time: " + String.format("%d:%02d", Math.round(seconds / 60), Math.round(seconds) % 60);
    }

    @Override
    public void act(float delta) {
        timeLabel.setText(formatTime(progress.getTimeElapsed()));
        scoreLabel.setText(formatScore(progress.getScore()));
    }
}
