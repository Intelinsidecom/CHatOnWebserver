package com.sec.chaton.push.message.processer;

import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.message.processer.z */
/* loaded from: classes.dex */
class C0391z implements IPendingTask {

    /* renamed from: a */
    final /* synthetic */ String f2731a;

    /* renamed from: b */
    final /* synthetic */ ICallback f2732b;

    /* renamed from: c */
    final /* synthetic */ RegistrationMessageProcesser f2733c;

    C0391z(RegistrationMessageProcesser registrationMessageProcesser, String str, ICallback iCallback) {
        this.f2733c = registrationMessageProcesser;
        this.f2731a = str;
        this.f2732b = iCallback;
    }

    @Override // com.sec.chaton.push.message.processer.IPendingTask
    /* renamed from: a */
    public void mo2893a() {
        PushLog.m3025a(RegistrationMessageProcesser.f2665d, "onRequestExecute()");
        this.f2733c.f2623b.m2919a(this.f2731a, this.f2732b);
    }

    @Override // com.sec.chaton.push.message.processer.IPendingTask
    /* renamed from: a */
    public void mo2894a(int i) {
        PushLog.m3025a(RegistrationMessageProcesser.f2665d, "onRequestCancel()");
        this.f2733c.m2883a(this.f2732b, i);
    }
}
