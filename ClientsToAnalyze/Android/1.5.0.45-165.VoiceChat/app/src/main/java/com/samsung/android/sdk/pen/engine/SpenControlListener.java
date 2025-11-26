package com.samsung.android.sdk.pen.engine;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface SpenControlListener {
    public static final int PRESS_TYPE_LONG_PRESS = 2;
    public static final int PRESS_TYPE_NONE = 0;
    public static final int PRESS_TYPE_TAP = 1;

    boolean onClosed(ArrayList<SpenObjectBase> arrayList);

    boolean onCreated(ArrayList<SpenObjectBase> arrayList, ArrayList<Rect> arrayList2, ArrayList<SpenContextMenuItemInfo> arrayList3, ArrayList<Integer> arrayList4, int i, PointF pointF);

    boolean onMenuSelected(ArrayList<SpenObjectBase> arrayList, int i);

    void onObjectChanged(ArrayList<SpenObjectBase> arrayList);

    void onRectChanged(RectF rectF, SpenObjectBase spenObjectBase);

    void onRotationChanged(float f, SpenObjectBase spenObjectBase);
}
