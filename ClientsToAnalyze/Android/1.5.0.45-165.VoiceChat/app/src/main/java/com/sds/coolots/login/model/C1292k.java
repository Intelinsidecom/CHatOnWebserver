package com.sds.coolots.login.model;

import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.LoginManager;

/* renamed from: com.sds.coolots.login.model.k */
/* loaded from: classes.dex */
public class C1292k implements LoginStateInterface {

    /* renamed from: a */
    public static final String f3244a = "[SendServerInfoAskState]";

    /* renamed from: b */
    private final LoginManager f3245b;

    public C1292k(LoginManager loginManager) {
        this.f3245b = loginManager;
    }

    /* renamed from: a */
    private void m3088a(String str) {
        Log.m2958e(f3244a + str);
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleErrorEvent() {
        m3088a("<<YHT2>> handleErrorEvent");
        this.f3245b.setLogoutStateByError();
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvCipherKey() {
        m3088a("<<YHT2>> handleRecvCipherKey --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvLoginRep() {
        m3088a("<<YHT2>> handleRecvLoginRep --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvNonce() {
        m3088a("<<YHT2>> handleRecvNonce --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvServerInfo() {
        m3088a("<<YHT2>> handleRecvServerInfo");
        this.f3245b.sendDeviceIDAsk(this.f3245b.getSendNonceAskState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogin() {
        m3088a("<<YHT2>> handleReqLogin --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogout() {
        m3088a("<<YHT2>> handleReqLogout");
        this.f3245b.handlePostLogout(this.f3245b.getLogoutState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginFailure() {
        m3088a("<<YHT2>> handleResEngineLoginFailure --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginSuccess() {
        m3088a("<<YHT2>> handleResEngineLoginSuccess --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLogoutSuccess() {
        m3088a("<<YHT2>> handleResEngineLogoutSuccess --- IGNORE!!");
    }
}
