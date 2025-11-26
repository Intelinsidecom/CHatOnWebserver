package com.sec.chaton.network.clientapi;

import com.sec.chaton.network.NetResultReceiver;
import com.sec.chaton.network.TcpContext;

/* loaded from: classes.dex */
public class DeliveryChat {

    /* renamed from: a */
    @Deprecated
    private static NetResultReceiver f2510a = null;

    /* renamed from: a */
    public static void m2821a(TcpContext tcpContext, NetResultReceiver netResultReceiver) {
        tcpContext.f2476k = netResultReceiver;
        f2510a = netResultReceiver;
    }
}
