package com.sec.chaton.p067j.p071d;

import android.text.TextUtils;
import com.sec.chaton.p067j.C2422ak;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2465p;
import com.sec.chaton.util.C4904y;
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
public class C2450g extends SimpleChannelHandler {

    /* renamed from: a */
    private C2422ak f8783a;

    /* renamed from: b */
    private ClientBootstrap f8784b;

    /* renamed from: e */
    private ChannelGroup f8787e = new DefaultChannelGroup("ChatOnClient");

    /* renamed from: c */
    private String f8785c = null;

    /* renamed from: d */
    private int f8786d = 0;

    public C2450g(C2422ak c2422ak, ClientBootstrap clientBootstrap) {
        this.f8783a = c2422ak;
        this.f8784b = clientBootstrap;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        Throwable cause = exceptionEvent.getCause();
        this.f8785c = cause.getMessage();
        if (!(cause instanceof ConnectException) && !(cause instanceof UnresolvedAddressException)) {
            if (cause instanceof SocketException) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("exceptionCaught(ChannelHandlerContext, ExceptionEvent): Failed to connect: " + this.f8785c, getClass().getSimpleName());
                }
            } else {
                C4904y.m18635a(cause, getClass().getSimpleName());
            }
        }
        channelHandlerContext.getChannel().close();
    }

    /* renamed from: a */
    public ChannelGroupFuture m10619a() {
        return m10620a(34);
    }

    /* renamed from: a */
    public ChannelGroupFuture m10620a(int i) {
        if (this.f8787e.size() <= 0) {
            return null;
        }
        C4904y.m18639b("cause : " + String.valueOf(i), getClass().getSimpleName());
        this.f8786d = i;
        ChannelGroupFuture channelGroupFutureAwaitUninterruptibly = this.f8787e.close().awaitUninterruptibly();
        this.f8787e.clear();
        return channelGroupFutureAwaitUninterruptibly;
    }

    /* renamed from: b */
    public boolean m10621b() {
        return this.f8787e.size() == 1;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        m10619a();
        this.f8787e.add(channelStateEvent.getChannel());
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        super.channelClosed(channelHandlerContext, channelStateEvent);
        try {
            C2453j c2453j = (C2453j) this.f8784b.getPipeline().get(C2453j.class);
            if (c2453j != null) {
                if (!TextUtils.isEmpty(this.f8785c) && this.f8785c.contains("Connection reset by peer")) {
                    c2453j.m10626a(26);
                } else if (this.f8786d != 0) {
                    c2453j.m10626a(this.f8786d);
                } else {
                    c2453j.m10626a(22);
                }
                this.f8785c = null;
                this.f8786d = 0;
            }
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        }
        Channels.fireChannelClosed(channelHandlerContext);
        Channels.fireChannelDisconnected(channelHandlerContext);
    }

    /* renamed from: a */
    public long m10618a(C2426ao c2426ao) {
        if (!m10621b()) {
            return -1L;
        }
        long jM10514d = c2426ao.m10514d();
        ChannelGroupFuture channelGroupFutureWrite = this.f8787e.write(c2426ao);
        c2426ao.m10507a();
        channelGroupFutureWrite.addListener(new C2451h(this, c2426ao.m10514d(), c2426ao.m10512b(), c2426ao));
        return jM10514d;
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        super.writeRequested(channelHandlerContext, messageEvent);
        channelHandlerContext.getChannel().getRemoteAddress();
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        C2426ao c2426ao = (C2426ao) messageEvent.getMessage();
        if (c2426ao != null) {
            C2465p.m10669a(this.f8783a, c2426ao);
            if (c2426ao.m10515e() != null) {
            }
            channelHandlerContext.getChannel().getRemoteAddress();
            StringBuilder sb = new StringBuilder();
            sb.append("ch@t[c <~~ s]received= ").append("MsgID : ").append(((C2426ao) messageEvent.getMessage()).m10514d()).append(", ").append("API type : ").append(((C2426ao) messageEvent.getMessage()).m10512b());
            C4904y.m18647f(sb.toString(), getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    public void m10622c() {
        try {
            C2453j c2453j = (C2453j) this.f8784b.getPipeline().get(C2453j.class);
            if (c2453j != null) {
                c2453j.m10625a();
            }
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
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
