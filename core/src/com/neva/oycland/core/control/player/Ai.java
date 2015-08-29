package com.neva.oycland.core.control.player;

import java.util.Random;

public class Ai implements Controller {

    private float stateTime = 0;

    private Command currentCommand = Command.IDLE;

    @Override
    public synchronized Command control(float delta) {
        stateTime += delta;
        if (stateTime >= getIntervalTime()) {
            currentCommand = getRandomCommand();
            stateTime = 0;
        }

        return currentCommand;
    }

    private Command getRandomCommand() {
        int index = new Random().nextInt(4);
        switch (index) {
            case 0:
                return Command.MOVE_LEFT;
            case 1:
                return Command.MOVE_RIGHT;
            case 2:
                return Command.MOVE_DOWN;
            case 3:
                return Command.MOVE_UP;
        }

        return Command.IDLE;
    }

    public float getIntervalTime() {
        return 2 + new Random().nextInt(4);
    }
}
