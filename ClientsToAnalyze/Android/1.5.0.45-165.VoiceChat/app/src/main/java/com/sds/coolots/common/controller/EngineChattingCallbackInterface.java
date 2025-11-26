package com.sds.coolots.common.controller;

import com.coolots.p2pmsg.model.MsgBody;

/* loaded from: classes.dex */
public interface EngineChattingCallbackInterface {
    boolean handleChattingMessage(MsgBody msgBody);

    void onRetrieveNote();

    void setFileCompleteInfo(String str, String str2, String str3, int i);

    void setFileProgressInfo(String str, String str2, String str3, int i, int i2, int i3);
}
