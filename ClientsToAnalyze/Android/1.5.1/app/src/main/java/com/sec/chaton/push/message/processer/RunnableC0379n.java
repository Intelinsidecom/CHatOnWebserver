package com.sec.chaton.push.message.processer;

/* renamed from: com.sec.chaton.push.message.processer.n */
/* loaded from: classes.dex */
class RunnableC0379n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2707a;

    /* renamed from: b */
    final /* synthetic */ ICallback f2708b;

    /* renamed from: c */
    final /* synthetic */ MessageController f2709c;

    RunnableC0379n(MessageController messageController, String str, ICallback iCallback) {
        this.f2709c = messageController;
        this.f2707a = str;
        this.f2708b = iCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2709c.f2645n.m2957a(this.f2707a, this.f2708b);
        } finally {
            this.f2709c.m2913r();
        }
    }
}
