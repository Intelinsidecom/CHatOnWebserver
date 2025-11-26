package com.sec.chaton.push.message.processer;

import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.message.processer.g */
/* loaded from: classes.dex */
class C0372g implements IPendingTask {

    /* renamed from: a */
    final /* synthetic */ boolean f2690a;

    /* renamed from: b */
    final /* synthetic */ ICallback f2691b;

    /* renamed from: c */
    final /* synthetic */ PingMessageProcesser f2692c;

    C0372g(PingMessageProcesser pingMessageProcesser, boolean z, ICallback iCallback) {
        this.f2692c = pingMessageProcesser;
        this.f2690a = z;
        this.f2691b = iCallback;
    }

    @Override // com.sec.chaton.push.message.processer.IPendingTask
    /* renamed from: a */
    public void mo2893a() {
        PushLog.m3025a(PingMessageProcesser.f2659d, "onRequestExecute()");
        this.f2692c.f2623b.m2922a(this.f2690a, this.f2691b);
    }

    @Override // com.sec.chaton.push.message.processer.IPendingTask
    /* renamed from: a */
    public void mo2894a(int i) {
        PushLog.m3025a(PingMessageProcesser.f2659d, "onRequestCancel()");
        this.f2692c.m2883a(this.f2691b, i);
    }
}
