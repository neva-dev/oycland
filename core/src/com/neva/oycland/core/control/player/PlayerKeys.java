package com.neva.oycland.core.control.player;

import java.util.HashMap;

public class PlayerKeys extends HashMap<Integer, Boolean> {

    public boolean isPressed(Integer keyCode) {
        return containsKey(keyCode) && get(keyCode);
    }

}
