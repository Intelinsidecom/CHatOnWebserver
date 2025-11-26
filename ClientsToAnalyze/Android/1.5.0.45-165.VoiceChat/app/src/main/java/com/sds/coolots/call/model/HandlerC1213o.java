package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.sds.coolots.common.view.DisposeInterface;

/* renamed from: com.sds.coolots.call.model.o */
/* loaded from: classes.dex */
class HandlerC1213o extends Handler implements DisposeInterface {

    /* renamed from: a */
    final /* synthetic */ C1212n f2742a;

    /* renamed from: b */
    private boolean f2743b;

    private HandlerC1213o(C1212n c1212n) {
        this.f2742a = c1212n;
        this.f2743b = false;
    }

    /* synthetic */ HandlerC1213o(C1212n c1212n, HandlerC1213o handlerC1213o) {
        this(c1212n);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        this.f2743b = true;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f2743b) {
            return;
        }
        if (message.what == MessageInfo.MakeConferenceAsk.getDispatchCode()) {
            this.f2742a.m2652b(message);
            return;
        }
        if (message.what != MessageInfo.CloseConferenceAsk.getDispatchCode()) {
            if (message.what == MessageInfo.JoinConferenceAsk.getDispatchCode()) {
                this.f2742a.m2660a(message);
            } else if (message.what == MessageInfo.ConferenceInfoAsk.getDispatchCode()) {
                this.f2742a.m2654c(message);
            }
        }
    }
}
