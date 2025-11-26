package com.sec.chaton.widget;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* compiled from: DynamicListView.java */
/* renamed from: com.sec.chaton.widget.g */
/* loaded from: classes.dex */
final class C4914g implements TypeEvaluator<Rect> {
    C4914g() {
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        return new Rect(m18712a(rect.left, rect2.left, f), m18712a(rect.top, rect2.top, f), m18712a(rect.right, rect2.right, f), m18712a(rect.bottom, rect2.bottom, f));
    }

    /* renamed from: a */
    public int m18712a(int i, int i2, float f) {
        return (int) (i + ((i2 - i) * f));
    }
}
