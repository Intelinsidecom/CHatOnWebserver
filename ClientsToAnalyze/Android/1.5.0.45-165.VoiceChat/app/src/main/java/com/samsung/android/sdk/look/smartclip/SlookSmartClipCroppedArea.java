package com.samsung.android.sdk.look.smartclip;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes.dex */
public interface SlookSmartClipCroppedArea {
    Rect getRect();

    boolean intersects(Rect rect);

    boolean intersects(View view);
}
