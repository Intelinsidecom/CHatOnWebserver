package com.coolots.sse.join;

import com.sds.coolots.login.JoinManagerInterface;

/* loaded from: classes.dex */
public interface SSEJoinMainagerInterface extends JoinManagerInterface {
    void sendCreateAccessTokenAsk(String str);

    void sendSAUserInfoAsk(String str, String str2);

    void setSSEJoinMember(String str, String str2, String str3);

    void startJoin(String str);
}
