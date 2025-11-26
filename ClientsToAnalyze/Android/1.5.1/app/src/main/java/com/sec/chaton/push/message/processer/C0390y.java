package com.sec.chaton.push.message.processer;

/* renamed from: com.sec.chaton.push.message.processer.y */
/* loaded from: classes.dex */
class C0390y implements ICallback {

    /* renamed from: a */
    final /* synthetic */ RunnableC0381p f2730a;

    C0390y(RunnableC0381p runnableC0381p) {
        this.f2730a = runnableC0381p;
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a */
    public void mo2865a(int i) {
        this.f2730a.f2715c.m2903b(false);
        if (this.f2730a.f2714b != null) {
            this.f2730a.f2714b.mo2865a(i);
        }
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2866a(Void r3) {
        this.f2730a.f2715c.m2903b(false);
        if (this.f2730a.f2714b != null) {
            this.f2730a.f2714b.mo2866a(r3);
        }
    }
}
