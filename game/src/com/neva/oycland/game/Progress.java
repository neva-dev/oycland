package com.neva.oycland.game;

import com.neva.oycland.game.screen.LevelScreen;

public class Progress {

    protected LevelScreen currentLevel;

    public LevelScreen getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(LevelScreen currentLevel) {
        this.currentLevel = currentLevel;
    }
}
