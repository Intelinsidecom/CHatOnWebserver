package com.sec.chaton.smsplugin.p104d.p106b;

import java.util.ArrayList;
import org.p146b.p147a.p149b.InterfaceC5256p;
import org.p146b.p147a.p149b.InterfaceC5257q;

/* compiled from: TimeListImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.w */
/* loaded from: classes.dex */
public class C3842w implements InterfaceC5257q {

    /* renamed from: a */
    private final ArrayList<InterfaceC5256p> f13737a;

    C3842w(ArrayList<InterfaceC5256p> arrayList) {
        this.f13737a = arrayList;
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5257q
    /* renamed from: a */
    public int mo14613a() {
        return this.f13737a.size();
    }

    @Override // org.p146b.p147a.p149b.InterfaceC5257q
    /* renamed from: a */
    public InterfaceC5256p mo14614a(int i) {
        try {
            return this.f13737a.get(i);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
