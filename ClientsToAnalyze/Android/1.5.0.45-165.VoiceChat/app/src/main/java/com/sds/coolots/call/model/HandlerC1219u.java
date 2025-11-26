package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;

/* renamed from: com.sds.coolots.call.model.u */
/* loaded from: classes.dex */
class HandlerC1219u extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1217s f2780a;

    HandlerC1219u(C1217s c1217s) {
        this.f2780a = c1217s;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == MessageInfo.ChangeConferenceTypeAsk.getDispatchCode() && message.arg1 == 0) {
            this.f2780a.m2713m(1000);
            this.f2780a.f2537f.startShareView(true);
        }
        super.handleMessage(message);
    }
}
