package com.sds.coolots.common.coolotsinterface;

/* loaded from: classes.dex */
public interface NativeCallInterface {
    void hangUpCurrent3gCall();

    void hangUpIncomingCall();

    boolean isCurrentCall();

    void noticeVoipDisconnecting(String str, String str2);
}
