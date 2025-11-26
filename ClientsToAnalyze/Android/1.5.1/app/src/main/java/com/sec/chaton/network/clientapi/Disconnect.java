package com.sec.chaton.network.clientapi;

import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.network.NetResultReceiver;
import com.sec.chaton.network.TcpClient;
import com.sec.chaton.network.TcpContext;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class Disconnect {

    /* renamed from: a */
    @Deprecated
    private static NetResultReceiver f2511a = null;

    /* renamed from: a */
    public static void m2822a(TcpContext tcpContext, SSMGPB.DisconnectRequest disconnectRequest, SSMGPB.DisconnectActionType disconnectActionType) {
        SSMGPB.DisconnectReply.Builder builderM1375j = SSMGPB.DisconnectReply.m1375j();
        builderM1375j.m1390a(disconnectRequest.m1418d()).m1392a(disconnectActionType);
        ChatONLogWriter.m3508c("ch@t[" + builderM1375j.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", MsgID : " + builderM1375j.m1402g() + ", DisconnectActionType : " + builderM1375j.m1403h(), Disconnect.class.getSimpleName());
        TcpClient.m2758a(tcpContext, new TcpEnvelope.Builder().m2811a(15).m2813a(builderM1375j.build()).m2816b());
    }

    /* renamed from: a */
    public static void m2823a(TcpContext tcpContext, NetResultReceiver netResultReceiver) {
        tcpContext.f2477l = netResultReceiver;
        f2511a = netResultReceiver;
    }
}
