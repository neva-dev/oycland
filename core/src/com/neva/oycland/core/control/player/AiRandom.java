package com.neva.oycland.core.control.player;

import com.neva.oycland.core.control.Command;
import com.neva.oycland.core.control.Controller;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

public class AiRandom implements Controller {

    private float stateTime = 0;

    private Command currentCommand = Command.IDLE;

    @Override
    public synchronized Command control(float delta) {
        stateTime += delta;
        if (stateTime == 0 || stateTime >= getIntervalTime()) {
            currentCommand = getRandomCommand();
            stateTime = 0;
        }

        return currentCommand;
    }

    private Command getRandomCommand() {
        int index = RandomUtils.nextInt(0, 8);

        switch (index) {
            case 0:
                return Command.MOVE_LEFT;
            case 1:
                return Command.MOVE_RIGHT;
            case 2:
                return Command.MOVE_DOWN;
            case 3:
                return Command.MOVE_UP;
            case 4:
                return Command.MOVE_DOWN_LEFT;
            case 5:
                return Command.MOVE_DOWN_RIGHT;
            case 6:
                return Command.MOVE_UP_LEFT;
            case 7:
                return Command.MOVE_UP_RIGHT;
        }

        return Command.IDLE;
    }

    public float getIntervalTime() {
        return 2 + new Random().nextInt(4);
    }
}
