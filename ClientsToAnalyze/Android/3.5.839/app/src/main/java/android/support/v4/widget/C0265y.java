package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: ScrollerCompatGingerbread.java */
/* renamed from: android.support.v4.widget.y */
/* loaded from: classes.dex */
class C0265y {
    /* renamed from: a */
    public static Object m929a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    /* renamed from: a */
    public static boolean m931a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    /* renamed from: b */
    public static int m932b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    /* renamed from: c */
    public static int m933c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    /* renamed from: d */
    public static boolean m934d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    /* renamed from: a */
    public static void m930a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    /* renamed from: e */
    public static void m935e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    /* renamed from: f */
    public static int m936f(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    /* renamed from: g */
    public static int m937g(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
