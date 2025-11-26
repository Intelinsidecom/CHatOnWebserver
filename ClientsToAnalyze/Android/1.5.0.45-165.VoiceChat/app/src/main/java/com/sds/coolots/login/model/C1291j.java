package com.sds.coolots.login.model;

import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.LoginManager;

/* renamed from: com.sds.coolots.login.model.j */
/* loaded from: classes.dex */
public class C1291j implements LoginStateInterface {

    /* renamed from: a */
    public static final String f3242a = "[SendNonceAskState]";

    /* renamed from: b */
    private final LoginManager f3243b;

    public C1291j(LoginManager loginManager) {
        this.f3243b = loginManager;
    }

    /* renamed from: a */
    private void m3087a(String str) {
        Log.m2958e(f3242a + str);
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleErrorEvent() {
        m3087a("<<YHT2>> handleErrorEvent");
        this.f3243b.setLogoutStateByError();
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvCipherKey() {
        m3087a("<<YHT2>> handleRecvCipherKey --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvLoginRep() {
        m3087a("<<YHT2>> handleRecvLoginRep --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvNonce() {
        m3087a("<<YHT2>> handleRecvNonce");
        this.f3243b.sendLoginAsk(this.f3243b.getSendLoginAskState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvServerInfo() {
        m3087a("<<YHT2>> handleRecvServerInfo --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogin() {
        m3087a("<<YHT2>> handleReqLogin --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogout() {
        m3087a("<<YHT2>> handleReqLogout");
        this.f3243b.handlePostLogout(this.f3243b.getLogoutState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginFailure() {
        m3087a("<<YHT2>> handleResEngineLoginFailure --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginSuccess() {
        m3087a("<<YHT2>> handleResEngineLoginSuccess --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLogoutSuccess() {
        m3087a("<<YHT2>> handleResEngineLogoutSuccess --- IGNORE!!");
    }
}
