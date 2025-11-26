package com.vlingo.sdk.internal.util;

import com.vlingo.sdk.internal.settings.Settings;

/* loaded from: classes.dex */
public class Screen {
    public static Screen getInstance() {
        return new Screen();
    }

    public int getWidth() {
        String defaultWidth = Integer.toString(defaultWidth());
        String setting = Settings.getPersistentString(Settings.KEY_SCREEN_WIDTH, defaultWidth);
        return Integer.valueOf(setting).intValue();
    }

    public float getMagnification() {
        String defaultMag = Float.toString(defaultMagnification());
        String setting = Settings.getPersistentString(Settings.KEY_SCREEN_MAG, defaultMag);
        return Float.valueOf(setting).floatValue();
    }

    public static int defaultWidth() {
        return 1280;
    }

    public static float defaultMagnification() {
        return 4.3f;
    }
}
