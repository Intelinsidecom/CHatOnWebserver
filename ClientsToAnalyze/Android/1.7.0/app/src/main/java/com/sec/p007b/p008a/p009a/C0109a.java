package com.sec.p007b.p008a.p009a;

import com.sec.p007b.p008a.C0111b;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: SoftCacheLoader.java */
/* renamed from: com.sec.b.a.a.a */
/* loaded from: classes.dex */
public class C0109a implements InterfaceC0110b {

    /* renamed from: b */
    private static final String f206b = C0109a.class.getSimpleName();

    /* renamed from: a */
    protected Map f207a = new HashMap();

    @Override // com.sec.p007b.p008a.p009a.InterfaceC0110b
    /* renamed from: a */
    public synchronized Object mo579a(Object obj) {
        Object obj2;
        obj2 = null;
        if (this.f207a.containsKey(obj) && (obj2 = ((SoftReference) this.f207a.get(obj)).get()) == null) {
            if (C0111b.f208a.f210b) {
                C0111b.f208a.m585c(f206b, "Cached reference is deleted.");
            }
            this.f207a.remove(obj);
        }
        return obj2;
    }

    @Override // com.sec.p007b.p008a.p009a.InterfaceC0110b
    /* renamed from: a */
    public synchronized void mo581a(Object obj, Object obj2) {
        if (obj2 != null) {
            this.f207a.put(obj, new SoftReference(obj2));
        }
    }

    @Override // com.sec.p007b.p008a.p009a.InterfaceC0110b
    /* renamed from: a */
    public synchronized void mo580a() {
        if (C0111b.f208a.f210b) {
            C0111b.f208a.m585c(f206b, "Clear cached data.");
        }
        Iterator it = this.f207a.keySet().iterator();
        while (it.hasNext()) {
        }
        Iterator it2 = this.f207a.values().iterator();
        while (it2.hasNext()) {
            ((SoftReference) it2.next()).clear();
        }
        this.f207a.clear();
    }
}
