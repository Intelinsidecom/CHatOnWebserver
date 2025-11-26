package com.sec.chaton.chat.background;

/* compiled from: ChatBackgroundHandler.java */
/* renamed from: com.sec.chaton.chat.background.b */
/* loaded from: classes.dex */
class RunnableC1583b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f6022a;

    /* renamed from: b */
    final /* synthetic */ HandlerC1582a f6023b;

    RunnableC1583b(HandlerC1582a handlerC1582a, long j) {
        this.f6023b = handlerC1582a;
        this.f6022a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((C1587f) this.f6023b.f6020a.get(Long.valueOf(this.f6022a))).mo8446a();
    }
}
