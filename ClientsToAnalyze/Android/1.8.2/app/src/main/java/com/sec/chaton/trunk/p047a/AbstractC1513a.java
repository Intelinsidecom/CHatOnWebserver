package com.sec.chaton.trunk.p047a;

import com.sec.chaton.util.C1786r;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AbstractSoftCacheLoader.java */
/* renamed from: com.sec.chaton.trunk.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1513a {

    /* renamed from: b */
    private static final String f5541b = AbstractC1513a.class.getSimpleName();

    /* renamed from: a */
    protected Map f5542a = new HashMap();

    /* renamed from: a */
    public synchronized Object m5363a(Object obj) {
        Object obj2;
        obj2 = null;
        if (this.f5542a.containsKey(obj) && (obj2 = ((SoftReference) this.f5542a.get(obj)).get()) == null) {
            C1786r.m6061b("Cached reference is deleted.", f5541b);
            this.f5542a.remove(obj);
        }
        return obj2;
    }

    /* renamed from: a */
    public synchronized void m5365a(Object obj, Object obj2) {
        if (obj2 != null) {
            this.f5542a.put(obj, new SoftReference(obj2));
        }
    }

    /* renamed from: a */
    public synchronized void mo5364a() {
        C1786r.m6061b("Clear cached data.", f5541b);
        Iterator it = this.f5542a.values().iterator();
        while (it.hasNext()) {
            ((SoftReference) it.next()).clear();
        }
        this.f5542a.clear();
    }
}
