package com.neva.oycland.game;

import com.neva.oycland.game.screen.LevelScreen;
import com.neva.oycland.game.screen.MainMenuScreen;
import com.neva.oycland.game.screen.PauseScreen;

public class Progress {

    protected final OyclandGame game;

    public Progress(OyclandGame game) {
        this.game = game;
    }

    protected LevelScreen currentLevel;

    public void endGame() {
        if (currentLevel != null) {
            game.getScreens().unload(currentLevel.getClass());
            currentLevel = null;
        }

        game.setScreen(MainMenuScreen.class);
    }

    public void togglePause() {
        if (game.getScreen() instanceof LevelScreen) {
            currentLevel = ((LevelScreen) game.getScreen());
            game.setScreen(PauseScreen.class);
        } else if (game.getProgress().getCurrentLevel() != null) {
            game.setScreen(currentLevel);
        }
    }

    public void setCurrentLevel(LevelScreen currentLevel) {
        this.currentLevel = currentLevel;
    }

    public LevelScreen getCurrentLevel() {
        return currentLevel;
    }
}
