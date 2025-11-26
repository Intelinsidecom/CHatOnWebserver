package com.samsung.android.sdk.pen.engine;

import com.samsung.android.sdk.pen.document.SpenObjectContainer;

/* loaded from: classes.dex */
public interface SpenStrokeFrameListener {
    public static final int CANCEL_CAUSE_ERROR = 32;
    public static final int CANCEL_CAUSE_FAILED_TO_RECOGNIZE = 8;
    public static final int CANCEL_CAUSE_OUT_OF_VIEW = 16;
    public static final int CANCEL_CAUSE_TOO_SMALL = 4;
    public static final int CANCEL_STATE_RETAKE = 2;
    public static final int CANCEL_STATE_TAKE = 1;
    public static final int FRAMETYPE_BEAUTIFY = 1;
    public static final int FRAMETYPE_ORIGINAL = 0;

    void onCanceled(int i, SpenObjectContainer spenObjectContainer);

    void onCompleted(int i, SpenObjectContainer spenObjectContainer);
}
