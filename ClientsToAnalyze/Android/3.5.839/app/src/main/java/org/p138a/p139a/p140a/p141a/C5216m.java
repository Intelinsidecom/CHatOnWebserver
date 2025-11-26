package org.p138a.p139a.p140a.p141a;

/* compiled from: GenericKeyedObjectPool.java */
/* renamed from: org.a.a.a.a.m */
/* loaded from: classes.dex */
final class C5216m<LK, LV> {

    /* renamed from: a */
    final /* synthetic */ C5214j f19022a;

    /* renamed from: b */
    private final LK f19023b;

    /* renamed from: c */
    private C5214j<K, V>.n f19024c;

    /* renamed from: d */
    private C5217o<LV> f19025d;

    /* renamed from: e */
    private boolean f19026e;

    private C5216m(C5214j c5214j, LK lk) {
        this.f19022a = c5214j;
        this.f19026e = false;
        this.f19023b = lk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized LK m19872a() {
        return this.f19023b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized C5214j<K, V>.n m19880b() {
        return this.f19024c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m19877a(C5214j<K, V>.n nVar) {
        this.f19024c = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public synchronized C5217o<LV> m19883c() {
        return this.f19025d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m19878a(C5217o<LV> c5217o) {
        this.f19025d = c5217o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public synchronized boolean m19885d() {
        return this.f19026e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m19879a(boolean z) {
        this.f19026e = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public synchronized void m19886e() {
        this.f19025d = null;
        this.f19026e = false;
    }
}
