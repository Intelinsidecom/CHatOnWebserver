package com.nuance.nmsp.client.sdk.oem;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem;
import com.nuance.nmsp.client.sdk.common.oem.api.TimerSystem;
import java.util.Vector;

/* loaded from: classes.dex */
public class MessageSystemOEM implements MessageSystem {

    /* renamed from: a */
    private static final LogFactory.Log f310a = LogFactory.getLog(MessageSystemOEM.class);

    /* renamed from: b */
    private Object f311b = new Object();

    /* renamed from: c */
    private Vector f312c = new Vector();

    /* renamed from: d */
    private TimerSystemOEM f313d = new TimerSystemOEM();

    public static class Message {
        public Object msgData;
        public MessageSystem.MessageHandler msgHandler;
        public Thread msgReceiver;
        public Thread msgSender;

        public Message(Object obj, MessageSystem.MessageHandler messageHandler) {
            this.msgData = obj;
            this.msgHandler = messageHandler;
        }
    }

    public static void terminate() {
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem
    public boolean cancelTask(TimerSystem.TimerSystemTask timerSystemTask) {
        boolean zCancel;
        boolean z = false;
        synchronized (this.f311b) {
            if (this.f313d != null) {
                zCancel = this.f313d.cancel(timerSystemTask);
            } else {
                z = true;
                zCancel = false;
            }
        }
        if (z && f310a.isDebugEnabled()) {
            f310a.debug("MessageSystemOEM.cancelTask() timer already stopped!");
        }
        return zCancel;
    }

    public Message createMessage(Object obj, MessageSystem.MessageHandler messageHandler) {
        return new Message(obj, messageHandler);
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem
    public Object getMyAddr() {
        return Thread.currentThread();
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem
    public int getNumOfVRThreads() {
        return 1;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem
    public Object[] getVRAddr() {
        return new Object[]{Thread.currentThread()};
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem
    public void scheduleTask(TimerSystem.TimerSystemTask timerSystemTask, long j) {
        boolean z = false;
        synchronized (this.f311b) {
            if (this.f313d != null) {
                this.f313d.schedule(timerSystemTask, j);
            } else {
                z = true;
            }
        }
        if (z && f310a.isDebugEnabled()) {
            f310a.debug("MessageSystemOEM.scheduleTask() timer already stopped!");
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem
    public void send(Object obj, MessageSystem.MessageHandler messageHandler, Object obj2, Object obj3) {
        Message messageCreateMessage = createMessage(obj, messageHandler);
        messageCreateMessage.msgReceiver = (Thread) obj3;
        messageCreateMessage.msgSender = (Thread) obj2;
        TimerSystem.TimerSystemTask timerSystemTask = new TimerSystem.TimerSystemTask() { // from class: com.nuance.nmsp.client.sdk.oem.MessageSystemOEM.1
            @Override // java.lang.Runnable
            public final void run() {
                Message message = null;
                try {
                    synchronized (MessageSystemOEM.this.f311b) {
                        if (!MessageSystemOEM.this.f312c.isEmpty()) {
                            message = (Message) MessageSystemOEM.this.f312c.elementAt(0);
                            MessageSystemOEM.this.f312c.removeElementAt(0);
                        }
                    }
                    if (message != null) {
                        if (message.msgHandler == null) {
                            if (MessageSystemOEM.f310a.isErrorEnabled()) {
                                MessageSystemOEM.f310a.error("MessageSystemOEM.send() msg.msgHandler is null");
                            }
                        } else {
                            if (MessageSystemOEM.f310a.isTraceEnabled()) {
                                MessageSystemOEM.f310a.trace("Executing Message");
                            }
                            message.msgHandler.handleMessage(message.msgData, message.msgSender);
                            if (MessageSystemOEM.f310a.isTraceEnabled()) {
                                MessageSystemOEM.f310a.trace("Done Executing Message");
                            }
                        }
                    }
                } catch (Exception e) {
                    if (MessageSystemOEM.f310a.isErrorEnabled()) {
                        MessageSystemOEM.f310a.error("MessageSystemOEM.send() " + e.getClass().getName() + " " + e.getMessage());
                    }
                }
            }
        };
        boolean z = false;
        synchronized (this.f311b) {
            if (this.f313d != null) {
                this.f312c.addElement(messageCreateMessage);
                scheduleTask(timerSystemTask, 0L);
            } else {
                z = true;
            }
        }
        if (z && f310a.isDebugEnabled()) {
            f310a.debug("MessageSystemOEM.send() timer already stopped!");
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem
    public void setSessionId(byte[] bArr) {
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem
    public void stop() {
        boolean z = false;
        synchronized (this.f311b) {
            if (this.f313d != null) {
                this.f313d.stop();
                this.f313d = null;
                this.f312c.removeAllElements();
                this.f312c = null;
            } else {
                z = true;
            }
        }
        if (z && f310a.isDebugEnabled()) {
            f310a.debug("MessageSystemOEM.stop() timer already stopped!");
        }
    }
}
