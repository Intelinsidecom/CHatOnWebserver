package com.sds.coolots.login.model;

import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.LoginManager;

/* renamed from: com.sds.coolots.login.model.a */
/* loaded from: classes.dex */
public class C1282a implements LoginStateInterface {

    /* renamed from: a */
    public static final String f3224a = "[EngineReLoginState]";

    /* renamed from: b */
    private final LoginManager f3225b;

    public C1282a(LoginManager loginManager) {
        this.f3225b = loginManager;
    }

    /* renamed from: a */
    private void m3078a(String str) {
        Log.m2958e(f3224a + str);
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleErrorEvent() {
        m3078a("<<YHT2>> handleErrorEvent --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvCipherKey() {
        m3078a("<<YHT2>> handleRecvCipherKey --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvLoginRep() {
        m3078a("<<YHT2>> handleRecvLoginRep --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvNonce() {
        m3078a("<<YHT2>> handleRecvNonce --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvServerInfo() {
        m3078a("<<YHT2>> handleRecvServerInfo --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogin() {
        m3078a("<<YHT2>> handleReqLogin --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogout() {
        m3078a("<<YHT2>> handleReqLogout --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginFailure() {
        m3078a("<<YHT2>> handleResEngineLoginFailure");
        this.f3225b.requestEngineLogout(this.f3225b.getReqEngineLogoutState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginSuccess() {
        m3078a("<<YHT2>> handleResEngineLoginSuccess");
        this.f3225b.requestEngineLogout(this.f3225b.getReqEngineLogoutState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLogoutSuccess() {
        m3078a("<<YHT2>> handleResEngineLogoutSuccess --- IGNORE!!");
    }
}
