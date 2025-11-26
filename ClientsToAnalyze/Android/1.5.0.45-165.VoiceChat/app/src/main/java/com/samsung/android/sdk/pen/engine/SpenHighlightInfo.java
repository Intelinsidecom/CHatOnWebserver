package com.samsung.android.sdk.pen.engine;

import android.graphics.RectF;

/* loaded from: classes.dex */
public class SpenHighlightInfo {
    public int color;
    public RectF rect;
    public float size;

    public SpenHighlightInfo(RectF rect, float size, int color) {
        this.rect = rect;
        this.size = size;
        this.color = color;
    }
}
