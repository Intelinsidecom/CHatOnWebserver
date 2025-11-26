package com.sec.chaton.p022h.p026d;

import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0804n;
import com.sec.chaton.p022h.C0816z;
import com.sec.chaton.util.C1786r;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.channels.UnresolvedAddressException;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.WriteCompletionEvent;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.group.DefaultChannelGroup;

/* compiled from: TcpClientChannelHandler.java */
/* renamed from: com.sec.chaton.h.d.g */
/* loaded from: classes.dex */
public class C0791g extends SimpleChannelHandler {

    /* renamed from: a */
    private C0816z f2906a;

    /* renamed from: b */
    private ClientBootstrap f2907b;

    /* renamed from: c */
    private ChannelGroup f2908c = new DefaultChannelGroup("ChatOnClient");

    public C0791g(C0816z c0816z, ClientBootstrap clientBootstrap) {
        this.f2906a = c0816z;
        this.f2907b = clientBootstrap;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        Throwable cause = exceptionEvent.getCause();
        if (!(cause instanceof ConnectException) && !(cause instanceof UnresolvedAddressException)) {
            C1786r.m6056a(cause, getClass().getSimpleName());
        }
        channelHandlerContext.getChannel().close();
    }

    /* renamed from: a */
    public ChannelGroupFuture m3375a() {
        if (this.f2908c.size() <= 0) {
            return null;
        }
        ChannelGroupFuture channelGroupFutureAwaitUninterruptibly = this.f2908c.close().awaitUninterruptibly();
        this.f2908c.clear();
        return channelGroupFutureAwaitUninterruptibly;
    }

    /* renamed from: b */
    public boolean m3376b() {
        return this.f2908c.size() == 1;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        m3375a();
        this.f2908c.add(channelStateEvent.getChannel());
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        super.channelClosed(channelHandlerContext, channelStateEvent);
        try {
            C0794j c0794j = (C0794j) this.f2907b.getPipeline().get(C0794j.class);
            if (c0794j != null) {
                c0794j.m3380a();
            }
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
        Channels.fireChannelClosed(channelHandlerContext);
        Channels.fireChannelDisconnected(channelHandlerContext);
    }

    /* renamed from: a */
    public long m3374a(C0770ab c0770ab) {
        if (!m3376b()) {
            return -1L;
        }
        long jM3291d = c0770ab.m3291d();
        this.f2908c.write(c0770ab).addListener(new C0792h(this, c0770ab.m3284a(), c0770ab.m3289b(), c0770ab.m3291d(), c0770ab));
        return jM3291d;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        super.writeRequested(channelHandlerContext, messageEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        C0770ab c0770ab = (C0770ab) messageEvent.getMessage();
        if (c0770ab != null) {
            C0804n.m3414a(this.f2906a, c0770ab);
            if (c0770ab.m3292e() != null) {
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) channelHandlerContext.getChannel().getRemoteAddress();
            C1786r.m6063c("ch@t[c <~~ s]received msgType : " + ((C0770ab) messageEvent.getMessage()).m3290c().getClass().getSimpleName() + " ChannelId : " + channelHandlerContext.getChannel().getId() + " ServerInfo - ip:" + inetSocketAddress.getAddress().getHostAddress() + ", port:" + inetSocketAddress.getPort(), getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    public void m3377c() {
        try {
            C0794j c0794j = (C0794j) this.f2907b.getPipeline().get(C0794j.class);
            if (c0794j != null) {
                c0794j.m3382b();
            }
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getSimpleName());
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelConnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        super.channelConnected(channelHandlerContext, channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        super.channelDisconnected(channelHandlerContext, channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeComplete(ChannelHandlerContext channelHandlerContext, WriteCompletionEvent writeCompletionEvent) {
        super.writeComplete(channelHandlerContext, writeCompletionEvent);
    }
}
