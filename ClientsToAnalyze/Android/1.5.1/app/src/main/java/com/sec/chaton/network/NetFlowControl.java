package com.sec.chaton.network;

import android.os.SystemClock;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.network.clientapi.Disconnect;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class NetFlowControl {
    /* renamed from: a */
    public static void m2747a(TcpContext tcpContext, TcpEnvelope tcpEnvelope) {
        if (tcpEnvelope == null) {
            return;
        }
        switch (tcpEnvelope.m2805b()) {
            case 14:
                try {
                    SSMGPB.DisconnectRequest disconnectRequest = (SSMGPB.DisconnectRequest) tcpEnvelope.m2806c();
                    ChatONLogWriter.m3508c("ch@t[" + disconnectRequest.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", MsgID : " + disconnectRequest.m1418d() + ", SessionID : " + disconnectRequest.m1422h() + ", Cause : " + disconnectRequest.m1420f(), Disconnect.class.getSimpleName());
                    long jM2793i = tcpContext.m2793i() - SystemClock.elapsedRealtime();
                    ChatONLogWriter.m3508c("Calculated tcp alive delta time: " + jM2793i, NetFlowControl.class.getSimpleName());
                    if (jM2793i > 0) {
                        ChatONLogWriter.m3506b("Tcp is alive, hold on connection.", NetFlowControl.class.getSimpleName());
                        Disconnect.m2822a(tcpContext, disconnectRequest, SSMGPB.DisconnectActionType.HOLD_ON);
                    } else {
                        ChatONLogWriter.m3506b("Tcp alive time is over, disconnect connection", NetFlowControl.class.getSimpleName());
                        Disconnect.m2822a(tcpContext, disconnectRequest, SSMGPB.DisconnectActionType.CLOSE);
                        TcpContext.m2782c(tcpContext);
                    }
                    break;
                } catch (Exception e) {
                    ChatONLogWriter.m3501a(e, NetFlowControl.class.getSimpleName());
                    return;
                }
        }
    }
}
