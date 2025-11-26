package com.sds.coolots.login;

import com.sds.coolots.common.controller.PushReceiveInterface;
import com.sds.coolots.login.model.C1286e;

/* loaded from: classes.dex */
public interface PushManagerInterface {
    C1286e getFirstSavedPushMessage();

    PushReceiveInterface getReceiveInterface();

    void onReceivePushMessage(int i, String str);

    void reRegister();

    void registerDevice(String str, Short sh, PushReceiveInterface pushReceiveInterface);

    void setErrorCode(int i);

    void setRegisterStatus(boolean z, String str);

    void unregisterDevice();
}
