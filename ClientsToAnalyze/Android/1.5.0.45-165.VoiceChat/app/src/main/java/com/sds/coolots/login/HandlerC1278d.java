package com.sds.coolots.login;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.sds.coolots.login.d */
/* loaded from: classes.dex */
class HandlerC1278d extends Handler {

    /* renamed from: a */
    final /* synthetic */ LoginManager f3209a;

    private HandlerC1278d(LoginManager loginManager) {
        this.f3209a = loginManager;
    }

    /* synthetic */ HandlerC1278d(LoginManager loginManager, HandlerC1278d handlerC1278d) {
        this(loginManager);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.f3209a.m3004a("<<YHT2>> EVENT_LOGIN_REQUEST!!");
                this.f3209a.f3146I.handleReqLogin();
                break;
            case 1:
                this.f3209a.m3004a("<<YHT2>> EVENT_LOGOUT_REQUEST!!");
                this.f3209a.f3146I.handleReqLogout();
                break;
            case 2:
                this.f3209a.m3004a("<<YHT2>> EVENT_RECV_SERVERINFO!!");
                this.f3209a.f3146I.handleRecvServerInfo();
                break;
            case 3:
                this.f3209a.m3004a("<<YHT2>> EVENT_RECV_NONCE!!");
                this.f3209a.f3146I.handleRecvNonce();
                break;
            case 4:
                this.f3209a.m3004a("<<YHT2>> EVENT_RECV_LOGINREP!!");
                this.f3209a.f3146I.handleRecvLoginRep();
                break;
            case 5:
                this.f3209a.m3004a("<<YHT2>> EVENT_RES_ENGINELOGIN_SUCCESS!!");
                this.f3209a.f3146I.handleResEngineLoginSuccess();
                break;
            case 6:
                this.f3209a.m3004a("<<YHT2>> EVENT_RES_ENGINELOGOUT_SUCCESS!!");
                this.f3209a.f3146I.handleResEngineLogoutSuccess();
                break;
            case 8:
                this.f3209a.m3004a("<<YHT2>> EVENT_LOGIN_ERROR!!");
                this.f3209a.f3146I.handleErrorEvent();
                break;
            case 9:
                this.f3209a.m3004a("<<YHT2>> EVENT_ENGINELOGIN_FAILURE!!");
                this.f3209a.f3146I.handleResEngineLoginFailure();
                break;
            case 10:
                this.f3209a.m3004a("<<YHT2>> EVENT_RECV_CIPHERKEY!!!");
                this.f3209a.f3146I.handleRecvCipherKey();
                break;
        }
    }
}
