package com.sds.coolots.login.model;

import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.LoginManager;

/* renamed from: com.sds.coolots.login.model.b */
/* loaded from: classes.dex */
public class C1283b implements LoginStateInterface {

    /* renamed from: a */
    public static final String f3226a = "[LoginState]";

    /* renamed from: b */
    private final LoginManager f3227b;

    public C1283b(LoginManager loginManager) {
        this.f3227b = loginManager;
    }

    /* renamed from: a */
    private void m3079a(String str) {
        Log.m2958e(f3226a + str);
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleErrorEvent() {
        m3079a("<<YHT2>> handleErrorEvent");
        this.f3227b.requestEngineLogout(this.f3227b.getReqEngineLogoutState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvCipherKey() {
        m3079a("<<YHT2>> handleRecvCipherKey --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvLoginRep() {
        m3079a("<<YHT2>> handleRecvLoginRep --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvNonce() {
        m3079a("<<YHT2>> handleRecvNonce --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvServerInfo() {
        m3079a("<<YHT2>> handleRecvServerInfo --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogin() {
        m3079a("<<YHT2>> handleReqLogin");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogout() {
        m3079a("<<YHT2>> handleReqLogout");
        this.f3227b.requestEngineLogout(this.f3227b.getReqEngineLogoutState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginFailure() {
        m3079a("<<YHT2>> handleResEngineLoginFailure");
        this.f3227b.requestEngineLogout(this.f3227b.getReqEngineLogoutState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginSuccess() {
        m3079a("<<YHT2>> handleResEngineLoginSuccess --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLogoutSuccess() {
        m3079a("<<YHT2>> handleResEngineLogoutSuccess --- IGNORE!!");
    }
}
