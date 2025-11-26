package com.sds.coolots.common.controller;

/* loaded from: classes.dex */
public interface PushReceiveInterface {
    public static final int PUSH_MSG_TYPE_BASE64_PB = 3;
    public static final int PUSH_MSG_TYPE_JASON = 1;
    public static final int PUSH_MSG_TYPE_PROTOCOLBUFFER = 2;
    public static final int PUSH_MSG_TYPE_XML = 0;

    void onReceivePushMessage(int i, String str, boolean z);
}
