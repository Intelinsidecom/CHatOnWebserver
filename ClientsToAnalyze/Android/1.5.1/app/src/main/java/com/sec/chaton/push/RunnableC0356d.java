package com.sec.chaton.push;

import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.message.processer.ICallback;
import com.sec.chaton.push.message.processer.MessageController;
import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.d */
/* loaded from: classes.dex */
class RunnableC0356d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PushClientService f2602a;

    RunnableC0356d(PushClientService pushClientService) {
        this.f2602a = pushClientService;
    }

    @Override // java.lang.Runnable
    public void run() {
        HeartBeat.m2871a(this.f2602a.getBaseContext());
        if (MessageController.m2911p().m2931d()) {
            return;
        }
        PushLog.m3025a(this.f2602a.f2592a, "Execute initlialize");
        MessageController.m2911p().m2929b((ICallback) null);
    }
}
