package com.sec.chaton.push.message.processer;

import com.google.protobuf.MessageLite;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.util.PushLog;

/* renamed from: com.sec.chaton.push.message.processer.v */
/* loaded from: classes.dex */
class C0387v implements MessageContext.ICallback {

    /* renamed from: a */
    final /* synthetic */ NotiAcksMessageProcesser f2726a;

    C0387v(NotiAcksMessageProcesser notiAcksMessageProcesser) {
        this.f2726a = notiAcksMessageProcesser;
    }

    @Override // com.sec.chaton.push.network.MessageContext.ICallback
    /* renamed from: a */
    public void mo2959a(int i, MessageLite messageLite) {
        PushLog.m3031d(NotiAcksMessageProcesser.f2654d, "onFailed. ErrorCode: " + i);
    }

    @Override // com.sec.chaton.push.network.MessageContext.ICallback
    /* renamed from: a */
    public void mo2960a(MessageLite messageLite, MessageLite messageLite2) {
    }
}
