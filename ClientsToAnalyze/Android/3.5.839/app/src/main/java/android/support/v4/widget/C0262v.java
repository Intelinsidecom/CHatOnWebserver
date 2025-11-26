package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: ScrollerCompat.java */
/* renamed from: android.support.v4.widget.v */
/* loaded from: classes.dex */
class C0262v implements InterfaceC0261u {
    C0262v() {
    }

    @Override // android.support.v4.widget.InterfaceC0261u
    /* renamed from: a */
    public Object mo920a(Context context, Interpolator interpolator) {
        return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
    }

    @Override // android.support.v4.widget.InterfaceC0261u
    /* renamed from: a */
    public boolean mo922a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    @Override // android.support.v4.widget.InterfaceC0261u
    /* renamed from: b */
    public int mo923b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    @Override // android.support.v4.widget.InterfaceC0261u
    /* renamed from: c */
    public int mo924c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    @Override // android.support.v4.widget.InterfaceC0261u
    /* renamed from: d */
    public boolean mo925d(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    @Override // android.support.v4.widget.InterfaceC0261u
    /* renamed from: a */
    public void mo921a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    @Override // android.support.v4.widget.InterfaceC0261u
    /* renamed from: e */
    public void mo926e(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    @Override // android.support.v4.widget.InterfaceC0261u
    /* renamed from: f */
    public int mo927f(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    @Override // android.support.v4.widget.InterfaceC0261u
    /* renamed from: g */
    public int mo928g(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
