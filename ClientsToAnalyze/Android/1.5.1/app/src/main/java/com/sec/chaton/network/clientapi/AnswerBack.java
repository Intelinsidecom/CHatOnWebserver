package com.sec.chaton.network.clientapi;

import com.sec.chaton.network.NetResultReceiver;
import com.sec.chaton.network.TcpContext;

/* loaded from: classes.dex */
public class AnswerBack {

    /* renamed from: a */
    @Deprecated
    private static NetResultReceiver f2509a = null;

    /* renamed from: a */
    public static void m2820a(TcpContext tcpContext, NetResultReceiver netResultReceiver) {
        tcpContext.f2475j = netResultReceiver;
        f2509a = netResultReceiver;
    }
}
