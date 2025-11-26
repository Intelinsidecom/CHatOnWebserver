package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.sds.coolots.MainApplication;

/* renamed from: com.sds.coolots.call.model.h */
/* loaded from: classes.dex */
class HandlerC1206h extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1205g f2687a;

    HandlerC1206h(C1205g c1205g) {
        this.f2687a = c1205g;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f2687a.m2467i("handleRejectMsgHandleMessage what : " + message.what);
        switch (message.what) {
            case 12001:
                MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(this.f2687a.f2678p.m2359f(), Call.HANGUP_REASON_REJECT_MESSAGE_TIMER);
                break;
        }
        super.handleMessage(message);
    }
}
