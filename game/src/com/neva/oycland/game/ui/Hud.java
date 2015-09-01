package com.neva.oycland.game.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Timer;
import com.neva.oycland.game.OyclandGame;
import com.neva.oycland.game.Progress;
import com.neva.oycland.game.screen.LevelScreen;

public class Hud extends Table {

    protected final Progress progress;
    protected final Label scoreLabel;
    protected Label timeLabel;
    protected int timeElapsed;

    public Hud(LevelScreen level, Skin skin) {
        super(skin);

        this.progress = ((OyclandGame) level.getGame()).getProgress();

        level.getTimer().scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                timeElapsed++;
            }
        }, 0, 1);

        setFillParent(true);

        timeLabel = new Label(getTimeFormatted(), skin);
        scoreLabel = new Label(getScoreFormatted(), skin);

        add(timeLabel).expand().top().left().pad(10f);
        add(new Label(level.getName(), skin)).expand().top().pad(10f);
        add(scoreLabel).expand().top().right().pad(10f);
    }

    @Override
    public void act(float delta) {
        timeLabel.setText(getTimeFormatted());
        scoreLabel.setText(getScoreFormatted());
    }

    private String getScoreFormatted() {
        return "Score: " + String.format("%06d", progress.getScore());
    }

    private String getTimeFormatted() {
        return "Time: " + String.format("%d:%02d", Math.round(timeElapsed / 60), Math.round(timeElapsed) % 60);
    }
}
