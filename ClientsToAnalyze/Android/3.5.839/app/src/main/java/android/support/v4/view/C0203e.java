package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p009a.C0124k;
import android.view.View;

/* compiled from: AccessibilityDelegateCompat.java */
/* renamed from: android.support.v4.view.e */
/* loaded from: classes.dex */
class C0203e extends C0166b {
    C0203e() {
    }

    @Override // android.support.v4.view.C0166b, android.support.v4.view.C0205g, android.support.v4.view.InterfaceC0202d
    /* renamed from: a */
    public Object mo661a(C0109a c0109a) {
        return C0209k.m723a(new C0204f(this, c0109a));
    }

    @Override // android.support.v4.view.C0205g, android.support.v4.view.InterfaceC0202d
    /* renamed from: a */
    public C0124k mo703a(Object obj, View view) {
        Object objM724a = C0209k.m724a(obj, view);
        if (objM724a != null) {
            return new C0124k(objM724a);
        }
        return null;
    }

    @Override // android.support.v4.view.C0205g, android.support.v4.view.InterfaceC0202d
    /* renamed from: a */
    public boolean mo704a(Object obj, View view, int i, Bundle bundle) {
        return C0209k.m725a(obj, view, i, bundle);
    }
}
