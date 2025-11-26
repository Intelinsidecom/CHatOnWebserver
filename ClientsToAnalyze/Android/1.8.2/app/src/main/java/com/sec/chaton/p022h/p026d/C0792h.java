package com.sec.chaton.p022h.p026d;

import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.util.C1786r;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.group.ChannelGroupFutureListener;

/* compiled from: TcpClientChannelHandler.java */
/* renamed from: com.sec.chaton.h.d.h */
/* loaded from: classes.dex */
class C0792h implements ChannelGroupFutureListener {

    /* renamed from: a */
    final /* synthetic */ String f2909a;

    /* renamed from: b */
    final /* synthetic */ int f2910b;

    /* renamed from: c */
    final /* synthetic */ long f2911c;

    /* renamed from: d */
    final /* synthetic */ C0770ab f2912d;

    /* renamed from: e */
    final /* synthetic */ C0791g f2913e;

    C0792h(C0791g c0791g, String str, int i, long j, C0770ab c0770ab) {
        this.f2913e = c0791g;
        this.f2909a = str;
        this.f2910b = i;
        this.f2911c = j;
        this.f2912d = c0770ab;
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFutureListener
    public void operationComplete(ChannelGroupFuture channelGroupFuture) {
        C1786r.m6061b("ch@t[c ~~> s]Write Completed: id=" + this.f2913e.f2906a.m3454c() + ", isSuccess=" + channelGroupFuture.isCompleteSuccess() + ", ip=" + this.f2913e.f2906a.m3455d() + ":" + this.f2913e.f2906a.m3456e() + ", alive=" + this.f2913e.f2906a.m3460i() + ", uid=" + this.f2909a + ", type=" + this.f2910b + ", msgId=" + this.f2911c, "[TCPClientChannelHandler]");
        if (channelGroupFuture.isCompleteFailure()) {
            C1786r.m6061b("TCPClientChannelHandler.writeChannel() - isComplete fail. try tcp error callback", "[TCPClientChannelHandler]");
            this.f2912d.m3285a(25, this.f2912d);
        }
    }
}
