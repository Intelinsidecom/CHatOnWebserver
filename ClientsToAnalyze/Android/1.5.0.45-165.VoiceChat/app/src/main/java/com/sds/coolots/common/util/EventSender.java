package com.sds.coolots.common.util;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes.dex */
public class EventSender {
    public void sendEvent(int i, int i2, int i3, Object obj, Handler handler) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        messageObtain.arg1 = i2;
        messageObtain.arg2 = i3;
        messageObtain.obj = obj;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }
}
