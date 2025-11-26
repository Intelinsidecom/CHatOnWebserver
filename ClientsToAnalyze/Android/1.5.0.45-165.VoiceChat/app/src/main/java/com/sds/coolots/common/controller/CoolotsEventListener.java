package com.sds.coolots.common.controller;

import android.os.Message;

/* loaded from: classes.dex */
public interface CoolotsEventListener {
    void onCallEvent(Message message);

    void onCallState(boolean z);

    void onLoginEvent(Message message);
}
