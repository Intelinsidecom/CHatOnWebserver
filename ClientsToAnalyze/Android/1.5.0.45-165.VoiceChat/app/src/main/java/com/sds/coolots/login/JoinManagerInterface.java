package com.sds.coolots.login;

import android.os.Handler;
import com.sds.coolots.common.controller.EventHandlerInterface;

/* loaded from: classes.dex */
public interface JoinManagerInterface {
    public static final int PN_CONFIG = 2;
    public static final int PN_JOIN = 0;
    public static final int PN_NONUMBER = 1;

    void clearSmsAuth();

    void deleteAccount();

    void deleteAccountFromWeb();

    String getJoinID();

    String getJoinName();

    String getJoinPhoneNo();

    String getJoinPwd();

    String getSMSAuthID();

    void handleFinishLogin();

    void requestDuplicateCheck(String str);

    void requestServerPhoneNoAuthAsk(String str);

    void requestServerPhoneNoAuthSMS(Integer num, String str, Handler handler, Object obj, int i);

    void sendCipherKeyAsk();

    void setJoinActivity(EventHandlerInterface eventHandlerInterface);

    void setJoinMember(String str, String str2, String str3, String str4, String str5, String str6);

    void setJoinPhoneNoActivity(EventHandlerInterface eventHandlerInterface);

    void setMobileJoinParam(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7);
}
