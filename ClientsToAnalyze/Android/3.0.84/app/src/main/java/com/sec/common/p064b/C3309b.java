package com.sec.common.p064b;

import com.sec.common.C3330f;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: SoftCacheLoader.java */
/* renamed from: com.sec.common.b.b */
/* loaded from: classes.dex */
public class C3309b<K, V> implements InterfaceC3308a<K, V> {

    /* renamed from: b */
    private static final String f11969b = C3309b.class.getSimpleName();

    /* renamed from: a */
    protected Map<K, SoftReference<V>> f11970a = new HashMap();

    @Override // com.sec.common.p064b.InterfaceC3308a
    /* renamed from: a */
    public synchronized V mo11648a(K k) {
        V v;
        v = null;
        if (this.f11970a.containsKey(k) && (v = this.f11970a.get(k).get()) == null) {
            if (C3330f.f12033a.f11972b) {
                C3330f.f12033a.m11651a(f11969b, "Cached reference is deleted.");
            }
            this.f11970a.remove(k);
        }
        return v;
    }

    @Override // com.sec.common.p064b.InterfaceC3308a
    /* renamed from: a */
    public synchronized void mo11650a(K k, V v) {
        if (v != null) {
            this.f11970a.put(k, new SoftReference<>(v));
        }
    }

    @Override // com.sec.common.p064b.InterfaceC3308a
    /* renamed from: a */
    public synchronized void mo11649a() {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f11969b, "Clear cached data.");
        }
        Iterator<SoftReference<V>> it = this.f11970a.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f11970a.clear();
    }
}
