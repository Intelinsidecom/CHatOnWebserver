package com.sec.chaton.push.network.pipeline;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontend;
import com.sec.pns.msg.frontend.MsgFrontendCommon;
import java.util.concurrent.Semaphore;
import org.jboss.netty.channel.Channel;

/* renamed from: com.sec.chaton.push.network.pipeline.d */
/* loaded from: classes.dex */
class HandlerC0398d extends Handler {

    /* renamed from: a */
    final /* synthetic */ ProvMessageChannelHandler f2778a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0398d(ProvMessageChannelHandler provMessageChannelHandler, Looper looper) {
        super(looper);
        this.f2778a = provMessageChannelHandler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            Object[] objArr = (Object[]) message.obj;
            Channel channel = (Channel) objArr[0];
            MessageContext messageContext = (MessageContext) objArr[1];
            long jLongValue = ((Long) objArr[2]).longValue();
            PushLog.m3025a(ProvMessageChannelHandler.f2762a, "Register( Channel: " + channel + ", Timeout: " + jLongValue + " )");
            this.f2778a.f2765d.put(channel, messageContext);
            this.f2778a.f2764c.sendMessageDelayed(this.f2778a.f2764c.obtainMessage(4, channel), jLongValue);
            return;
        }
        if (message.what != 2) {
            if (message.what != 3) {
                if (message.what == 4) {
                    Channel channel2 = (Channel) message.obj;
                    if (this.f2778a.f2765d.containsKey(channel2)) {
                        PushLog.m3025a(ProvMessageChannelHandler.f2762a, "Timeout( Channel: " + channel2 + " )");
                        ((MessageContext) this.f2778a.f2765d.remove(channel2)).m2970a(-1);
                        return;
                    }
                    return;
                }
                return;
            }
            Object[] objArr2 = (Object[]) message.obj;
            Channel channel3 = (Channel) objArr2[0];
            Semaphore semaphore = (Semaphore) objArr2[1];
            try {
                removeMessages(4, channel3);
                MessageContext messageContext2 = (MessageContext) this.f2778a.f2765d.remove(channel3);
                if (messageContext2 != null) {
                    messageContext2.m2970a(-2);
                }
                return;
            } finally {
                this.f2778a.f2763b.quit();
                this.f2778a.f2763b = null;
                this.f2778a.f2764c = null;
                semaphore.release();
            }
        }
        Object[] objArr3 = (Object[]) message.obj;
        Channel channel4 = (Channel) objArr3[0];
        MessageLite messageLite = (MessageLite) objArr3[1];
        PushLog.m3025a(ProvMessageChannelHandler.f2762a, "Notify( Channel: " + channel4 + " )");
        removeMessages(4, channel4);
        if (MsgFrontendCommon.getMessageType(messageLite) == 12) {
            if (this.f2778a.f2765d.containsKey(channel4)) {
                ((MessageContext) this.f2778a.f2765d.remove(channel4)).m2974b(messageLite);
                return;
            } else {
                PushLog.m3030c(ProvMessageChannelHandler.f2762a, "Notify channel doesn't exist( Channel: " + channel4 + ")");
                return;
            }
        }
        if (MsgFrontendCommon.getMessageType(messageLite) == 9) {
            PushLog.m3031d(ProvMessageChannelHandler.f2762a, "The type of reply message isn't ProvisionReply");
            MsgFrontend.NotiGroup notiGroup = (MsgFrontend.NotiGroup) messageLite;
            if (notiGroup.getNotiElementsCount() > 0) {
                String message2 = notiGroup.getNotiElements(0).getMessage();
                String[] strArrSplit = message2.split("#");
                PushLog.m3031d(ProvMessageChannelHandler.f2762a, "Error message: " + message2);
                if (this.f2778a.f2765d.containsKey(channel4)) {
                    ((MessageContext) this.f2778a.f2765d.remove(channel4)).m2970a(Integer.valueOf(strArrSplit[0]).intValue());
                } else {
                    PushLog.m3030c(ProvMessageChannelHandler.f2762a, "Notify channel doesn't exist( Channel: " + channel4 + ")");
                }
            }
        }
    }
}
