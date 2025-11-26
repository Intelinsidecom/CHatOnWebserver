package com.sec.chaton.p067j.p071d;

import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.util.C4904y;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.group.ChannelGroupFutureListener;

/* compiled from: TcpClientChannelHandler.java */
/* renamed from: com.sec.chaton.j.d.h */
/* loaded from: classes.dex */
class C2451h implements ChannelGroupFutureListener {

    /* renamed from: a */
    final /* synthetic */ long f8788a;

    /* renamed from: b */
    final /* synthetic */ int f8789b;

    /* renamed from: c */
    final /* synthetic */ C2426ao f8790c;

    /* renamed from: d */
    final /* synthetic */ C2450g f8791d;

    C2451h(C2450g c2450g, long j, int i, C2426ao c2426ao) {
        this.f8791d = c2450g;
        this.f8788a = j;
        this.f8789b = i;
        this.f8790c = c2426ao;
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFutureListener
    public void operationComplete(ChannelGroupFuture channelGroupFuture) {
        StringBuilder sb = new StringBuilder();
        sb.append("ch@t[c ~~> s]Write Completed= ").append("isSuccess : ").append(channelGroupFuture.isCompleteSuccess()).append(", ").append("MsgID : ").append(this.f8788a).append(", ").append("API type : ").append(this.f8789b);
        C4904y.m18647f(sb.toString(), this.f8791d.getClass().getSimpleName());
        if (channelGroupFuture.isCompleteFailure()) {
            C4904y.m18639b("TCPClientChannelHandler.writeChannel() - isComplete fail. try tcp error callback", "[TCPClientChannelHandler]");
            this.f8790c.m10508a(25, this.f8790c);
        }
    }
}
