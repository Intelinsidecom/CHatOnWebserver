package com.sec.common.p124b;

import com.sec.common.C4996f;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: SoftCacheLoader.java */
/* renamed from: com.sec.common.b.b */
/* loaded from: classes.dex */
public class C4971b<K, V> implements InterfaceC4970a<K, V> {

    /* renamed from: b */
    private static final String f18167b = C4971b.class.getSimpleName();

    /* renamed from: a */
    protected Map<K, SoftReference<V>> f18168a = new HashMap();

    @Override // com.sec.common.p124b.InterfaceC4970a
    /* renamed from: a */
    public synchronized V mo18887a(K k) {
        V v;
        v = null;
        if (this.f18168a.containsKey(k) && (v = this.f18168a.get(k).get()) == null) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18167b, "Cached reference is deleted.");
            }
            this.f18168a.remove(k);
        }
        return v;
    }

    @Override // com.sec.common.p124b.InterfaceC4970a
    /* renamed from: a */
    public synchronized void mo18889a(K k, V v) {
        if (v != null) {
            this.f18168a.put(k, new SoftReference<>(v));
        }
    }

    @Override // com.sec.common.p124b.InterfaceC4970a
    /* renamed from: b */
    public synchronized V mo18890b(K k) {
        SoftReference<V> softReferenceRemove;
        return (!this.f18168a.containsKey(k) || (softReferenceRemove = this.f18168a.remove(k)) == null) ? null : softReferenceRemove.get();
    }

    @Override // com.sec.common.p124b.InterfaceC4970a
    /* renamed from: a */
    public synchronized void mo18888a() {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f18167b, "Clear cached data.");
        }
        Iterator<SoftReference<V>> it = this.f18168a.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f18168a.clear();
    }
}
