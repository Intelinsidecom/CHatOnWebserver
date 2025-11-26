package com.sec.chaton.push.message.processer;

import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.message.processer.ab */
/* loaded from: classes.dex */
class C0365ab implements IPendingTask {

    /* renamed from: a */
    final /* synthetic */ String f2672a;

    /* renamed from: b */
    final /* synthetic */ ICallback f2673b;

    /* renamed from: c */
    final /* synthetic */ DeregistrationMessageProcesser f2674c;

    C0365ab(DeregistrationMessageProcesser deregistrationMessageProcesser, String str, ICallback iCallback) {
        this.f2674c = deregistrationMessageProcesser;
        this.f2672a = str;
        this.f2673b = iCallback;
    }

    @Override // com.sec.chaton.push.message.processer.IPendingTask
    /* renamed from: a */
    public void mo2893a() {
        PushLog.m3025a(DeregistrationMessageProcesser.f2625d, "onRequestExecute()");
        this.f2674c.f2623b.m2926b(this.f2672a, this.f2673b);
    }

    @Override // com.sec.chaton.push.message.processer.IPendingTask
    /* renamed from: a */
    public void mo2894a(int i) {
        PushLog.m3025a(DeregistrationMessageProcesser.f2625d, "onRequestCancel()");
        this.f2674c.m2883a(this.f2673b, i);
    }
}
