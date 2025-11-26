package com.coolots.p000fs.join;

import com.sds.coolots.login.JoinManagerInterface;

/* loaded from: classes.dex */
public interface FSJoinMainagerInterface extends JoinManagerInterface {
    void sendCreateAccessTokenAsk(String str);

    void sendSAUserInfoAsk(String str, String str2);

    void setFSJoinMember(String str, String str2, String str3);

    void startJoin(String str);
}
