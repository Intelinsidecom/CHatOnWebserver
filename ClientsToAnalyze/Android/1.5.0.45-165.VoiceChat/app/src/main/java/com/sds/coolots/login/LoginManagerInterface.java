package com.sds.coolots.login;

import android.os.Handler;
import com.sds.coolots.common.controller.EventHandlerInterface;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface LoginManagerInterface {
    void changePassword(String str);

    void checkNonceExpiredTimePassed();

    void deleteNonce();

    void handleServicePolicyInfo();

    boolean isDuringLogin();

    boolean isLogin();

    boolean isValidNonce();

    void login();

    void logout(boolean z);

    void notifyAbsenceToServer(Handler handler);

    void requestServerSearchableAsk(Handler handler);

    void resetServerInfo();

    void sendCipherKeyAsk();

    void sendNonceAsk();

    void sendServerInfoAsk();

    ArrayList serverInfo();

    void setLoginActivity(EventHandlerInterface eventHandlerInterface);

    void setLogoutState();

    void setNonce(String str);
}
