package android.support.v4.view;

import android.database.DataSetObserver;

/* compiled from: PagerTitleStrip.java */
/* renamed from: android.support.v4.view.ai */
/* loaded from: classes.dex */
class C0148ai extends DataSetObserver implements InterfaceC0195cb, InterfaceC0196cc {

    /* renamed from: a */
    final /* synthetic */ PagerTitleStrip f464a;

    /* renamed from: b */
    private int f465b;

    private C0148ai(PagerTitleStrip pagerTitleStrip) {
        this.f464a = pagerTitleStrip;
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo620a(int i, float f, int i2) {
        if (f > 0.5f) {
            i++;
        }
        this.f464a.mo378a(i, f, false);
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo619a(int i) {
        if (this.f465b == 0) {
            this.f464a.m381a(this.f464a.f368a.m424c(), this.f464a.f368a.m421b());
            this.f464a.mo378a(this.f464a.f368a.m424c(), this.f464a.f374g >= 0.0f ? this.f464a.f374g : 0.0f, true);
        }
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: b */
    public void mo622b(int i) {
        this.f465b = i;
    }

    @Override // android.support.v4.view.InterfaceC0195cb
    /* renamed from: a */
    public void mo621a(AbstractC0144ae abstractC0144ae, AbstractC0144ae abstractC0144ae2) {
        this.f464a.m382a(abstractC0144ae, abstractC0144ae2);
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f464a.m381a(this.f464a.f368a.m424c(), this.f464a.f368a.m421b());
        this.f464a.mo378a(this.f464a.f368a.m424c(), this.f464a.f374g >= 0.0f ? this.f464a.f374g : 0.0f, true);
    }
}
