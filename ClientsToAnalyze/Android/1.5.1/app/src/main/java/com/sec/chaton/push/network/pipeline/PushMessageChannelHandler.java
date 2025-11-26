package com.sec.chaton.push.network.pipeline;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.exception.ConnectionException;
import com.sec.chaton.push.exception.PushClientException;
import com.sec.chaton.push.message.processer.MessageController;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.util.MessageUtil;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontend;
import com.sec.pns.msg.frontend.MsgFrontendCommon;
import java.nio.channels.ClosedChannelException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/* loaded from: classes.dex */
public class PushMessageChannelHandler extends SimpleChannelHandler {

    /* renamed from: a */
    private static final String f2770a = PushMessageChannelHandler.class.getSimpleName();

    /* renamed from: b */
    private final Map f2771b = new HashMap();

    /* renamed from: c */
    private HandlerThread f2772c;

    /* renamed from: d */
    private Handler f2773d;

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public synchronized void channelConnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        PushLog.m3025a(f2770a, "PushMessageChannelHandler.channelConnected()");
        super.channelConnected(channelHandlerContext, channelStateEvent);
        this.f2772c = new HandlerThread("PushReplyManagerThread");
        this.f2772c.start();
        this.f2773d = new HandlerC0396b(this, this.f2772c.getLooper());
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public synchronized void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        PushLog.m3025a(f2770a, "PushMessageChannelHandler.channelDisconnected()");
        Semaphore semaphore = new Semaphore(0);
        this.f2773d.sendMessage(Message.obtain(this.f2773d, 3, semaphore));
        PushLog.m3025a(f2770a, "Blocking thread until the cleanup logic is completed");
        semaphore.acquireUninterruptibly();
        PushLog.m3025a(f2770a, "Cleanup logic is completed");
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        PushLog.m3026a(f2770a, "PushMessageChannelHandler.exceptionCaught()", exceptionEvent.getCause());
        if (exceptionEvent.getCause() instanceof ClosedChannelException) {
            return;
        }
        exceptionEvent.getChannel().close();
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws PushClientException {
        MessageLite messageLite = (MessageLite) messageEvent.getMessage();
        PushLog.m3025a(f2770a, "\n[Receive message] (" + MsgFrontendCommon.getMessageName(messageLite) + ") ===============\n" + MessageUtil.m3020a(messageLite) + "==============================");
        if (!MessageUtil.m3022c(messageLite)) {
            if (MessageUtil.m3023d(messageLite)) {
                MessageController.m2911p().m2918a((MsgFrontend.NotiGroup) messageLite);
                return;
            } else {
                PushLog.m3031d(f2770a, "Unknown message type");
                return;
            }
        }
        try {
            String strValueOf = String.valueOf(MessageUtil.m3024e(messageLite));
            if (this.f2771b.containsKey(String.valueOf(strValueOf))) {
                this.f2773d.sendMessage(Message.obtain(this.f2773d, 2, new Object[]{strValueOf, messageLite}));
            } else {
                PushLog.m3030c(f2770a, "Notify async id doesn't exist( AsyncId: " + strValueOf + ")");
            }
        } catch (PushClientException e) {
            throw e;
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public synchronized void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        boolean z;
        PushLog.m3025a(f2770a, "PushMessageChannelHandler.writeRequested()");
        MessageContext messageContext = (MessageContext) messageEvent.getMessage();
        MessageLite messageLiteM2969a = messageContext.m2969a();
        PushLog.m3025a(f2770a, "\n[Send message] (" + MsgFrontendCommon.getMessageName(messageLiteM2969a) + ") ===============\n" + MessageUtil.m3020a(messageLiteM2969a) + "==============================");
        if (this.f2773d == null) {
            messageContext.m2970a(-2);
            messageEvent.getFuture().setFailure(new ConnectionException("Channel hadn't been establised."));
        } else {
            if (MessageUtil.m3021b(messageLiteM2969a)) {
                try {
                    this.f2773d.sendMessage(Message.obtain(this.f2773d, 1, new Object[]{String.valueOf(MessageUtil.m3024e(messageLiteM2969a)), messageContext, 60000L}));
                    z = true;
                } catch (PushClientException e) {
                    z = false;
                }
            } else {
                z = false;
            }
            if (!z) {
                messageEvent.getFuture().addListener(new C0397c(this, messageContext));
            }
            Channels.write(channelHandlerContext, messageEvent.getFuture(), messageLiteM2969a, messageEvent.getRemoteAddress());
        }
    }
}
