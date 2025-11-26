package com.sec.common.p056b.p058b;

import com.sec.common.p056b.C1825d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: SoftCacheLoader.java */
/* renamed from: com.sec.common.b.b.b */
/* loaded from: classes.dex */
public class C1818b implements InterfaceC1817a {

    /* renamed from: b */
    private static final String f6513b = C1818b.class.getSimpleName();

    /* renamed from: a */
    protected Map f6514a = new HashMap();

    @Override // com.sec.common.p056b.p058b.InterfaceC1817a
    /* renamed from: a */
    public synchronized Object mo6165a(Object obj) {
        Object obj2;
        obj2 = null;
        if (this.f6514a.containsKey(obj) && (obj2 = ((SoftReference) this.f6514a.get(obj)).get()) == null) {
            if (C1825d.f6539a.f6541b) {
                C1825d.f6539a.m6200a(f6513b, "Cached reference is deleted.");
            }
            this.f6514a.remove(obj);
        }
        return obj2;
    }

    @Override // com.sec.common.p056b.p058b.InterfaceC1817a
    /* renamed from: a */
    public synchronized void mo6167a(Object obj, Object obj2) {
        if (obj2 != null) {
            this.f6514a.put(obj, new SoftReference(obj2));
        }
    }

    @Override // com.sec.common.p056b.p058b.InterfaceC1817a
    /* renamed from: a */
    public synchronized void mo6166a() {
        if (C1825d.f6539a.f6541b) {
            C1825d.f6539a.m6200a(f6513b, "Clear cached data.");
        }
        Iterator it = this.f6514a.keySet().iterator();
        while (it.hasNext()) {
        }
        Iterator it2 = this.f6514a.values().iterator();
        while (it2.hasNext()) {
            ((SoftReference) it2.next()).clear();
        }
        this.f6514a.clear();
    }
}
