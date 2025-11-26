package android.support.v4.app;

import android.view.View;

/* compiled from: Fragment.java */
/* renamed from: android.support.v4.app.o */
/* loaded from: classes.dex */
class C0061o implements InterfaceC0068v {

    /* renamed from: a */
    final /* synthetic */ Fragment f198a;

    C0061o(Fragment fragment) {
        this.f198a = fragment;
    }

    @Override // android.support.v4.app.InterfaceC0068v
    /* renamed from: a */
    public View mo176a(int i) {
        if (this.f198a.mView == null) {
            throw new IllegalStateException("Fragment does not have a view");
        }
        return this.f198a.mView.findViewById(i);
    }
}
