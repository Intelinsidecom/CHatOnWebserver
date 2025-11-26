package com.sec.chaton.push.message.processer;

/* renamed from: com.sec.chaton.push.message.processer.m */
/* loaded from: classes.dex */
class RunnableC0378m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2704a;

    /* renamed from: b */
    final /* synthetic */ ICallback f2705b;

    /* renamed from: c */
    final /* synthetic */ MessageController f2706c;

    RunnableC0378m(MessageController messageController, String str, ICallback iCallback) {
        this.f2706c = messageController;
        this.f2704a = str;
        this.f2705b = iCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2706c.f2646o.m2892a(this.f2704a, this.f2705b);
        } finally {
            this.f2706c.m2913r();
        }
    }
}
