package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* compiled from: ViewCompatHC.java */
/* renamed from: android.support.v4.view.bf */
/* loaded from: classes.dex */
class C0172bf {
    /* renamed from: a */
    static long m672a() {
        return ValueAnimator.getFrameDelay();
    }

    /* renamed from: a */
    public static void m673a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    /* renamed from: a */
    public static int m671a(View view) {
        return view.getLayerType();
    }
}
