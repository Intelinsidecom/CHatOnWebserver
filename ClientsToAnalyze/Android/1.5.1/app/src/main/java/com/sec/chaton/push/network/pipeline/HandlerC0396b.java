package com.sec.chaton.push.network.pipeline;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.util.PushLog;
import java.util.Iterator;
import java.util.concurrent.Semaphore;

/* renamed from: com.sec.chaton.push.network.pipeline.b */
/* loaded from: classes.dex */
class HandlerC0396b extends Handler {

    /* renamed from: a */
    final /* synthetic */ PushMessageChannelHandler f2775a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0396b(PushMessageChannelHandler pushMessageChannelHandler, Looper looper) {
        super(looper);
        this.f2775a = pushMessageChannelHandler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            Object[] objArr = (Object[]) message.obj;
            String str = (String) objArr[0];
            MessageContext messageContext = (MessageContext) objArr[1];
            long jLongValue = ((Long) objArr[2]).longValue();
            PushLog.m3025a(PushMessageChannelHandler.f2770a, "Register( AsyncId: " + str + ", Timeout: " + jLongValue + " )");
            this.f2775a.f2771b.put(str, messageContext);
            this.f2775a.f2773d.sendMessageDelayed(this.f2775a.f2773d.obtainMessage(4, str), jLongValue);
            return;
        }
        if (message.what == 2) {
            Object[] objArr2 = (Object[]) message.obj;
            String str2 = (String) objArr2[0];
            MessageLite messageLite = (MessageLite) objArr2[1];
            PushLog.m3025a(PushMessageChannelHandler.f2770a, "Notify( AsyncId: " + str2 + " )");
            removeMessages(4, str2);
            if (this.f2775a.f2771b.containsKey(str2)) {
                ((MessageContext) this.f2775a.f2771b.remove(str2)).m2974b(messageLite);
                return;
            } else {
                PushLog.m3030c(PushMessageChannelHandler.f2770a, "Notify async id doesn't exist( AsyncId: " + str2 + ")");
                return;
            }
        }
        if (message.what == 4) {
            String str3 = (String) message.obj;
            if (this.f2775a.f2771b.containsKey(str3)) {
                PushLog.m3025a(PushMessageChannelHandler.f2770a, "Timeout( AsyncId: " + str3 + " )");
                ((MessageContext) this.f2775a.f2771b.remove(str3)).m2970a(-1);
                return;
            }
            return;
        }
        if (message.what == 3) {
            Semaphore semaphore = (Semaphore) message.obj;
            try {
                removeMessages(4);
                Iterator it = this.f2775a.f2771b.keySet().iterator();
                while (it.hasNext()) {
                    ((MessageContext) this.f2775a.f2771b.get((String) it.next())).m2970a(-2);
                }
                this.f2775a.f2771b.clear();
            } finally {
                this.f2775a.f2772c.quit();
                this.f2775a.f2772c = null;
                this.f2775a.f2773d = null;
                semaphore.release();
            }
        }
    }
}
