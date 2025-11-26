package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SpenTextMeasure {
    float mDiffY;
    float mHeight;
    float mMinimumHeight;
    private SpenObjectTextBox mObjectText = null;
    private final int mNativeTextView = native_init();

    private static native ArrayList<Object> native_command(int i, int i2, ArrayList<Object> arrayList, int i3);

    private static native boolean native_construct(int i, Context context);

    private static native void native_finalize(int i);

    private static native int native_getHeight(int i);

    private static native int native_getLineCount(int i);

    private static native int native_getLineEndIndex(int i, int i2);

    private static native boolean native_getLinePosition(int i, int i2, PointF pointF);

    private static native int native_getLineStartIndex(int i, int i2);

    private static native boolean native_getTextRect(int i, int i2, RectF rectF);

    private static native int native_init();

    private static native boolean native_measure(int i, int i2);

    private static native boolean native_setObjectText(int i, SpenObjectTextBox spenObjectTextBox);

    public SpenTextMeasure() {
        native_construct(this.mNativeTextView, null);
    }

    public boolean setObjectText(SpenObjectTextBox objectText) {
        this.mObjectText = objectText;
        if (!native_setObjectText(this.mNativeTextView, this.mObjectText)) {
            return false;
        }
        RectF objectRect = objectText.getRect();
        if (!native_measure(this.mNativeTextView, (int) objectRect.width())) {
            return false;
        }
        int gravity = objectText.getGravity();
        this.mDiffY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mHeight = objectRect.height();
        this.mMinimumHeight = native_getHeight(this.mNativeTextView);
        if (gravity == 1 || gravity == 2) {
            this.mDiffY = this.mHeight - this.mMinimumHeight;
            if (gravity == 1) {
                this.mDiffY /= 2.0f;
            }
        }
        return true;
    }

    public int getHeight() {
        return (int) this.mHeight;
    }

    public int getMinHeight() {
        return (int) Math.ceil(this.mMinimumHeight);
    }

    public int getLineCount() {
        return native_getLineCount(this.mNativeTextView);
    }

    public PointF getLinePosition(int lineNumber) {
        PointF result = new PointF();
        if (!native_getLinePosition(this.mNativeTextView, lineNumber, result)) {
            return null;
        }
        result.offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mDiffY);
        return result;
    }

    public RectF getTextRect(int textIndex) {
        RectF result = new RectF();
        if (!native_getTextRect(this.mNativeTextView, textIndex, result)) {
            return null;
        }
        result.offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mDiffY);
        return result;
    }

    public int getLineStartIndex(int lineNumber) {
        return native_getLineStartIndex(this.mNativeTextView, lineNumber);
    }

    public int getLineEndIndex(int lineNumber) {
        return native_getLineEndIndex(this.mNativeTextView, lineNumber);
    }

    protected void finalize() throws Throwable {
        try {
            native_finalize(this.mNativeTextView);
        } finally {
            super.finalize();
        }
    }
}
