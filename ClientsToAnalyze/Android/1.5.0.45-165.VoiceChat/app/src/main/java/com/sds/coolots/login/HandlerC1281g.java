package com.sds.coolots.login;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;

/* renamed from: com.sds.coolots.login.g */
/* loaded from: classes.dex */
class HandlerC1281g extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushManager f3214a;

    private HandlerC1281g(PushManager pushManager) {
        this.f3214a = pushManager;
    }

    /* synthetic */ HandlerC1281g(PushManager pushManager, HandlerC1281g handlerC1281g) {
        this(pushManager);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case -2:
                this.f3214a.handleReceivedMessage(message.arg1, (String) message.obj);
                break;
            case -1:
                this.f3214a.m3029a();
                break;
        }
        if (message.what == MessageInfo.StoreEPInfoAsk.getDispatchCode()) {
            this.f3214a.m3030a(message.arg1);
        }
    }
}
