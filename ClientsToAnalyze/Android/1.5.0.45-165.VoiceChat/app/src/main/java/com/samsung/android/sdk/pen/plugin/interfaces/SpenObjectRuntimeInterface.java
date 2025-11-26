package com.samsung.android.sdk.pen.plugin.interfaces;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public interface SpenObjectRuntimeInterface extends SpenPluginInterface {
    public static final int CANCEL_STATE_INSERT = 0;
    public static final int CANCEL_STATE_RUN = 1;
    public static final int TYPE_CONTAINER = 3;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_STROKE = 2;

    public interface UpdateListener {
        void onCanceled(int i, Object obj);

        void onCompleted(Object obj);

        void onObjectUpdated(RectF rectF, Object obj);
    }

    int getType();

    void onTouchEvent(MotionEvent motionEvent);

    boolean setListener(UpdateListener updateListener);

    void setRect(RectF rectF);

    void start(Object obj, RectF rectF, PointF pointF, float f, PointF pointF2, ViewGroup viewGroup);

    void stop(boolean z);
}
