package com.sec.chaton.push.message.processer;

/* renamed from: com.sec.chaton.push.message.processer.o */
/* loaded from: classes.dex */
class RunnableC0380o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f2710a;

    /* renamed from: b */
    final /* synthetic */ ICallback f2711b;

    /* renamed from: c */
    final /* synthetic */ MessageController f2712c;

    RunnableC0380o(MessageController messageController, int i, ICallback iCallback) {
        this.f2712c = messageController;
        this.f2710a = i;
        this.f2711b = iCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2712c.f2644m.m2898a(this.f2710a, new C0363a(this));
        } finally {
            this.f2712c.m2913r();
        }
    }
}
