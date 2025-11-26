package com.sec.chaton.push.message.processer;

import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.message.processer.b */
/* loaded from: classes.dex */
class C0367b implements IPendingTask {

    /* renamed from: a */
    final /* synthetic */ int f2678a;

    /* renamed from: b */
    final /* synthetic */ ICallback f2679b;

    /* renamed from: c */
    final /* synthetic */ InitMessageProcesser f2680c;

    C0367b(InitMessageProcesser initMessageProcesser, int i, ICallback iCallback) {
        this.f2680c = initMessageProcesser;
        this.f2678a = i;
        this.f2679b = iCallback;
    }

    @Override // com.sec.chaton.push.message.processer.IPendingTask
    /* renamed from: a */
    public void mo2893a() {
        PushLog.m3025a(InitMessageProcesser.f2628d, "onRequestExecute()");
        this.f2680c.f2623b.m2928b(this.f2678a, this.f2679b);
    }

    @Override // com.sec.chaton.push.message.processer.IPendingTask
    /* renamed from: a */
    public void mo2894a(int i) {
        PushLog.m3025a(InitMessageProcesser.f2628d, "onRequestCancel()");
        this.f2680c.m2883a(this.f2679b, i);
    }
}
