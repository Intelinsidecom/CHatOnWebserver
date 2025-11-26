package com.sds.coolots.login.model;

import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.LoginManager;

/* renamed from: com.sds.coolots.login.model.i */
/* loaded from: classes.dex */
public class C1290i implements LoginStateInterface {

    /* renamed from: a */
    public static final String f3240a = "[SendLoginAskState]";

    /* renamed from: b */
    private final LoginManager f3241b;

    public C1290i(LoginManager loginManager) {
        this.f3241b = loginManager;
    }

    /* renamed from: a */
    private void m3086a(String str) {
        Log.m2958e(f3240a + str);
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleErrorEvent() {
        m3086a("<<YHT2>> handleErrorEvent");
        this.f3241b.setLogoutStateByError();
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvCipherKey() {
        m3086a("<<YHT2>> handleRecvCipherKey --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvLoginRep() {
        m3086a("<<YHT2>> handleRecvLoginRep");
        if (!PhoneManager.isNetworkConnected(MainApplication.mContext)) {
            this.f3241b.setLogoutStateByError();
        } else {
            this.f3241b.requestEngineLogin(this.f3241b.getReqEngineLoginState());
        }
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvNonce() {
        m3086a("<<YHT2>> handleRecvNonce --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvServerInfo() {
        m3086a("<<YHT2>> handleRecvServerInfo --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogin() {
        m3086a("<<YHT2>> handleReqLogin --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogout() {
        m3086a("<<YHT2>> handleReqLogout");
        this.f3241b.handlePostLogout(this.f3241b.getLogoutState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginFailure() {
        m3086a("<<YHT2>> handleResEngineLoginFailure --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginSuccess() {
        m3086a("<<YHT2>> handleResEngineLoginSuccess --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLogoutSuccess() {
        m3086a("<<YHT2>> handleResEngineLogoutSuccess --- IGNORE!!");
    }
}
