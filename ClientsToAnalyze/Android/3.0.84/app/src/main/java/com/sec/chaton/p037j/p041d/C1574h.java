package com.sec.chaton.p037j.p041d;

import com.sec.chaton.global.C1493a;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3347i;
import com.sec.spp.push.Config;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.group.ChannelGroupFutureListener;

/* compiled from: TcpClientChannelHandler.java */
/* renamed from: com.sec.chaton.j.d.h */
/* loaded from: classes.dex */
class C1574h implements ChannelGroupFutureListener {

    /* renamed from: a */
    final /* synthetic */ long f5844a;

    /* renamed from: b */
    final /* synthetic */ int f5845b;

    /* renamed from: c */
    final /* synthetic */ C1548ag f5846c;

    /* renamed from: d */
    final /* synthetic */ C1573g f5847d;

    C1574h(C1573g c1573g, long j, int i, C1548ag c1548ag) {
        this.f5847d = c1573g;
        this.f5844a = j;
        this.f5845b = i;
        this.f5846c = c1548ag;
    }

    @Override // org.jboss.netty.channel.group.ChannelGroupFutureListener
    public void operationComplete(ChannelGroupFuture channelGroupFuture) {
        StringBuilder sb = new StringBuilder();
        if (C1493a.m6463a("wifi_80_port") && C3347i.m11787j() && C3159aa.m10962a().m10978a(Config.PROVIDER_PATH_WIFI_PORT, C3159aa.m10962a().m10978a("primary_message_port", (Integer) 0)).intValue() == -1) {
            C3159aa.m10962a().m10984b(Config.PROVIDER_PATH_WIFI_PORT, C3159aa.m10962a().m10978a("primary_message_wifi_port", (Integer) 80));
        }
        sb.append("ch@t[c ~~> s]Write Completed= ").append("isSuccess : ").append(channelGroupFuture.isCompleteSuccess()).append(", ").append("MsgID : ").append(this.f5844a).append(", ").append("API type : ").append(this.f5845b);
        C3250y.m11457f(sb.toString(), this.f5847d.getClass().getSimpleName());
        if (channelGroupFuture.isCompleteFailure()) {
            C3250y.m11450b("TCPClientChannelHandler.writeChannel() - isComplete fail. try tcp error callback", "[TCPClientChannelHandler]");
            this.f5846c.m6570a(25, this.f5846c);
        }
    }
}
