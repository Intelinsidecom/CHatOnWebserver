package android.sec.multiwindow;

import android.content.ComponentName;
import android.graphics.Point;
import android.graphics.Rect;

@Deprecated
/* loaded from: classes.dex */
public interface IMultiWindow {
    boolean finish();

    boolean finish(int i);

    boolean fitToHalf(int i);

    int getHeight();

    Point getMinimumSize();

    Rect getRect();

    Rect getRect(int i);

    int getWidth();

    boolean isMaximized();

    boolean isMaximized(int i);

    boolean isStartingSplitScreen(ComponentName componentName);

    boolean maximize();

    boolean minimize();

    boolean minimize(int i);

    boolean pinUp(boolean z);

    boolean pinUp(boolean z, int i);

    boolean relayout(Rect rect);

    boolean restore();

    boolean restore(int i);

    boolean setMinimumSize(int i, int i2);

    boolean start();
}
