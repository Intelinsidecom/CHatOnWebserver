package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

/* compiled from: ViewCompat.java */
/* renamed from: android.support.v4.view.ax */
/* loaded from: classes.dex */
class C0163ax extends C0162aw {
    C0163ax() {
    }

    @Override // android.support.v4.view.C0160au
    /* renamed from: a */
    long mo646a() {
        return C0172bf.m672a();
    }

    @Override // android.support.v4.view.C0160au, android.support.v4.view.InterfaceC0169bc
    /* renamed from: a */
    public void mo648a(View view, int i, Paint paint) {
        C0172bf.m673a(view, i, paint);
    }

    @Override // android.support.v4.view.C0160au, android.support.v4.view.InterfaceC0169bc
    /* renamed from: d */
    public int mo656d(View view) {
        return C0172bf.m671a(view);
    }

    @Override // android.support.v4.view.C0160au, android.support.v4.view.InterfaceC0169bc
    /* renamed from: a */
    public void mo649a(View view, Paint paint) {
        mo648a(view, mo656d(view), paint);
        view.invalidate();
    }
}
