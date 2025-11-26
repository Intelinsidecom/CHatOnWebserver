package com.sec.chaton.p037j.p041d;

import android.text.TextUtils;
import com.sec.chaton.p037j.C1544ac;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1588p;
import com.sec.chaton.util.C3250y;
import java.net.ConnectException;
import java.net.SocketException;
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
/* renamed from: com.sec.chaton.j.d.g */
/* loaded from: classes.dex */
public class C1573g extends SimpleChannelHandler {

    /* renamed from: a */
    private C1544ac f5839a;

    /* renamed from: b */
    private ClientBootstrap f5840b;

    /* renamed from: e */
    private ChannelGroup f5843e = new DefaultChannelGroup("ChatOnClient");

    /* renamed from: c */
    private String f5841c = null;

    /* renamed from: d */
    private int f5842d = 0;

    public C1573g(C1544ac c1544ac, ClientBootstrap clientBootstrap) {
        this.f5839a = c1544ac;
        this.f5840b = clientBootstrap;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        Throwable cause = exceptionEvent.getCause();
        this.f5841c = cause.getMessage();
        if (!(cause instanceof ConnectException) && !(cause instanceof UnresolvedAddressException)) {
            if (cause instanceof SocketException) {
                if (C3250y.f11735c) {
                    C3250y.m11453c("exceptionCaught(ChannelHandlerContext, ExceptionEvent): Failed to connect: " + this.f5841c, getClass().getSimpleName());
                }
            } else {
                C3250y.m11443a(cause, getClass().getSimpleName());
            }
        }
        channelHandlerContext.getChannel().close();
    }

    /* renamed from: a */
    public ChannelGroupFuture m6675a() {
        return m6676a(34);
    }

    /* renamed from: a */
    public ChannelGroupFuture m6676a(int i) {
        if (this.f5843e.size() <= 0) {
            return null;
        }
        C3250y.m11450b("cause : " + String.valueOf(i), getClass().getSimpleName());
        this.f5842d = i;
        ChannelGroupFuture channelGroupFutureAwaitUninterruptibly = this.f5843e.close().awaitUninterruptibly();
        this.f5843e.clear();
        return channelGroupFutureAwaitUninterruptibly;
    }

    /* renamed from: b */
    public boolean m6677b() {
        return this.f5843e.size() == 1;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        m6675a();
        this.f5843e.add(channelStateEvent.getChannel());
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        super.channelClosed(channelHandlerContext, channelStateEvent);
        try {
            C1576j c1576j = (C1576j) this.f5840b.getPipeline().get(C1576j.class);
            if (c1576j != null) {
                if (!TextUtils.isEmpty(this.f5841c) && this.f5841c.contains("Connection reset by peer")) {
                    c1576j.m6682a(26);
                } else if (this.f5842d != 0) {
                    c1576j.m6682a(this.f5842d);
                } else {
                    c1576j.m6682a(22);
                }
                this.f5841c = null;
                this.f5842d = 0;
            }
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        }
        Channels.fireChannelClosed(channelHandlerContext);
        Channels.fireChannelDisconnected(channelHandlerContext);
    }

    /* renamed from: a */
    public long m6674a(C1548ag c1548ag) {
        if (!m6677b()) {
            return -1L;
        }
        long jM6576d = c1548ag.m6576d();
        ChannelGroupFuture channelGroupFutureWrite = this.f5843e.write(c1548ag);
        c1548ag.m6569a();
        channelGroupFutureWrite.addListener(new C1574h(this, c1548ag.m6576d(), c1548ag.m6574b(), c1548ag));
        return jM6576d;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        super.writeRequested(channelHandlerContext, messageEvent);
        channelHandlerContext.getChannel().getRemoteAddress();
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        C1548ag c1548ag = (C1548ag) messageEvent.getMessage();
        if (c1548ag != null) {
            C1588p.m6725a(this.f5839a, c1548ag);
            if (c1548ag.m6577e() != null) {
            }
            channelHandlerContext.getChannel().getRemoteAddress();
            StringBuilder sb = new StringBuilder();
            sb.append("ch@t[c <~~ s]received= ").append("MsgID : ").append(((C1548ag) messageEvent.getMessage()).m6576d()).append(", ").append("API type : ").append(((C1548ag) messageEvent.getMessage()).m6574b());
            C3250y.m11457f(sb.toString(), getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    public void m6678c() {
        try {
            C1576j c1576j = (C1576j) this.f5840b.getPipeline().get(C1576j.class);
            if (c1576j != null) {
                c1576j.m6681a();
            }
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
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
