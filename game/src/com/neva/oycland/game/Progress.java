package com.neva.oycland.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.neva.oycland.game.screen.LevelScreen;
import com.neva.oycland.game.screen.MainMenuScreen;
import com.neva.oycland.game.screen.PauseScreen;
import com.neva.oycland.game.screen.SummaryScreen;

public class Progress {

    protected final OyclandGame game;

    protected final Sound btnSound;

    protected LevelScreen currentLevel;

    private int score;

    private int timeElapsed;

    private Class<? extends LevelScreen> lastLevel;

    public Progress(OyclandGame game) {
        this.game = game;

        btnSound = Gdx.audio.newSound(Gdx.files.internal("sound/thunder.mp3"));
    }

    public void startGame() {
        btnSound.play();
        game.setScreen(MainMenuScreen.class);
    }

    public void endGame() {
        if (currentLevel != null) {
            Class<? extends LevelScreen> clazz = currentLevel.getClass();
            game.getScreens().unload(clazz);
            lastLevel = clazz;
            currentLevel = null;
        }

        btnSound.play();
        game.setScreen(SummaryScreen.class);
    }

    public void togglePause() {
        btnSound.play();

        if (game.getScreen() instanceof LevelScreen) {
            currentLevel = ((LevelScreen) game.getScreen());
            game.setScreen(PauseScreen.class);
        } else if (game.getProgress().getCurrentLevel() != null) {
            game.setScreen(currentLevel);
        }
    }

    public void changeLevel(LevelScreen level) {
        this.currentLevel = level;

        score = 0;
        timeElapsed = 0;

    }

    public LevelScreen getCurrentLevel() {
        return currentLevel;
    }

    public Class<? extends LevelScreen> getLastLevel() {
        return lastLevel;
    }

    public void increaseScore(int value) {
        if (value >= 50) {
            btnSound.play();
        }

        score += value;
    }

    public int getScore() {
        return score;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void incrementTime() {
        timeElapsed++;
    }
}
