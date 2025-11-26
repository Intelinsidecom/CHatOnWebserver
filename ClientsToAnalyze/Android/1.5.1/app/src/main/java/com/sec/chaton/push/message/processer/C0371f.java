package com.sec.chaton.push.message.processer;

import com.google.protobuf.MessageLite;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontend;

/* renamed from: com.sec.chaton.push.message.processer.f */
/* loaded from: classes.dex */
class C0371f implements MessageContext.ICallback {

    /* renamed from: a */
    final /* synthetic */ ICallback f2688a;

    /* renamed from: b */
    final /* synthetic */ PingMessageProcesser f2689b;

    C0371f(PingMessageProcesser pingMessageProcesser, ICallback iCallback) {
        this.f2689b = pingMessageProcesser;
        this.f2688a = iCallback;
    }

    @Override // com.sec.chaton.push.network.MessageContext.ICallback
    /* renamed from: a */
    public void mo2959a(int i, MessageLite messageLite) {
        PushLog.m3031d(PingMessageProcesser.f2659d, "OnFailed: ErrorCode(" + i + ")");
        this.f2689b.m2883a(this.f2688a, i);
    }

    @Override // com.sec.chaton.push.network.MessageContext.ICallback
    /* renamed from: a */
    public void mo2960a(MessageLite messageLite, MessageLite messageLite2) {
        PushLog.m3025a(PingMessageProcesser.f2659d, "OnSuccess");
        this.f2689b.m2884a(this.f2688a, new Integer(((MsgFrontend.PingReply) messageLite2).getDelta()));
    }
}
