package com.sds.coolots.call;

import android.os.Message;

/* loaded from: classes.dex */
public interface CallingInterface {
    boolean isUseFrontCamera();

    void sendHandlerMessage(Message message, long j);
}
