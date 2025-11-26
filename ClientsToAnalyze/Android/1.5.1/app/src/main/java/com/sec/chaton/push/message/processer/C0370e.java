package com.sec.chaton.push.message.processer;

import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.message.processer.e */
/* loaded from: classes.dex */
class C0370e implements ICallback {

    /* renamed from: a */
    final /* synthetic */ int f2685a;

    /* renamed from: b */
    final /* synthetic */ ICallback f2686b;

    /* renamed from: c */
    final /* synthetic */ InitMessageProcesser f2687c;

    C0370e(InitMessageProcesser initMessageProcesser, int i, ICallback iCallback) {
        this.f2687c = initMessageProcesser;
        this.f2685a = i;
        this.f2686b = iCallback;
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a */
    public void mo2865a(int i) {
        if (i == -100) {
            this.f2687c.f2623b.m2925a(true, this.f2685a, this.f2686b);
            return;
        }
        this.f2687c.m2883a(this.f2686b, -104);
        PushLog.m3025a(InitMessageProcesser.f2628d, "Cancel pending tasks");
        this.f2687c.f2623b.m2915a(-103);
        this.f2687c.f2623b.m2933f();
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2866a(Void r5) {
        this.f2687c.f2623b.m2925a(true, this.f2685a, this.f2686b);
    }
}
