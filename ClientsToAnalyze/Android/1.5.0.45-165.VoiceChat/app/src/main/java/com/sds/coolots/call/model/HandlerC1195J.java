package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;

/* renamed from: com.sds.coolots.call.model.J */
/* loaded from: classes.dex */
class HandlerC1195J extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1193H f2634a;

    private HandlerC1195J(C1193H c1193h) {
        this.f2634a = c1193h;
    }

    /* synthetic */ HandlerC1195J(C1193H c1193h, HandlerC1195J handlerC1195J) {
        this(c1193h);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == MessageInfo.MakeConferenceAsk.getDispatchCode()) {
            this.f2634a.m2408a(message);
        }
        if (message.what == MessageInfo.CloseConferenceAsk.getDispatchCode()) {
        }
    }
}
