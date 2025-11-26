package com.sec.chaton.chat.background;

/* compiled from: ChatBackgroundHandler.java */
/* renamed from: com.sec.chaton.chat.background.d */
/* loaded from: classes.dex */
class RunnableC0557d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f1930a;

    /* renamed from: b */
    final /* synthetic */ HandlerC0554a f1931b;

    RunnableC0557d(HandlerC0554a handlerC0554a, long j) {
        this.f1931b = handlerC0554a;
        this.f1930a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((C0559f) this.f1931b.f1915a.get(Long.valueOf(this.f1930a))).m2765c();
    }
}
