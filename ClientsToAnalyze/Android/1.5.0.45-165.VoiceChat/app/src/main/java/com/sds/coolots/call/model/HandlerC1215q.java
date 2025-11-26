package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;

/* renamed from: com.sds.coolots.call.model.q */
/* loaded from: classes.dex */
class HandlerC1215q extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1214p f2758a;

    private HandlerC1215q(C1214p c1214p) {
        this.f2758a = c1214p;
    }

    /* synthetic */ HandlerC1215q(C1214p c1214p, HandlerC1215q handlerC1215q) {
        this(c1214p);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == MessageInfo.SwitchToSingleCallAsk.getDispatchCode()) {
            if (this.f2758a.f2548q) {
                return;
            }
            this.f2758a.m2678a(message);
        } else {
            if (message.what != MessageInfo.ConferenceInfoAsk.getDispatchCode() || this.f2758a.f2548q) {
                return;
            }
            this.f2758a.m2672b(message);
        }
    }
}
