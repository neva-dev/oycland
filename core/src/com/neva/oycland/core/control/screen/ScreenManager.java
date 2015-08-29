package com.neva.oycland.core.control.screen;

import com.google.common.collect.Maps;
import com.neva.oycland.core.control.AbstractGame;

import java.util.Map;

public class ScreenManager {

    private Map<Class<? extends AbstractScreen>, AbstractScreen> screens = Maps.newLinkedHashMap();

    public AbstractScreen load(AbstractGame game, Class<? extends AbstractScreen> clazz, boolean restart) {
        if (restart || !screens.containsKey(clazz)) {
            try {
                AbstractScreen screen = clazz.getConstructor(AbstractGame.class).newInstance(game);
                screens.put(clazz, screen);
            } catch (ReflectiveOperationException e) {
                throw new UnsupportedOperationException(String.format("Cannot instantiate screen: '%s'", clazz.getSimpleName()));
            }
        }

        return screens.get(clazz);
    }
}
