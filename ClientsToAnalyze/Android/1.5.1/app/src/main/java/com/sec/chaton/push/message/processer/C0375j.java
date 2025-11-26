package com.sec.chaton.push.message.processer;

import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.message.processer.j */
/* loaded from: classes.dex */
class C0375j implements ICallback {

    /* renamed from: a */
    final /* synthetic */ boolean f2697a;

    /* renamed from: b */
    final /* synthetic */ AbstractMessageProcesser f2698b;

    C0375j(AbstractMessageProcesser abstractMessageProcesser, boolean z) {
        this.f2698b = abstractMessageProcesser;
        this.f2697a = z;
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a */
    public void mo2865a(int i) {
        PushLog.m3025a(AbstractMessageProcesser.f2622d, "Cancel pending tasks");
        this.f2698b.f2623b.m2915a(-103);
        this.f2698b.f2623b.m2933f();
    }

    @Override // com.sec.chaton.push.message.processer.ICallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo2866a(Void r3) {
        PushLog.m3025a(AbstractMessageProcesser.f2622d, "Execute pending tasks");
        this.f2698b.f2623b.m2932e();
        this.f2698b.f2623b.m2933f();
        if (this.f2697a) {
            this.f2698b.f2623b.m2929b((ICallback) null);
        }
    }
}
