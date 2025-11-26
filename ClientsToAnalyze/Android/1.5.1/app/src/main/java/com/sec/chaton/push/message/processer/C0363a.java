package com.sec.chaton.push.message.processer;

/* renamed from: com.sec.chaton.push.message.processer.a */
/* loaded from: classes.dex */
class C0363a implements ICallback {

    /* renamed from: a */
    final /* synthetic */ RunnableC0380o f2668a;

    C0363a(RunnableC0380o runnableC0380o) {
        this.f2668a = runnableC0380o;
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a */
    public void mo2865a(int i) {
        this.f2668a.f2712c.m2905c(false);
        if (this.f2668a.f2711b != null) {
            this.f2668a.f2711b.mo2865a(i);
        }
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2866a(Void r3) {
        this.f2668a.f2712c.m2905c(false);
        if (this.f2668a.f2711b != null) {
            this.f2668a.f2711b.mo2866a(r3);
        }
    }
}
