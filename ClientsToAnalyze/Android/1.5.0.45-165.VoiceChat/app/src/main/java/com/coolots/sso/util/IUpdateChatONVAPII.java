package com.coolots.sso.util;

/* loaded from: classes.dex */
public interface IUpdateChatONVAPII {
    public static final int CRITICAL_UPDATE = 3;
    public static final int MINOR_UPDATE = 2;
    public static final int NORMAL_UPDATE = 1;
    public static final int SAME_VERSION = 0;

    void onReceiveUpdateVerion(String str, String str2, int i);
}
