package com.samsung.android.sdk.pen.engine;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes.dex */
interface SpenPageEffectHandler {
    public static final int PAGE_DIRECTION_LEFT = 0;
    public static final int PAGE_DIRECTION_RIGHT = 1;

    public interface Listener {
        void onFinish();

        void onUpdate();

        void onUpdateCanvasLayer(Canvas canvas);

        void onUpdateCanvasLayer2(Canvas canvas);
    }

    void close();

    void drawAnimation(Canvas canvas);

    boolean isWorking();

    boolean saveScreenshot();

    void setCanvasInformation(int i, int i2, int i3, int i4);

    void setPaint(Paint paint);

    void setScreenResolution(int i, int i2);

    boolean startAnimation(int i);
}
