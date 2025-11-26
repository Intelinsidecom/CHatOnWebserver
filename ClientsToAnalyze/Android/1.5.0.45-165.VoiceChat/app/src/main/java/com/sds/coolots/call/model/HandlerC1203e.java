package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.sds.coolots.MainApplication;

/* renamed from: com.sds.coolots.call.model.e */
/* loaded from: classes.dex */
class HandlerC1203e extends Handler {

    /* renamed from: a */
    final /* synthetic */ Call f2655a;

    HandlerC1203e(Call call) {
        this.f2655a = call;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f2655a.m2281f("handleRejectMsgHandleMessage what : " + message.what);
        switch (message.what) {
            case 12001:
                MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(this.f2655a.f2542k, Call.HANGUP_REASON_REJECT_MESSAGE_TIMER);
                break;
        }
        super.handleMessage(message);
    }
}
