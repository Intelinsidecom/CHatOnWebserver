package com.sec.chaton.network.clientapi;

import com.sec.chaton.network.NetResultReceiver;
import com.sec.chaton.network.TcpContext;

/* loaded from: classes.dex */
public class AnnounceChange {

    /* renamed from: a */
    @Deprecated
    private static NetResultReceiver f2508a = null;

    /* renamed from: a */
    public static void m2819a(TcpContext tcpContext, NetResultReceiver netResultReceiver) {
        tcpContext.f2474i = netResultReceiver;
        f2508a = netResultReceiver;
    }
}
