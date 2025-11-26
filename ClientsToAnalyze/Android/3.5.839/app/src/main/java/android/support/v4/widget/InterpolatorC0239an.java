package android.support.v4.widget;

import android.view.animation.Interpolator;

/* compiled from: ViewDragHelper.java */
/* renamed from: android.support.v4.widget.an */
/* loaded from: classes.dex */
final class InterpolatorC0239an implements Interpolator {
    InterpolatorC0239an() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
