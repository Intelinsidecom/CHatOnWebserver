package com.sec.chaton.push.p035a.p036a;

import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.C0919e;
import com.sec.chaton.push.util.C0921g;
import com.sec.p004a.p005a.p006a.C0068ab;
import javax.net.ssl.SSLException;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/* compiled from: MessageChannelHandler.java */
/* renamed from: com.sec.chaton.push.a.a.g */
/* loaded from: classes.dex */
public class C0859g extends SimpleChannelHandler {

    /* renamed from: a */
    private static final String f2976a = C0859g.class.getSimpleName();

    /* renamed from: b */
    private InterfaceC0855c f2977b;

    /* renamed from: c */
    private InterfaceC0862j f2978c;

    /* renamed from: a */
    public InterfaceC0855c m3451a() {
        return this.f2977b;
    }

    /* renamed from: a */
    public void m3452a(InterfaceC0855c interfaceC0855c) {
        this.f2977b = interfaceC0855c;
    }

    /* renamed from: a */
    public void m3453a(InterfaceC0862j interfaceC0862j) {
        this.f2978c = interfaceC0862j;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelConnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f2976a, "MessageChannelHandler.channelConnected()");
        }
        super.channelConnected(channelHandlerContext, channelStateEvent);
        if (this.f2977b != null) {
            this.f2977b.mo3448a();
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        Throwable th = null;
        if (C0921g.f3116a) {
            C0921g.m3637a(f2976a, "MessageChannelHandler.channelDisconnected()");
            if (channelHandlerContext.getAttachment() != null) {
                th = (Throwable) channelHandlerContext.getAttachment();
                C0921g.m3637a(f2976a, "Exception: " + th);
            }
        }
        if (C0921g.f3116a) {
            C0921g.m3637a(f2976a, String.format("Channel listener => %s.", this.f2977b));
        }
        if (this.f2977b != null) {
            this.f2977b.mo3449a(true, th);
        }
        super.channelDisconnected(channelHandlerContext, channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f2976a, "MessageChannelHandler.writeRequested()");
        }
        MessageLite messageLite = (MessageLite) messageEvent.getMessage();
        if (C0921g.f3116a) {
            C0921g.m3637a(f2976a, "\n[Send message] (" + C0068ab.m107b(messageLite) + ") ===============\n" + C0919e.m3621a(messageLite) + "==============================");
        }
        Channels.write(channelHandlerContext, messageEvent.getFuture(), messageLite, messageEvent.getRemoteAddress());
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f2976a, "MessageChannelHandler.messageReceived()");
        }
        MessageLite messageLite = (MessageLite) messageEvent.getMessage();
        if (C0921g.f3116a) {
            C0921g.m3637a(f2976a, "\n[Receive message] (" + C0068ab.m107b(messageLite) + ") ===============\n" + C0919e.m3621a(messageLite) + "==============================");
        }
        if (this.f2978c != null) {
            this.f2978c.mo3454a(messageEvent.getMessage());
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        if (C0921g.f3119d) {
            C0921g.m3638a(f2976a, "MessageChannelHandler.exceptionCaught()", exceptionEvent.getCause());
        }
        super.exceptionCaught(channelHandlerContext, exceptionEvent);
        Channel channel = exceptionEvent.getChannel();
        int iIntValue = channel.getId().intValue();
        Throwable cause = exceptionEvent.getCause();
        String string = cause == null ? "null" : cause.toString();
        channelHandlerContext.setAttachment(cause);
        if (cause instanceof SSLException) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f2976a, "SSL exception was caught in netty. Closing channel. { channelId = " + iIntValue + ", Throwable = " + string + " }");
            }
            if (string.contains("not an SSL/TLS record")) {
                new Thread(new RunnableC0857e(channel)).start();
            }
        }
    }
}
