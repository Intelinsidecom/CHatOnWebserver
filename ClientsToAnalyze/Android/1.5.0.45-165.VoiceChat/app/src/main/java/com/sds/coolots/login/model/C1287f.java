package com.sds.coolots.login.model;

import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.LoginManager;

/* renamed from: com.sds.coolots.login.model.f */
/* loaded from: classes.dex */
public class C1287f implements LoginStateInterface {

    /* renamed from: a */
    public static final String f3234a = "[ReqEngineLoginState]";

    /* renamed from: b */
    private final LoginManager f3235b;

    public C1287f(LoginManager loginManager) {
        this.f3235b = loginManager;
    }

    /* renamed from: a */
    private void m3083a(String str) {
        Log.m2958e(f3234a + str);
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleErrorEvent() {
        m3083a("<<YHT2>> handleErrorEvent");
        this.f3235b.setReLoginState(this.f3235b.getEngineReLoginState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvCipherKey() {
        m3083a("<<YHT2>> handleRecvCipherKey --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvLoginRep() {
        m3083a("<<YHT2>> handleRecvLoginRep --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvNonce() {
        m3083a("<<YHT2>> handleRecvNonce --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvServerInfo() {
        m3083a("<<YHT2>> handleRecvServerInfo --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogin() {
        m3083a("<<YHT2>> handleReqLogin");
        this.f3235b.setReLoginState(this.f3235b.getEngineReLoginState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogout() {
        m3083a("<<YHT2>> handleReqLogout");
        this.f3235b.setReLoginState(this.f3235b.getEngineReLoginState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginFailure() {
        m3083a("<<YHT2>> handleResEngineLoginFailure");
        this.f3235b.requestEngineLogout(this.f3235b.getReqEngineLogoutState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginSuccess() {
        m3083a("<<YHT2>> handleResEngineLoginSuccess");
        this.f3235b.handlePostLogin(this.f3235b.getLoginState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLogoutSuccess() {
        m3083a("<<YHT2>> handleResEngineLogoutSuccess --- IGNORE!!");
    }
}
