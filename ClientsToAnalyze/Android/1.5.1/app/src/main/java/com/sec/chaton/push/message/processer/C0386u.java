package com.sec.chaton.push.message.processer;

import com.sec.chaton.push.util.PushLog;
import java.util.List;

/* renamed from: com.sec.chaton.push.message.processer.u */
/* loaded from: classes.dex */
class C0386u implements IPendingTask {

    /* renamed from: a */
    final /* synthetic */ List f2724a;

    /* renamed from: b */
    final /* synthetic */ NotiAcksMessageProcesser f2725b;

    C0386u(NotiAcksMessageProcesser notiAcksMessageProcesser, List list) {
        this.f2725b = notiAcksMessageProcesser;
        this.f2724a = list;
    }

    @Override // com.sec.chaton.push.message.processer.IPendingTask
    /* renamed from: a */
    public void mo2893a() {
        PushLog.m3025a(NotiAcksMessageProcesser.f2654d, "onRequestExecute");
        this.f2725b.f2623b.m2920a(this.f2724a);
    }

    @Override // com.sec.chaton.push.message.processer.IPendingTask
    /* renamed from: a */
    public void mo2894a(int i) {
        PushLog.m3031d(NotiAcksMessageProcesser.f2654d, "onRequestCancel: " + i);
    }
}
