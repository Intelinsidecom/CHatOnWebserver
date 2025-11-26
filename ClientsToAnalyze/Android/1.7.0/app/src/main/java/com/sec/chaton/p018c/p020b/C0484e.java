package com.sec.chaton.p018c.p020b;

import com.sec.chaton.p018c.C0501h;
import com.sec.chaton.p018c.C0505l;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.util.C1341p;
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
/* renamed from: com.sec.chaton.c.b.e */
/* loaded from: classes.dex */
public class C0484e extends SimpleChannelHandler {

    /* renamed from: a */
    private C0505l f1556a;

    /* renamed from: b */
    private ClientBootstrap f1557b;

    /* renamed from: c */
    private ChannelGroup f1558c = new DefaultChannelGroup("ChatOnClient");

    public C0484e(C0505l c0505l, ClientBootstrap clientBootstrap) {
        this.f1556a = c0505l;
        this.f1557b = clientBootstrap;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        Throwable cause = exceptionEvent.getCause();
        if (!(cause instanceof ConnectException) && !(cause instanceof UnresolvedAddressException)) {
            C1341p.m4653a(cause, getClass().getSimpleName());
        }
        channelHandlerContext.getChannel().close();
    }

    /* renamed from: a */
    public ChannelGroupFuture m2474a() {
        if (this.f1558c.size() <= 0) {
            return null;
        }
        ChannelGroupFuture channelGroupFutureAwaitUninterruptibly = this.f1558c.close().awaitUninterruptibly();
        this.f1558c.clear();
        return channelGroupFutureAwaitUninterruptibly;
    }

    /* renamed from: b */
    public boolean m2475b() {
        return this.f1558c.size() == 1;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        m2474a();
        this.f1558c.add(channelStateEvent.getChannel());
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        super.channelClosed(channelHandlerContext, channelStateEvent);
        try {
            C0486g c0486g = (C0486g) this.f1557b.getPipeline().get(C0486g.class);
            if (c0486g != null) {
                c0486g.m2480a();
            }
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
        }
        Channels.fireChannelClosed(channelHandlerContext);
        Channels.fireChannelDisconnected(channelHandlerContext);
    }

    /* renamed from: a */
    public long m2473a(C0510q c0510q) {
        if (!m2475b()) {
            return -1L;
        }
        long jM2575d = c0510q.m2575d();
        this.f1558c.write(c0510q).addListener(new C0482c(this, c0510q.m2568a(), c0510q.m2573b(), c0510q.m2575d(), c0510q));
        return jM2575d;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        super.writeRequested(channelHandlerContext, messageEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        C0510q c0510q = (C0510q) messageEvent.getMessage();
        if (c0510q != null) {
            C0501h.m2525a(this.f1556a, c0510q);
            if (c0510q.m2576e() != null) {
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) channelHandlerContext.getChannel().getRemoteAddress();
            C1341p.m4660c("ch@t[c <~~ s]received msgType : " + ((C0510q) messageEvent.getMessage()).m2574c().getClass().getSimpleName() + " ChannelId : " + channelHandlerContext.getChannel().getId() + " ServerInfo - ip:" + inetSocketAddress.getAddress().getHostAddress() + ", port:" + inetSocketAddress.getPort(), getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    public void m2476c() {
        try {
            C0486g c0486g = (C0486g) this.f1557b.getPipeline().get(C0486g.class);
            if (c0486g != null) {
                c0486g.m2483b();
            }
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getSimpleName());
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
