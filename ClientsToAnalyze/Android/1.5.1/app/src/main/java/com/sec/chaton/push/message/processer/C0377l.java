package com.sec.chaton.push.message.processer;

import android.content.Context;
import com.sec.chaton.push.util.AlarmTimer;

/* renamed from: com.sec.chaton.push.message.processer.l */
/* loaded from: classes.dex */
class C0377l implements AlarmTimer.ICallback {

    /* renamed from: a */
    final /* synthetic */ int f2702a;

    /* renamed from: b */
    final /* synthetic */ AbstractMessageProcesser f2703b;

    C0377l(AbstractMessageProcesser abstractMessageProcesser, int i) {
        this.f2703b = abstractMessageProcesser;
        this.f2702a = i;
    }

    @Override // com.sec.chaton.push.util.AlarmTimer.ICallback
    /* renamed from: a */
    public void mo2965a(Context context) {
        this.f2703b.f2624c.post(new RunnableC0373h(this));
    }
}
