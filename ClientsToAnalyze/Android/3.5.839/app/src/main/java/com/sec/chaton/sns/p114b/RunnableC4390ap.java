package com.sec.chaton.sns.p114b;

/* compiled from: SnsHelperVKontakte.java */
/* renamed from: com.sec.chaton.sns.b.ap */
/* loaded from: classes.dex */
class RunnableC4390ap implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f15905a;

    /* renamed from: b */
    final /* synthetic */ int f15906b;

    /* renamed from: c */
    final /* synthetic */ Object f15907c;

    /* renamed from: d */
    final /* synthetic */ C4389ao f15908d;

    RunnableC4390ap(C4389ao c4389ao, int i, int i2, Object obj) {
        this.f15908d = c4389ao;
        this.f15905a = i;
        this.f15906b = i2;
        this.f15907c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15908d.f15904b.f15902i.mo16563a(this.f15905a, this.f15906b, this.f15907c);
    }
}
