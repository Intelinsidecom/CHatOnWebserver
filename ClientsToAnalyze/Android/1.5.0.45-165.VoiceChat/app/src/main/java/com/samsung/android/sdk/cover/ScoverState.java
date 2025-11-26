package com.samsung.android.sdk.cover;

/* loaded from: classes.dex */
public class ScoverState {
    public static final int COLOR_BLACK = 1;
    public static final int COLOR_CHARCOAL_GRAY = 10;
    public static final int COLOR_DEFAULT = 0;
    public static final int COLOR_GRAYISH_BLUE = 8;
    public static final int COLOR_INDIGO_BLUE = 6;
    public static final int COLOR_MAGENTA = 7;
    public static final int COLOR_MUSTARD_YELLOW = 9;
    public static final int COLOR_ORANGE = 4;
    public static final int COLOR_OTMIL = 5;
    public static final int COLOR_SOFT_PINK = 3;
    public static final int COLOR_WHITE = 2;
    public static final boolean SWITCH_STATE_COVER_CLOSE = false;
    public static final boolean SWITCH_STATE_COVER_OPEN = true;
    private static final String TAG = "ScoverState";
    public static final int TYPE_FLIP_COVER = 0;
    public static final int TYPE_NONE = 2;
    public static final int TYPE_SVIEW_CHARGER_COVER = 3;
    public static final int TYPE_SVIEW_COVER = 1;
    private int color;
    private int heightPixel;
    private boolean switchState;
    private int type;
    private int widthPixel;

    public ScoverState() {
        this.switchState = true;
        this.type = 2;
        this.color = 0;
        this.widthPixel = 0;
        this.heightPixel = 0;
    }

    public ScoverState(boolean switchState, int type, int color, int widthPixel, int heightPixel) {
        this.switchState = switchState;
        this.type = type;
        this.color = color;
        this.widthPixel = widthPixel;
        this.heightPixel = heightPixel;
    }

    public boolean getSwitchState() {
        return this.switchState;
    }

    public int getType() {
        return this.type;
    }

    public int getColor() {
        return this.color;
    }

    public int getWindowWidth() {
        return this.widthPixel;
    }

    public int getWindowHeight() {
        return this.heightPixel;
    }

    public String toString() {
        return String.format("ScoverState(switchState=%b type=%d color=%d widthPixel=%d heightPixel=%d)", Boolean.valueOf(this.switchState), Integer.valueOf(this.type), Integer.valueOf(this.color), Integer.valueOf(this.widthPixel), Integer.valueOf(this.heightPixel));
    }
}
