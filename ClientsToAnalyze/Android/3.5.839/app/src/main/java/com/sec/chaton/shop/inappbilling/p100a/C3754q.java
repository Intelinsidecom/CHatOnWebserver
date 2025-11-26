package com.sec.chaton.shop.inappbilling.p100a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Inventory.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a.q */
/* loaded from: classes.dex */
public class C3754q {

    /* renamed from: a */
    Map<String, C3755r> f13475a = new HashMap();

    /* renamed from: b */
    Map<String, C3756s> f13476b = new HashMap();

    C3754q() {
    }

    /* renamed from: a */
    public C3756s m14132a(String str) {
        return this.f13476b.get(str);
    }

    /* renamed from: b */
    List<String> m14135b(String str) {
        ArrayList arrayList = new ArrayList();
        for (C3756s c3756s : this.f13476b.values()) {
            if (c3756s.m14137a().equals(str)) {
                arrayList.add(c3756s.m14138b());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    void m14133a(C3755r c3755r) {
        this.f13475a.put(c3755r.m14136a(), c3755r);
    }

    /* renamed from: a */
    void m14134a(C3756s c3756s) {
        this.f13476b.put(c3756s.m14138b(), c3756s);
    }
}
