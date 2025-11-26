package com.samsung.android.sdk.cover;

/* loaded from: classes.dex */
public class ScoverState {
    public static final int COLOR_BEIGE = 17;

    @Deprecated
    public static final int COLOR_BLACK = 1;
    public static final int COLOR_BLUSH_PINK = 3;
    public static final int COLOR_CARBON_METAL = 9;

    @Deprecated
    public static final int COLOR_CHARCOAL_GRAY = 10;
    public static final int COLOR_CLASSIC_WHITE = 2;
    public static final int COLOR_DARK_BLUE = 14;
    public static final int COLOR_DEFAULT = 0;

    @Deprecated
    public static final int COLOR_GRAYISH_BLUE = 8;
    public static final int COLOR_INDIGO_BLUE = 6;
    public static final int COLOR_JET_BLACK = 1;
    public static final int COLOR_LAVENDER = 16;

    @Deprecated
    public static final int COLOR_MAGENTA = 7;
    public static final int COLOR_MINT = 15;
    public static final int COLOR_MINT_BLUE = 8;

    @Deprecated
    public static final int COLOR_MUSTARD_YELLOW = 9;

    @Deprecated
    public static final int COLOR_OATMEAL = 5;
    public static final int COLOR_OATMEAL_BEIGE = 5;

    @Deprecated
    public static final int COLOR_ORANGE = 4;
    public static final int COLOR_PEAKCOK_GREEN = 10;
    public static final int COLOR_PEARL_OATMEAL = 18;
    public static final int COLOR_PEARL_WHITE = 13;
    public static final int COLOR_PLUM_RED = 7;
    public static final int COLOR_SILVER = 12;

    @Deprecated
    public static final int COLOR_SOFT_PINK = 3;

    @Deprecated
    public static final int COLOR_WHITE = 2;
    public static final int COLOR_WILD_ORANGE = 4;
    public static final int COLOR_WINE_RED = 11;
    public static final boolean SWITCH_STATE_COVER_CLOSE = false;
    public static final boolean SWITCH_STATE_COVER_OPEN = true;
    private static final String TAG = "ScoverState";
    public static final int TYPE_FLIP_COVER = 0;
    public static final int TYPE_HEALTH_COVER = 4;
    public static final int TYPE_MINI_SVIEW_COVER = 5;
    public static final int TYPE_NONE = 2;
    public static final int TYPE_SVIEW_CHARGER_COVER = 3;
    public static final int TYPE_SVIEW_COVER = 1;
    public int color;
    private int heightPixel;
    private boolean switchState;
    public int type;
    private int widthPixel;

    public ScoverState() {
        this.switchState = true;
        this.type = 2;
        this.color = 0;
        this.widthPixel = 0;
        this.heightPixel = 0;
    }

    public ScoverState(boolean z, int i, int i2, int i3, int i4) {
        this.switchState = z;
        this.type = i;
        this.color = i2;
        this.widthPixel = i3;
        this.heightPixel = i4;
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
