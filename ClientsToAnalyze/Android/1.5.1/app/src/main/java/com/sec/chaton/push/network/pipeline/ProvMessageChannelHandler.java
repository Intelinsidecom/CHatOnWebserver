package com.sec.chaton.push.network.pipeline;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.protobuf.MessageLite;
import com.sec.chaton.push.network.MessageContext;
import com.sec.chaton.push.util.MessageUtil;
import com.sec.chaton.push.util.PushLog;
import com.sec.pns.msg.frontend.MsgFrontendCommon;
import java.nio.channels.ClosedChannelException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/* loaded from: classes.dex */
public class ProvMessageChannelHandler extends SimpleChannelHandler {

    /* renamed from: a */
    private static final String f2762a = ProvMessageChannelHandler.class.getSimpleName();

    /* renamed from: c */
    private Handler f2764c;

    /* renamed from: d */
    private Map f2765d = new ConcurrentHashMap();

    /* renamed from: b */
    private HandlerThread f2763b = new HandlerThread("ProvReplyManagerThread");

    public ProvMessageChannelHandler() {
        this.f2763b.start();
        this.f2764c = new HandlerC0398d(this, this.f2763b.getLooper());
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        PushLog.m3025a(f2762a, "ProvMessageChannelHandler.channelDisconnected()");
        Semaphore semaphore = new Semaphore(0);
        this.f2764c.sendMessage(Message.obtain(this.f2764c, 3, new Object[]{channelHandlerContext.getChannel(), semaphore}));
        PushLog.m3025a(f2762a, "Blocking thread until the cleanup logic is completed");
        semaphore.acquireUninterruptibly();
        PushLog.m3025a(f2762a, "Cleanup logic is completed");
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        PushLog.m3026a(f2762a, "ProvMessageChannelHandler.exceptionCaucht()", exceptionEvent.getCause());
        if (exceptionEvent.getCause() instanceof ClosedChannelException) {
            return;
        }
        exceptionEvent.getChannel().close();
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        PushLog.m3025a(f2762a, "ProvMessageChannelHandler.messageReceived()");
        MessageLite messageLite = (MessageLite) messageEvent.getMessage();
        PushLog.m3025a(f2762a, "\n[Send message] (" + MsgFrontendCommon.getMessageName(messageLite) + ") ===============\n" + MessageUtil.m3020a(messageLite) + "==============================");
        this.f2764c.sendMessage(Message.obtain(this.f2764c, 2, new Object[]{messageEvent.getChannel(), messageLite}));
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        PushLog.m3025a(f2762a, "ProvMessageChannelHandler.writeRequested()");
        MessageContext messageContext = (MessageContext) messageEvent.getMessage();
        MessageLite messageLiteM2969a = messageContext.m2969a();
        PushLog.m3025a(f2762a, "\n[Send message] (" + MsgFrontendCommon.getMessageName(messageLiteM2969a) + ") ===============\n" + MessageUtil.m3020a(messageLiteM2969a) + "==============================");
        this.f2764c.sendMessage(Message.obtain(this.f2764c, 1, new Object[]{channelHandlerContext.getChannel(), messageContext, 60000L}));
        Channels.write(channelHandlerContext, messageEvent.getFuture(), messageLiteM2969a, messageEvent.getRemoteAddress());
    }
}
