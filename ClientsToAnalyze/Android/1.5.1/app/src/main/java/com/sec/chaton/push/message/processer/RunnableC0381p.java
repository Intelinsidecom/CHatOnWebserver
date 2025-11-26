package com.sec.chaton.push.message.processer;

/* renamed from: com.sec.chaton.push.message.processer.p */
/* loaded from: classes.dex */
class RunnableC0381p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f2713a;

    /* renamed from: b */
    final /* synthetic */ ICallback f2714b;

    /* renamed from: c */
    final /* synthetic */ MessageController f2715c;

    RunnableC0381p(MessageController messageController, int i, ICallback iCallback) {
        this.f2715c = messageController;
        this.f2713a = i;
        this.f2714b = iCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2715c.f2649r.m2953a(this.f2713a, new C0390y(this));
        } finally {
            this.f2715c.m2913r();
        }
    }
}
