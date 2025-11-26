package android.support.v4.view.p009a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat.java */
/* renamed from: android.support.v4.view.a.p */
/* loaded from: classes.dex */
class C0129p implements InterfaceC0136w {

    /* renamed from: a */
    final /* synthetic */ C0124k f455a;

    /* renamed from: b */
    final /* synthetic */ C0128o f456b;

    C0129p(C0128o c0128o, C0124k c0124k) {
        this.f456b = c0128o;
        this.f455a = c0124k;
    }

    @Override // android.support.v4.view.p009a.InterfaceC0136w
    /* renamed from: a */
    public boolean mo589a(int i, int i2, Bundle bundle) {
        return this.f455a.m582a(i, i2, bundle);
    }

    @Override // android.support.v4.view.p009a.InterfaceC0136w
    /* renamed from: a */
    public List<Object> mo588a(String str, int i) {
        List<C0110a> listM581a = this.f455a.m581a(str, i);
        ArrayList arrayList = new ArrayList();
        int size = listM581a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(listM581a.get(i2).m443a());
        }
        return arrayList;
    }

    @Override // android.support.v4.view.p009a.InterfaceC0136w
    /* renamed from: a */
    public Object mo587a(int i) {
        C0110a c0110aM579a = this.f455a.m579a(i);
        if (c0110aM579a == null) {
            return null;
        }
        return c0110aM579a.m443a();
    }
}
