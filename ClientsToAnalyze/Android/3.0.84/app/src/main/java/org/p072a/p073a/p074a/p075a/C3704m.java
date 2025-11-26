package org.p072a.p073a.p074a.p075a;

/* compiled from: GenericKeyedObjectPool.java */
/* renamed from: org.a.a.a.a.m */
/* loaded from: classes.dex */
final class C3704m<LK, LV> {

    /* renamed from: a */
    final /* synthetic */ C3702j f13667a;

    /* renamed from: b */
    private final LK f13668b;

    /* renamed from: c */
    private C3702j<K, V>.n f13669c;

    /* renamed from: d */
    private C3705o<LV> f13670d;

    /* renamed from: e */
    private boolean f13671e;

    private C3704m(C3702j c3702j, LK lk) {
        this.f13667a = c3702j;
        this.f13671e = false;
        this.f13668b = lk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized LK m13344a() {
        return this.f13668b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized C3702j<K, V>.n m13352b() {
        return this.f13669c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m13349a(C3702j<K, V>.n nVar) {
        this.f13669c = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public synchronized C3705o<LV> m13355c() {
        return this.f13670d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m13350a(C3705o<LV> c3705o) {
        this.f13670d = c3705o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public synchronized boolean m13357d() {
        return this.f13671e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m13351a(boolean z) {
        this.f13671e = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public synchronized void m13358e() {
        this.f13670d = null;
        this.f13671e = false;
    }
}
