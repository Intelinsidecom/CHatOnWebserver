package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;

/* renamed from: com.sds.coolots.call.model.c */
/* loaded from: classes.dex */
class HandlerC1201c extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1199a f2651a;

    private HandlerC1201c(C1199a c1199a) {
        this.f2651a = c1199a;
    }

    /* synthetic */ HandlerC1201c(C1199a c1199a, HandlerC1201c handlerC1201c) {
        this(c1199a);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f2651a.m2442f("AudioChatHandler : handleMessage() msg.what : " + message.what);
        if (message.what == MessageInfo.MakeConferenceAsk.getDispatchCode()) {
            this.f2651a.mo2445a(message);
            return;
        }
        if (message.what == MessageInfo.JoinConferenceAsk.getDispatchCode()) {
            this.f2651a.m2718c(message);
            return;
        }
        if (message.what == MessageInfo.DenyConferenceAsk.getDispatchCode()) {
            if (this.f2651a.f2548q) {
                return;
            }
            this.f2651a.m2721d(message);
            return;
        }
        if (message.what != MessageInfo.CloseConferenceAsk.getDispatchCode()) {
            if (message.what == MessageInfo.ConferenceInfoAsk.getDispatchCode()) {
                if (this.f2651a.f2548q) {
                    return;
                }
                this.f2651a.m2722e(message);
                return;
            }
            if (message.what == MessageInfo.AddConferenceMemberAsk.getDispatchCode()) {
                if (this.f2651a.f2548q) {
                    return;
                }
                this.f2651a.m2723f(message);
                return;
            }
            if (message.what == MessageInfo.RemoveConferenceMemberAsk.getDispatchCode()) {
                this.f2651a.m2441e("RemoveConferenceMemberRep mCallCleared : " + this.f2651a.f2548q);
                if (this.f2651a.f2548q) {
                    return;
                }
                this.f2651a.mo2449b(message);
                return;
            }
            if (message.what == MessageInfo.ChangeConferenceLayoutAsk.getDispatchCode()) {
                if (this.f2651a.f2548q) {
                    return;
                }
                this.f2651a.m2724g(message);
            } else {
                if (message.what != MessageInfo.ChangeConferenceTypeAsk.getDispatchCode() || this.f2651a.f2548q) {
                    return;
                }
                this.f2651a.m2725h(message);
            }
        }
    }
}
