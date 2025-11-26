package com.sds.coolots.call;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.C1205g;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;

/* renamed from: com.sds.coolots.call.n */
/* loaded from: classes.dex */
class HandlerC1225n extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1181i f2793a;

    private HandlerC1225n(C1181i c1181i) {
        this.f2793a = c1181i;
    }

    /* synthetic */ HandlerC1225n(C1181i c1181i, HandlerC1225n handlerC1225n) {
        this(c1181i);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == MessageInfo.ConferenceInfoAsk.getDispatchCode()) {
            this.f2793a.m2234a(message);
            return;
        }
        if (message.what == MessageInfo.DenyConferenceAsk.getDispatchCode() || message.what == MessageInfo.CloseConferenceAsk.getDispatchCode()) {
            return;
        }
        if (message.what == 10) {
            switch (message.arg2) {
                case 10003:
                    this.f2793a.m2264j();
                    break;
                case 10004:
                    this.f2793a.m2263i();
                    break;
                case 10005:
                    this.f2793a.m2242a((C1182j) message.obj);
                    break;
            }
            return;
        }
        if (message.what == 11) {
            this.f2793a.m2251b((C1205g) message.obj);
            return;
        }
        if (message.what == 12) {
            this.f2793a.unHoldCall((Destination) message.obj);
            if (message.arg1 == 1) {
                this.f2793a.muteCall((Destination) message.obj);
                return;
            }
            return;
        }
        if (message.what == 13) {
            this.f2793a.m2243a((CallStatusData) message.obj, message.arg1 == 1);
        } else if (message.what == 20000) {
            MainApplication.mPhoneManager.releaseDVFSHelper();
        }
    }
}
