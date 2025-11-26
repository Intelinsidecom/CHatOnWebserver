package com.samsung.android.sdk.pen.engine;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface;

/* loaded from: classes.dex */
public class SpenObjectRuntime {
    private static boolean mGlobalObjectRuntimeStart;
    private final SpenObjectRuntimeInterface mObjectRuntimeObject;
    private boolean mThisObjectRuntimeStart;
    private UpdateListener mUpdateListener;

    public interface UpdateListener {
        void onCanceled(int i, Object obj);

        void onCompleted(Object obj);

        void onObjectUpdated(RectF rectF, Object obj);
    }

    SpenObjectRuntime(SpenObjectRuntimeInterface objectRuntimeObject) {
        if (objectRuntimeObject == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'objectRuntimeObject' is null");
        }
        this.mObjectRuntimeObject = objectRuntimeObject;
    }

    SpenObjectRuntimeInterface getObjectRuntimeObject() {
        return this.mObjectRuntimeObject;
    }

    public int getType() {
        return this.mObjectRuntimeObject.getType();
    }

    public void start(Object objectBase, RectF relativeRect, PointF pan, float zoomRatio, PointF frameStartPosition, ViewGroup layout) {
        if (mGlobalObjectRuntimeStart) {
            Log.v("SpenObjectRuntime", "SpenObjectRuntime was already started");
            return;
        }
        mGlobalObjectRuntimeStart = true;
        this.mThisObjectRuntimeStart = true;
        this.mObjectRuntimeObject.start(objectBase, relativeRect, pan, zoomRatio, frameStartPosition, layout);
    }

    public void stop(boolean cancel) {
        if (mGlobalObjectRuntimeStart && this.mThisObjectRuntimeStart) {
            mGlobalObjectRuntimeStart = false;
            this.mThisObjectRuntimeStart = false;
        }
        this.mObjectRuntimeObject.stop(cancel);
    }

    public void onTouchEvent(MotionEvent event) {
        this.mObjectRuntimeObject.onTouchEvent(event);
    }

    public void setRect(RectF rect) {
        this.mObjectRuntimeObject.setRect(rect);
    }

    public boolean setListener(UpdateListener listener) {
        this.mUpdateListener = listener;
        if (this.mUpdateListener != null) {
            this.mObjectRuntimeObject.setListener(new SpenObjectRuntimeInterface.UpdateListener() { // from class: com.samsung.android.sdk.pen.engine.SpenObjectRuntime.1
                @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface.UpdateListener
                public void onObjectUpdated(RectF rect, Object objectBase) {
                    SpenObjectRuntime.this.mUpdateListener.onObjectUpdated(rect, objectBase);
                }

                @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface.UpdateListener
                public void onCanceled(int state, Object objectBase) {
                    SpenObjectRuntime.this.mUpdateListener.onCanceled(state, objectBase);
                    SpenObjectRuntime.mGlobalObjectRuntimeStart = false;
                    SpenObjectRuntime.this.mThisObjectRuntimeStart = false;
                }

                @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface.UpdateListener
                public void onCompleted(Object objectBase) {
                    SpenObjectRuntime.this.mUpdateListener.onCompleted(objectBase);
                    SpenObjectRuntime.mGlobalObjectRuntimeStart = false;
                    SpenObjectRuntime.this.mThisObjectRuntimeStart = false;
                }
            });
            return true;
        }
        this.mObjectRuntimeObject.setListener(null);
        return true;
    }
}
