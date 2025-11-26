package com.sds.coolots.login;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;

/* renamed from: com.sds.coolots.login.c */
/* loaded from: classes.dex */
class HandlerC1277c extends Handler {

    /* renamed from: a */
    final /* synthetic */ LoginManager f3208a;

    private HandlerC1277c(LoginManager loginManager) {
        this.f3208a = loginManager;
    }

    /* synthetic */ HandlerC1277c(LoginManager loginManager, HandlerC1277c handlerC1277c) {
        this(loginManager);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NumberFormatException {
        if (message.what == MessageInfo.DeviceIDAsk.getDispatchCode()) {
            this.f3208a.m3008b(message);
            return;
        }
        if (message.what == MessageInfo.NonceAsk.getDispatchCode()) {
            this.f3208a.m3017d(message);
            return;
        }
        if (message.what == MessageInfo.SearchableAsk.getDispatchCode()) {
            this.f3208a.m3027h(message);
            return;
        }
        if (message.what == MessageInfo.LoginAsk.getDispatchCode()) {
            this.f3208a.m3020e(message);
            return;
        }
        if (message.what == MessageInfo.ServerInfoAsk.getDispatchCode()) {
            this.f3208a.m3025g(message);
            return;
        }
        if (message.what == MessageInfo.CipherKeyAsk.getDispatchCode()) {
            this.f3208a.m3023f(message);
        } else if (message.what == MessageInfo.ResetMsgKeyAsk.getDispatchCode()) {
            this.f3208a.m3000a(message);
        } else if (message.what == MessageInfo.DeviceConfigAsk.getDispatchCode()) {
            this.f3208a.m3013c(message);
        }
    }
}
