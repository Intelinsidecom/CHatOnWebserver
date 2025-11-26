package com.sec.chaton.push.p051b.p053b;

import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.C2112d;
import com.sec.chaton.push.util.C2115g;
import com.sec.p013a.p014a.p015a.C0236ap;
import javax.net.ssl.SSLException;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/* compiled from: MessageChannelHandler.java */
/* renamed from: com.sec.chaton.push.b.b.c */
/* loaded from: classes.dex */
public class C2063c extends SimpleChannelHandler {

    /* renamed from: a */
    private static final String f7917a = C2063c.class.getSimpleName();

    /* renamed from: b */
    private InterfaceC2061a f7918b;

    /* renamed from: c */
    private InterfaceC2062b f7919c;

    /* renamed from: a */
    public InterfaceC2061a m8186a() {
        return this.f7918b;
    }

    /* renamed from: a */
    public void m8187a(InterfaceC2061a interfaceC2061a) {
        this.f7918b = interfaceC2061a;
    }

    /* renamed from: a */
    public void m8188a(InterfaceC2062b interfaceC2062b) {
        this.f7919c = interfaceC2062b;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelConnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7917a, "MessageChannelHandler.channelConnected()");
        }
        super.channelConnected(channelHandlerContext, channelStateEvent);
        if (this.f7918b != null) {
            this.f7918b.mo8175a();
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        Throwable th = null;
        if (C2115g.f8048a) {
            C2115g.m8359a(f7917a, "MessageChannelHandler.channelDisconnected()");
            if (channelHandlerContext.getAttachment() != null) {
                th = (Throwable) channelHandlerContext.getAttachment();
                C2115g.m8359a(f7917a, "Exception: " + th);
            }
        }
        if (C2115g.f8048a) {
            C2115g.m8359a(f7917a, String.format("Channel listener => %s.", this.f7918b));
        }
        if (this.f7918b != null) {
            this.f7918b.mo8176a(true, th);
        }
        super.channelDisconnected(channelHandlerContext, channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7917a, "MessageChannelHandler.writeRequested()");
        }
        MessageLite messageLite = (MessageLite) messageEvent.getMessage();
        if (C2115g.f8048a) {
            C2115g.m8359a(f7917a, "\n[Send message] (" + C0236ap.m797b(messageLite) + ") ===============\n" + C2112d.m8342a(messageLite) + "==============================");
        }
        Channels.write(channelHandlerContext, messageEvent.getFuture(), messageLite, messageEvent.getRemoteAddress());
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7917a, "MessageChannelHandler.messageReceived()");
        }
        MessageLite messageLite = (MessageLite) messageEvent.getMessage();
        if (C2115g.f8048a) {
            C2115g.m8359a(f7917a, "\n[Receive message] (" + C0236ap.m797b(messageLite) + ") ===============\n" + C2112d.m8342a(messageLite) + "==============================");
        }
        if (this.f7919c != null) {
            this.f7919c.mo8185a(messageEvent.getMessage());
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        if (C2115g.f8051d) {
            C2115g.m8360a(f7917a, "MessageChannelHandler.exceptionCaught()", exceptionEvent.getCause());
        }
        super.exceptionCaught(channelHandlerContext, exceptionEvent);
        Channel channel = exceptionEvent.getChannel();
        int iIntValue = channel.getId().intValue();
        Throwable cause = exceptionEvent.getCause();
        String string = cause == null ? "null" : cause.toString();
        channelHandlerContext.setAttachment(cause);
        if (cause instanceof SSLException) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7917a, "SSL exception was caught in netty. Closing channel. { channelId = " + iIntValue + ", Throwable = " + string + " }");
            }
            if (string.contains("not an SSL/TLS record")) {
                new Thread(new RunnableC2064d(channel)).start();
            }
        }
    }
}
