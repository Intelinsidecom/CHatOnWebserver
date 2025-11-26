package com.sec.chaton.push.message.processer;

import android.content.Context;
import com.sec.chaton.push.util.AlarmTimer;

/* renamed from: com.sec.chaton.push.message.processer.k */
/* loaded from: classes.dex */
class C0376k implements AlarmTimer.ICallback {

    /* renamed from: a */
    final /* synthetic */ int f2699a;

    /* renamed from: b */
    final /* synthetic */ ICallback f2700b;

    /* renamed from: c */
    final /* synthetic */ AbstractMessageProcesser f2701c;

    C0376k(AbstractMessageProcesser abstractMessageProcesser, int i, ICallback iCallback) {
        this.f2701c = abstractMessageProcesser;
        this.f2699a = i;
        this.f2700b = iCallback;
    }

    @Override // com.sec.chaton.push.util.AlarmTimer.ICallback
    /* renamed from: a */
    public void mo2965a(Context context) {
        this.f2701c.f2624c.post(new RunnableC0389x(this));
    }
}
