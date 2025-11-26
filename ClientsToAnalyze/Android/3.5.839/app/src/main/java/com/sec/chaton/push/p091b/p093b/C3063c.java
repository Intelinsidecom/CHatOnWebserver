package com.sec.chaton.push.p091b.p093b;

import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.C3112d;
import com.sec.chaton.push.util.C3115g;
import com.sec.p043a.p044a.p045a.C0749ap;
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
public class C3063c extends SimpleChannelHandler {

    /* renamed from: a */
    private static final String f11327a = C3063c.class.getSimpleName();

    /* renamed from: b */
    private InterfaceC3061a f11328b;

    /* renamed from: c */
    private InterfaceC3062b f11329c;

    /* renamed from: a */
    public InterfaceC3061a m12529a() {
        return this.f11328b;
    }

    /* renamed from: a */
    public void m12530a(InterfaceC3061a interfaceC3061a) {
        this.f11328b = interfaceC3061a;
    }

    /* renamed from: a */
    public void m12531a(InterfaceC3062b interfaceC3062b) {
        this.f11329c = interfaceC3062b;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelConnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11327a, "MessageChannelHandler.channelConnected()");
        }
        super.channelConnected(channelHandlerContext, channelStateEvent);
        if (this.f11328b != null) {
            this.f11328b.mo12518a();
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        Throwable th = null;
        if (C3115g.f11458a) {
            C3115g.m12701a(f11327a, "MessageChannelHandler.channelDisconnected()");
            if (channelHandlerContext.getAttachment() != null) {
                th = (Throwable) channelHandlerContext.getAttachment();
                C3115g.m12701a(f11327a, "Exception: " + th);
            }
        }
        if (C3115g.f11458a) {
            C3115g.m12701a(f11327a, String.format("Channel listener => %s.", this.f11328b));
        }
        if (this.f11328b != null) {
            this.f11328b.mo12519a(true, th);
        }
        super.channelDisconnected(channelHandlerContext, channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11327a, "MessageChannelHandler.writeRequested()");
        }
        MessageLite messageLite = (MessageLite) messageEvent.getMessage();
        if (C3115g.f11458a) {
            C3115g.m12701a(f11327a, "\n[Send message] (" + C0749ap.m2529b(messageLite) + ") ===============\n" + C3112d.m12684a(messageLite) + "==============================");
        }
        Channels.write(channelHandlerContext, messageEvent.getFuture(), messageLite, messageEvent.getRemoteAddress());
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11327a, "MessageChannelHandler.messageReceived()");
        }
        MessageLite messageLite = (MessageLite) messageEvent.getMessage();
        if (C3115g.f11458a) {
            C3115g.m12701a(f11327a, "\n[Receive message] (" + C0749ap.m2529b(messageLite) + ") ===============\n" + C3112d.m12684a(messageLite) + "==============================");
        }
        if (this.f11329c != null) {
            this.f11329c.mo12528a(messageEvent.getMessage());
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        if (C3115g.f11461d) {
            C3115g.m12702a(f11327a, "MessageChannelHandler.exceptionCaught()", exceptionEvent.getCause());
        }
        super.exceptionCaught(channelHandlerContext, exceptionEvent);
        Channel channel = exceptionEvent.getChannel();
        int iIntValue = channel.getId().intValue();
        Throwable cause = exceptionEvent.getCause();
        String string = cause == null ? "null" : cause.toString();
        channelHandlerContext.setAttachment(cause);
        if (cause instanceof SSLException) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11327a, "SSL exception was caught in netty. Closing channel. { channelId = " + iIntValue + ", Throwable = " + string + " }");
            }
            if (string.contains("not an SSL/TLS record")) {
                new Thread(new RunnableC3064d(channel)).start();
            }
        }
    }
}
