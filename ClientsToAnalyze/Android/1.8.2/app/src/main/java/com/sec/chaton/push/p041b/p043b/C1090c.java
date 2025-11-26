package com.sec.chaton.push.p041b.p043b;

import com.google.protobuf.MessageLite;
import com.sec.chaton.push.util.C1136d;
import com.sec.chaton.push.util.C1139g;
import com.sec.p004a.p005a.p006a.C0072ap;
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
public class C1090c extends SimpleChannelHandler {

    /* renamed from: a */
    private static final String f4014a = C1090c.class.getSimpleName();

    /* renamed from: b */
    private InterfaceC1088a f4015b;

    /* renamed from: c */
    private InterfaceC1089b f4016c;

    /* renamed from: a */
    public InterfaceC1088a m4143a() {
        return this.f4015b;
    }

    /* renamed from: a */
    public void m4144a(InterfaceC1088a interfaceC1088a) {
        this.f4015b = interfaceC1088a;
    }

    /* renamed from: a */
    public void m4145a(InterfaceC1089b interfaceC1089b) {
        this.f4016c = interfaceC1089b;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelConnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4014a, "MessageChannelHandler.channelConnected()");
        }
        super.channelConnected(channelHandlerContext, channelStateEvent);
        if (this.f4015b != null) {
            this.f4015b.mo4131a();
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        Throwable th = null;
        if (C1139g.f4142a) {
            C1139g.m4308a(f4014a, "MessageChannelHandler.channelDisconnected()");
            if (channelHandlerContext.getAttachment() != null) {
                th = (Throwable) channelHandlerContext.getAttachment();
                C1139g.m4308a(f4014a, "Exception: " + th);
            }
        }
        if (C1139g.f4142a) {
            C1139g.m4308a(f4014a, String.format("Channel listener => %s.", this.f4015b));
        }
        if (this.f4015b != null) {
            this.f4015b.mo4132a(true, th);
        }
        super.channelDisconnected(channelHandlerContext, channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4014a, "MessageChannelHandler.writeRequested()");
        }
        MessageLite messageLite = (MessageLite) messageEvent.getMessage();
        if (C1139g.f4142a) {
            C1139g.m4308a(f4014a, "\n[Send message] (" + C0072ap.m285b(messageLite) + ") ===============\n" + C1136d.m4291a(messageLite) + "==============================");
        }
        Channels.write(channelHandlerContext, messageEvent.getFuture(), messageLite, messageEvent.getRemoteAddress());
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4014a, "MessageChannelHandler.messageReceived()");
        }
        MessageLite messageLite = (MessageLite) messageEvent.getMessage();
        if (C1139g.f4142a) {
            C1139g.m4308a(f4014a, "\n[Receive message] (" + C0072ap.m285b(messageLite) + ") ===============\n" + C1136d.m4291a(messageLite) + "==============================");
        }
        if (this.f4016c != null) {
            this.f4016c.mo4142a(messageEvent.getMessage());
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        if (C1139g.f4145d) {
            C1139g.m4309a(f4014a, "MessageChannelHandler.exceptionCaught()", exceptionEvent.getCause());
        }
        super.exceptionCaught(channelHandlerContext, exceptionEvent);
        Channel channel = exceptionEvent.getChannel();
        int iIntValue = channel.getId().intValue();
        Throwable cause = exceptionEvent.getCause();
        String string = cause == null ? "null" : cause.toString();
        channelHandlerContext.setAttachment(cause);
        if (cause instanceof SSLException) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f4014a, "SSL exception was caught in netty. Closing channel. { channelId = " + iIntValue + ", Throwable = " + string + " }");
            }
            if (string.contains("not an SSL/TLS record")) {
                new Thread(new RunnableC1091d(channel)).start();
            }
        }
    }
}
