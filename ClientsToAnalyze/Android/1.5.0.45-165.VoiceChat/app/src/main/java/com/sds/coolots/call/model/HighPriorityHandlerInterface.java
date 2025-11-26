package com.sds.coolots.call.model;

import android.os.Message;

/* loaded from: classes.dex */
public interface HighPriorityHandlerInterface {
    void removeMessages(int i);

    void sendEmptyMessage(int i);

    void sendEmptyMessageDelayed(int i, long j);

    void sendMessage(Message message);

    void sendMessageDelayed(Message message, long j);
}
