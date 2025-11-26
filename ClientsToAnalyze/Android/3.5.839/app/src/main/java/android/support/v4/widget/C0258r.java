package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

/* compiled from: EdgeEffectCompatIcs.java */
/* renamed from: android.support.v4.widget.r */
/* loaded from: classes.dex */
class C0258r {
    /* renamed from: a */
    public static Object m904a(Context context) {
        return new EdgeEffect(context);
    }

    /* renamed from: a */
    public static void m905a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    /* renamed from: a */
    public static boolean m906a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    /* renamed from: b */
    public static void m909b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    /* renamed from: a */
    public static boolean m907a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    /* renamed from: c */
    public static boolean m910c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    /* renamed from: a */
    public static boolean m908a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}
