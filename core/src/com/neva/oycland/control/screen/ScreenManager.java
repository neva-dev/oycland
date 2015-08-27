package com.neva.oycland.control.screen;

import com.badlogic.gdx.Screen;

import java.util.HashMap;
import java.util.Map;

public class ScreenManager {

    private Map<String, Screen> screens = new HashMap<String, Screen>();

    public Screen byName(String name) {
        if (!screens.containsKey(name)) {
            throw new IndexOutOfBoundsException(String.format("Screen '%s' does not exist.", name));
        }

        return screens.get(name);
    }

}
