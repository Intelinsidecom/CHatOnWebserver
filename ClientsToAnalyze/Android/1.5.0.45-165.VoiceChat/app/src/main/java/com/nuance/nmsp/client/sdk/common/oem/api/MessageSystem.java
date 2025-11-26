package com.nuance.nmsp.client.sdk.common.oem.api;

import com.nuance.nmsp.client.sdk.common.oem.api.TimerSystem;

/* loaded from: classes.dex */
public interface MessageSystem {

    public static class MessageData {
        public byte command;
        public Object data;

        public MessageData(byte b, Object obj) {
            this.command = b;
            this.data = obj;
        }
    }

    public interface MessageHandler {
        void handleMessage(Object obj, Object obj2);
    }

    boolean cancelTask(TimerSystem.TimerSystemTask timerSystemTask);

    Object getMyAddr();

    int getNumOfVRThreads();

    Object[] getVRAddr();

    void scheduleTask(TimerSystem.TimerSystemTask timerSystemTask, long j);

    void send(Object obj, MessageHandler messageHandler, Object obj2, Object obj3);

    void setSessionId(byte[] bArr);

    void stop();
}
