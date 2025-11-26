package com.sec.chaton.control.task;

import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class DisconnectTask extends AbstractNetTask {

    /* renamed from: g */
    private long f1506g;

    /* renamed from: h */
    private int f1507h;

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        SSMGPB.DisconnectReply.Builder builderM1375j = SSMGPB.DisconnectReply.m1375j();
        builderM1375j.m1390a(this.f1506g).m1392a(SSMGPB.DisconnectActionType.m1364a(this.f1507h));
        ChatONLogWriter.m3508c("ch@t[" + builderM1375j.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", MsgID : " + builderM1375j.m1402g() + ", DisconnectActionType : " + builderM1375j.m1403h(), getClass().getSimpleName());
        TcpEnvelope.Builder builder = new TcpEnvelope.Builder();
        builder.m2811a(15).m2813a(builderM1375j.build());
        return builder.m2816b();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
    }
}
