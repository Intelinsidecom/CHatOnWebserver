package android.support.v4.p008c;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ArrayMap.java */
/* renamed from: android.support.v4.c.b */
/* loaded from: classes.dex */
class C0079b<K, V> extends AbstractC0084g<K, V> {

    /* renamed from: a */
    final /* synthetic */ C0078a f240a;

    C0079b(C0078a c0078a) {
        this.f240a = c0078a;
    }

    @Override // android.support.v4.p008c.AbstractC0084g
    /* renamed from: a */
    protected int mo249a() {
        return this.f240a.f275h;
    }

    @Override // android.support.v4.p008c.AbstractC0084g
    /* renamed from: a */
    protected Object mo251a(int i, int i2) {
        return this.f240a.f274g[(i << 1) + i2];
    }

    @Override // android.support.v4.p008c.AbstractC0084g
    /* renamed from: a */
    protected int mo250a(Object obj) {
        return obj == null ? this.f240a.m285a() : this.f240a.m287a(obj, obj.hashCode());
    }

    @Override // android.support.v4.p008c.AbstractC0084g
    /* renamed from: b */
    protected int mo255b(Object obj) {
        return this.f240a.m286a(obj);
    }

    @Override // android.support.v4.p008c.AbstractC0084g
    /* renamed from: b */
    protected Map<K, V> mo256b() {
        return this.f240a;
    }

    @Override // android.support.v4.p008c.AbstractC0084g
    /* renamed from: a */
    protected void mo254a(K k, V v) {
        this.f240a.put(k, v);
    }

    @Override // android.support.v4.p008c.AbstractC0084g
    /* renamed from: a */
    protected V mo252a(int i, V v) {
        return this.f240a.m288a(i, (int) v);
    }

    @Override // android.support.v4.p008c.AbstractC0084g
    /* renamed from: a */
    protected void mo253a(int i) {
        this.f240a.m292d(i);
    }

    @Override // android.support.v4.p008c.AbstractC0084g
    /* renamed from: c */
    protected void mo257c() {
        this.f240a.clear();
    }
}
