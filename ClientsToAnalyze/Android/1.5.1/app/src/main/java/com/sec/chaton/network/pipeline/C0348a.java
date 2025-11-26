package com.sec.chaton.network.pipeline;

import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.group.ChannelGroupFutureListener;

/* renamed from: com.sec.chaton.network.pipeline.a */
/* loaded from: classes.dex */
class C0348a implements ChannelGroupFutureListener {

    /* renamed from: a */
    final /* synthetic */ String f2572a;

    /* renamed from: b */
    final /* synthetic */ int f2573b;

    /* renamed from: c */
    final /* synthetic */ long f2574c;

    /* renamed from: d */
    final /* synthetic */ TcpEnvelope f2575d;

    /* renamed from: e */
    final /* synthetic */ TcpClientChannelHandler f2576e;

    C0348a(TcpClientChannelHandler tcpClientChannelHandler, String str, int i, long j, TcpEnvelope tcpEnvelope) {
        this.f2576e = tcpClientChannelHandler;
        this.f2572a = str;
        this.f2573b = i;
        this.f2574c = j;
        this.f2575d = tcpEnvelope;
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFutureListener
    public void operationComplete(ChannelGroupFuture channelGroupFuture) {
        ChatONLogWriter.m3506b("ch@t[c ~~> s]Write Completed: id=" + this.f2576e.f2560a.m2787c() + ", isSuccess=" + channelGroupFuture.isCompleteSuccess() + ", ip=" + this.f2576e.f2560a.m2788d() + ":" + this.f2576e.f2560a.m2789e() + ", alive=" + this.f2576e.f2560a.m2793i() + ", uid=" + this.f2572a + ", type=" + this.f2573b + ", msgId=" + this.f2574c, "[TCPClientChannelHandler]");
        if (channelGroupFuture.isCompleteFailure()) {
            ChatONLogWriter.m3506b("TCPClientChannelHandler.writeChannel() - isComplete fail. try tcp error callback", "[TCPClientChannelHandler]");
            this.f2575d.m2802a(this.f2575d);
        }
    }
}
