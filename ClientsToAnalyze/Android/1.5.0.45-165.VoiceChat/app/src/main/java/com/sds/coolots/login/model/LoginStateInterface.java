package com.sds.coolots.login.model;

/* loaded from: classes.dex */
public interface LoginStateInterface {
    void handleErrorEvent();

    void handleRecvCipherKey();

    void handleRecvLoginRep();

    void handleRecvNonce();

    void handleRecvServerInfo();

    void handleReqLogin();

    void handleReqLogout();

    void handleResEngineLoginFailure();

    void handleResEngineLoginSuccess();

    void handleResEngineLogoutSuccess();
}
