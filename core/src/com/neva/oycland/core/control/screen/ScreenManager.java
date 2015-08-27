package com.neva.oycland.core.control.screen;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

import java.util.Map;

public class ScreenManager {

    private Map<String, AbstractScreen> screens = Maps.newLinkedHashMap();

    public void register(AbstractScreen screen) {
        screens.put(screen.getName(), screen);
    }

    public AbstractScreen byName(String name) {
        if (!screens.containsKey(name)) {
            throw new IndexOutOfBoundsException(String.format("Screen '%s' does not exist.", name));
        }

        return screens.get(name);
    }

    public AbstractScreen getFirst() {
        if (screens.isEmpty()) {
            throw new IndexOutOfBoundsException("At least one startup screen should be added to manager.");
        }

        return Iterables.getFirst(screens.values(), null);
    }
}
