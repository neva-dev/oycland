package com.neva.oycland.core.control.screen;

import com.google.common.collect.Maps;
import com.neva.oycland.core.control.AbstractGame;

import java.util.Map;

public class ScreenManager {

    private final Class<? extends AbstractGame> gameClass;
    private Map<Class<? extends AbstractScreen>, AbstractScreen> screens = Maps.newLinkedHashMap();

    public ScreenManager(Class<? extends AbstractGame> gameClass) {
        this.gameClass = gameClass;
    }

    public void unload(Class<? extends AbstractScreen> clazz) {
        screens.remove(clazz);
    }

    public AbstractScreen load(AbstractGame game, Class<? extends AbstractScreen> clazz) {
        if (!screens.containsKey(clazz)) {
            try {
                AbstractScreen screen = clazz.getConstructor(gameClass).newInstance(game);
                screens.put(clazz, screen);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(String.format("Cannot create a screen: '%s'", clazz.getSimpleName()), e);
            }
        }

        return screens.get(clazz);
    }
}
