package android.support.v4.view;

import android.view.animation.Interpolator;

/* compiled from: ViewPager.java */
/* renamed from: android.support.v4.view.bw */
/* loaded from: classes.dex */
final class InterpolatorC0189bw implements Interpolator {
    InterpolatorC0189bw() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
