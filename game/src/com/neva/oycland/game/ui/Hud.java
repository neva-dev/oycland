package com.neva.oycland.game.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.neva.oycland.game.screen.LevelScreen;

public class Hud extends Table {

    private Label timeLabel;

    private float timeElapsed = 0;

    private final Label scoreLabel;

    private long score = 0;

    public Hud(LevelScreen level, Skin skin) {
        super(skin);

        setFillParent(true);

        timeLabel = new Label(getTimeFormatted(), skin);
        scoreLabel = new Label(getScoreFormatted(), skin);

        add(timeLabel).expand().top().left().pad(10f);
        add(new Label(level.getName(), skin)).expand().top().pad(10f);
        add(scoreLabel).expand().top().right().pad(10f);
    }

    @Override
    public void act(float delta) {
        timeElapsed += delta;
        timeLabel.setText(getTimeFormatted());
    }

    public void incrementScore(long value) {
        score += value;
        scoreLabel.setText(getScoreFormatted());
    }

    private String getScoreFormatted() {
        return "Score: " + String.format("%06d", score);
    }

    private String getTimeFormatted() {
        return "Time: " + String.format("%d:%02d", Math.round(timeElapsed / 60), Math.round(timeElapsed) % 60);
    }
}
