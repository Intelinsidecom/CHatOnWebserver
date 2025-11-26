package com.sds.coolots.login.model;

import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.LoginManager;

/* renamed from: com.sds.coolots.login.model.h */
/* loaded from: classes.dex */
public class C1289h implements LoginStateInterface {

    /* renamed from: a */
    public static final String f3238a = "[SendCipherKeyAskState]";

    /* renamed from: b */
    private final LoginManager f3239b;

    public C1289h(LoginManager loginManager) {
        this.f3239b = loginManager;
    }

    /* renamed from: a */
    private void m3085a(String str) {
        Log.m2958e(f3238a + str);
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleErrorEvent() {
        m3085a("<<YHT2>> handleErrorEvent");
        this.f3239b.setLogoutStateByError();
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvCipherKey() {
        this.f3239b.sendServerInfoAsk(this.f3239b.getSendServerInfoAskState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvLoginRep() {
        m3085a("<<YHT2>> handleRecvLoginRep --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvNonce() {
        m3085a("<<YHT2>> handleRecvNonce --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleRecvServerInfo() {
        m3085a("<<YHT2>> handleRecvServerInfo --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogin() {
        m3085a("<<YHT2>> handleReqLogin --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleReqLogout() {
        m3085a("<<YHT2>> handleReqLogout");
        this.f3239b.handlePostLogout(this.f3239b.getLogoutState());
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginFailure() {
        m3085a("<<YHT2>> handleResEngineLoginFailure --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLoginSuccess() {
        m3085a("<<YHT2>> handleResEngineLoginSuccess --- IGNORE!!");
    }

    @Override // com.sds.coolots.login.model.LoginStateInterface
    public void handleResEngineLogoutSuccess() {
        m3085a("<<YHT2>> handleResEngineLogoutSuccess --- IGNORE!!");
    }
}
