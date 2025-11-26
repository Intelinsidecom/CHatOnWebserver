package com.sec.chaton.network.pipeline;

import com.sec.chaton.network.NetFlowControl;
import com.sec.chaton.network.TcpContext;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
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

/* loaded from: classes.dex */
public class TcpClientChannelHandler extends SimpleChannelHandler {

    /* renamed from: a */
    private TcpContext f2560a;

    /* renamed from: b */
    private ClientBootstrap f2561b;

    /* renamed from: c */
    private ChannelGroup f2562c = new DefaultChannelGroup("ChatOnClient");

    public TcpClientChannelHandler(TcpContext tcpContext, ClientBootstrap clientBootstrap) {
        this.f2560a = tcpContext;
        this.f2561b = clientBootstrap;
    }

    /* renamed from: a */
    public long m2834a(TcpEnvelope tcpEnvelope) {
        if (!m2836b()) {
            return -1L;
        }
        long jM2807d = tcpEnvelope.m2807d();
        this.f2562c.write(tcpEnvelope).addListener(new C0348a(this, tcpEnvelope.m2800a(), tcpEnvelope.m2805b(), tcpEnvelope.m2807d(), tcpEnvelope));
        return jM2807d;
    }

    /* renamed from: a */
    public ChannelGroupFuture m2835a() {
        if (this.f2562c.size() <= 0) {
            return null;
        }
        ChannelGroupFuture channelGroupFutureAwaitUninterruptibly = this.f2562c.close().awaitUninterruptibly();
        this.f2562c.clear();
        return channelGroupFutureAwaitUninterruptibly;
    }

    /* renamed from: b */
    public boolean m2836b() {
        return this.f2562c.size() == 1;
    }

    /* renamed from: c */
    public void m2837c() {
        try {
            TcpEnvelopeBicoder tcpEnvelopeBicoder = (TcpEnvelopeBicoder) this.f2561b.getPipeline().get(TcpEnvelopeBicoder.class);
            if (tcpEnvelopeBicoder != null) {
                tcpEnvelopeBicoder.m2842b();
            }
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        super.channelClosed(channelHandlerContext, channelStateEvent);
        try {
            TcpEnvelopeBicoder tcpEnvelopeBicoder = (TcpEnvelopeBicoder) this.f2561b.getPipeline().get(TcpEnvelopeBicoder.class);
            if (tcpEnvelopeBicoder != null) {
                tcpEnvelopeBicoder.m2840a();
            }
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
        }
        Channels.fireChannelClosed(channelHandlerContext);
        Channels.fireChannelDisconnected(channelHandlerContext);
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
    public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        m2835a();
        this.f2562c.add(channelStateEvent.getChannel());
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        Throwable cause = exceptionEvent.getCause();
        if (!(cause instanceof ConnectException) && (cause instanceof UnresolvedAddressException)) {
        }
        channelHandlerContext.getChannel().close();
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        TcpEnvelope tcpEnvelope = (TcpEnvelope) messageEvent.getMessage();
        if (tcpEnvelope == null) {
            return;
        }
        NetFlowControl.m2747a(this.f2560a, tcpEnvelope);
        if (tcpEnvelope.m2808e() != null) {
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) channelHandlerContext.getChannel().getRemoteAddress();
        ChatONLogWriter.m3508c("ch@t[c <~~ s]received msgType : " + ((TcpEnvelope) messageEvent.getMessage()).m2806c().getClass().getSimpleName() + " ChannelId : " + channelHandlerContext.getChannel().getId() + " ServerInfo - ip:" + inetSocketAddress.getAddress().getHostAddress() + ", port:" + inetSocketAddress.getPort(), getClass().getSimpleName());
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeComplete(ChannelHandlerContext channelHandlerContext, WriteCompletionEvent writeCompletionEvent) {
        super.writeComplete(channelHandlerContext, writeCompletionEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelHandler
    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        super.writeRequested(channelHandlerContext, messageEvent);
    }
}
