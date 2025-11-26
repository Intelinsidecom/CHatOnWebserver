package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;

/* renamed from: com.sds.coolots.call.model.C */
/* loaded from: classes.dex */
class HandlerC1188C extends Handler {

    /* renamed from: a */
    final /* synthetic */ ConferenceMemberHandler f2517a;

    HandlerC1188C(ConferenceMemberHandler conferenceMemberHandler) {
        this.f2517a = conferenceMemberHandler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == MessageInfo.ConferenceInfoAsk.getDispatchCode()) {
            this.f2517a.m2396a(message);
        }
        super.handleMessage(message);
    }
}
