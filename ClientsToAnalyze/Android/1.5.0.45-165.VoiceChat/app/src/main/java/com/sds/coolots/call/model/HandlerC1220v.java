package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;

/* renamed from: com.sds.coolots.call.model.v */
/* loaded from: classes.dex */
class HandlerC1220v extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1217s f2781a;

    private HandlerC1220v(C1217s c1217s) {
        this.f2781a = c1217s;
    }

    /* synthetic */ HandlerC1220v(C1217s c1217s, HandlerC1220v handlerC1220v) {
        this(c1217s);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == MessageInfo.MakeConferenceAsk.getDispatchCode()) {
            this.f2781a.mo2445a(message);
            return;
        }
        if (message.what == MessageInfo.JoinConferenceAsk.getDispatchCode()) {
            this.f2781a.m2718c(message);
            return;
        }
        if (message.what == MessageInfo.DenyConferenceAsk.getDispatchCode()) {
            if (this.f2781a.f2548q) {
                return;
            }
            this.f2781a.m2721d(message);
            return;
        }
        if (message.what != MessageInfo.CloseConferenceAsk.getDispatchCode()) {
            if (message.what == MessageInfo.ConferenceInfoAsk.getDispatchCode()) {
                if (this.f2781a.f2548q) {
                    return;
                }
                this.f2781a.m2722e(message);
                return;
            }
            if (message.what == MessageInfo.AddConferenceMemberAsk.getDispatchCode()) {
                if (this.f2781a.f2548q) {
                    return;
                }
                this.f2781a.m2723f(message);
            } else if (message.what == MessageInfo.RemoveConferenceMemberAsk.getDispatchCode()) {
                if (this.f2781a.f2548q) {
                    return;
                }
                this.f2781a.mo2449b(message);
            } else if (message.what == MessageInfo.ChangeConferenceLayoutAsk.getDispatchCode()) {
                if (this.f2781a.f2548q) {
                    return;
                }
                this.f2781a.m2724g(message);
            } else {
                if (message.what != MessageInfo.ChangeConferenceTypeAsk.getDispatchCode() || this.f2781a.f2548q) {
                    return;
                }
                this.f2781a.m2725h(message);
            }
        }
    }
}
