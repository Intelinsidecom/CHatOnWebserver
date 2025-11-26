package com.sec.chaton.chat.background;

/* compiled from: ChatBackgroundHandler.java */
/* renamed from: com.sec.chaton.chat.background.b */
/* loaded from: classes.dex */
class RunnableC0968b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f3969a;

    /* renamed from: b */
    final /* synthetic */ HandlerC0967a f3970b;

    RunnableC0968b(HandlerC0967a handlerC0967a, long j) {
        this.f3970b = handlerC0967a;
        this.f3969a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((C0972f) this.f3970b.f3967a.get(Long.valueOf(this.f3969a))).mo5195a();
    }
}
