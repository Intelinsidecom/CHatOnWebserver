package com.sec.chaton.push.message.processer;

/* renamed from: com.sec.chaton.push.message.processer.s */
/* loaded from: classes.dex */
class RunnableC0384s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f2719a;

    /* renamed from: b */
    final /* synthetic */ ICallback f2720b;

    /* renamed from: c */
    final /* synthetic */ MessageController f2721c;

    RunnableC0384s(MessageController messageController, boolean z, ICallback iCallback) {
        this.f2721c = messageController;
        this.f2719a = z;
        this.f2720b = iCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2721c.f2647p.m2949a(this.f2719a, this.f2720b);
        } finally {
            this.f2721c.m2913r();
        }
    }
}
