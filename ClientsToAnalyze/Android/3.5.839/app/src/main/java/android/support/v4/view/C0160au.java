package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewCompat.java */
/* renamed from: android.support.v4.view.au */
/* loaded from: classes.dex */
class C0160au implements InterfaceC0169bc {
    C0160au() {
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: a */
    public boolean mo652a(View view, int i) {
        return false;
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: a */
    public int mo645a(View view) {
        return 2;
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: a */
    public void mo650a(View view, C0109a c0109a) {
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: b */
    public void mo653b(View view) {
        view.postInvalidateDelayed(mo646a());
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: a */
    public void mo647a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidateDelayed(mo646a(), i, i2, i3, i4);
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: a */
    public void mo651a(View view, Runnable runnable) {
        view.postDelayed(runnable, mo646a());
    }

    /* renamed from: a */
    long mo646a() {
        return 10L;
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: c */
    public int mo655c(View view) {
        return 0;
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: b */
    public void mo654b(View view, int i) {
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: a */
    public void mo648a(View view, int i, Paint paint) {
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: d */
    public int mo656d(View view) {
        return 0;
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: a */
    public void mo649a(View view, Paint paint) {
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: e */
    public int mo657e(View view) {
        return 0;
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: f */
    public ViewParent mo658f(View view) {
        return view.getParent();
    }

    @Override // android.support.v4.view.InterfaceC0169bc
    /* renamed from: g */
    public boolean mo659g(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }
}
