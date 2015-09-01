package com.neva.oycland.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.neva.oycland.game.screen.LevelScreen;
import com.neva.oycland.game.screen.MainMenuScreen;
import com.neva.oycland.game.screen.PauseScreen;

public class Progress {

    protected final OyclandGame game;

    protected final Sound btnSound;

    protected LevelScreen currentLevel;

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
            game.getScreens().unload(currentLevel.getClass());
            currentLevel = null;
        }

        btnSound.play();
        game.setScreen(MainMenuScreen.class);
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

    public LevelScreen getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(LevelScreen currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void increaseScore(int value) {

    }
}
