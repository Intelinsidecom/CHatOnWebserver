package android.support.v4.view.p009a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat.java */
/* renamed from: android.support.v4.view.a.n */
/* loaded from: classes.dex */
class C0127n implements InterfaceC0133t {

    /* renamed from: a */
    final /* synthetic */ C0124k f453a;

    /* renamed from: b */
    final /* synthetic */ C0126m f454b;

    C0127n(C0126m c0126m, C0124k c0124k) {
        this.f454b = c0126m;
        this.f453a = c0124k;
    }

    @Override // android.support.v4.view.p009a.InterfaceC0133t
    /* renamed from: a */
    public boolean mo586a(int i, int i2, Bundle bundle) {
        return this.f453a.m582a(i, i2, bundle);
    }

    @Override // android.support.v4.view.p009a.InterfaceC0133t
    /* renamed from: a */
    public List<Object> mo585a(String str, int i) {
        List<C0110a> listM581a = this.f453a.m581a(str, i);
        ArrayList arrayList = new ArrayList();
        int size = listM581a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(listM581a.get(i2).m443a());
        }
        return arrayList;
    }

    @Override // android.support.v4.view.p009a.InterfaceC0133t
    /* renamed from: a */
    public Object mo584a(int i) {
        C0110a c0110aM579a = this.f453a.m579a(i);
        if (c0110aM579a == null) {
            return null;
        }
        return c0110aM579a.m443a();
    }
}
