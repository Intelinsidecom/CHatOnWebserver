package com.coolots.chaton.join;

import com.sds.coolots.login.JoinManagerInterface;

/* loaded from: classes.dex */
public interface ChatONJoinManagerInterface extends JoinManagerInterface {
    void deleteChatONVAccount();

    boolean isExistChatONVAccount();

    void requestPhoneNoAuth(Integer num, String str, String str2, boolean z, int i);

    void resetPhoneNoAuthInfo();

    @Override // com.sds.coolots.login.JoinManagerInterface
    void sendCipherKeyAsk();

    void sendCreateAccessTokenAsk(String str);

    void sendSAUserInfoAsk(String str, String str2);

    void setChatONJoinMember(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void startJoin(String str);
}
