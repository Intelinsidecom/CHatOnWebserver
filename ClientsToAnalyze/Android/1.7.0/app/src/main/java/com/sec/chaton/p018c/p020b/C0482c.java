package com.sec.chaton.p018c.p020b;

import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.util.C1341p;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.group.ChannelGroupFutureListener;

/* compiled from: TcpClientChannelHandler.java */
/* renamed from: com.sec.chaton.c.b.c */
/* loaded from: classes.dex */
class C0482c implements ChannelGroupFutureListener {

    /* renamed from: a */
    final /* synthetic */ String f1550a;

    /* renamed from: b */
    final /* synthetic */ int f1551b;

    /* renamed from: c */
    final /* synthetic */ long f1552c;

    /* renamed from: d */
    final /* synthetic */ C0510q f1553d;

    /* renamed from: e */
    final /* synthetic */ C0484e f1554e;

    C0482c(C0484e c0484e, String str, int i, long j, C0510q c0510q) {
        this.f1554e = c0484e;
        this.f1550a = str;
        this.f1551b = i;
        this.f1552c = j;
        this.f1553d = c0510q;
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFutureListener
    public void operationComplete(ChannelGroupFuture channelGroupFuture) {
        C1341p.m4658b("ch@t[c ~~> s]Write Completed: id=" + this.f1554e.f1556a.m2548c() + ", isSuccess=" + channelGroupFuture.isCompleteSuccess() + ", ip=" + this.f1554e.f1556a.m2549d() + ":" + this.f1554e.f1556a.m2550e() + ", alive=" + this.f1554e.f1556a.m2554i() + ", uid=" + this.f1550a + ", type=" + this.f1551b + ", msgId=" + this.f1552c, "[TCPClientChannelHandler]");
        if (channelGroupFuture.isCompleteFailure()) {
            C1341p.m4658b("TCPClientChannelHandler.writeChannel() - isComplete fail. try tcp error callback", "[TCPClientChannelHandler]");
            this.f1553d.m2569a(25, this.f1553d);
        }
    }
}
