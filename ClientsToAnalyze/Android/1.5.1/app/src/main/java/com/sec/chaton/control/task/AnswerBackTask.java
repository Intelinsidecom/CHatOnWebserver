package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.os.Handler;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import java.util.List;

/* loaded from: classes.dex */
public class AnswerBackTask extends AbstractNetTask {

    /* renamed from: g */
    private SSMGPB.AnswerBack f1471g;

    /* renamed from: h */
    private Handler f1472h;

    /* renamed from: i */
    private List f1473i;

    /* renamed from: j */
    private ContentResolver f1474j;

    public AnswerBackTask(Handler handler, SSMGPB.AnswerBack answerBack) {
        super(handler);
        this.f1472h = handler;
        this.f1471g = answerBack;
        this.f1474j = GlobalApplication.m2387e().getContentResolver();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        SSMGPB.AnswerBackReply.Builder builderM1016j = SSMGPB.AnswerBackReply.m1016j();
        this.f1473i = this.f1471g.m990c();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f1473i.size(); i++) {
            ((SSMGPB.AnswerbackItem) this.f1473i.get(i)).m1060f();
            this.f1474j.update(ChatONContract.MessageTable.m2191a(String.valueOf(((SSMGPB.AnswerbackItem) this.f1473i.get(i)).m1060f())), null, null, null);
            builderM1016j.m1034a((SSMGPB.AnswerbackItem) this.f1473i.get(i));
        }
        for (int i2 = 0; i2 < this.f1471g.m990c().size(); i2++) {
            sb.append("[" + i2 + "]MsgID = " + this.f1471g.m988a(i2).m1060f()).append(", Receiver = " + this.f1471g.m988a(i2).m1058d());
        }
        ChatONLogWriter.m3508c("ch@t[" + this.f1471g.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", AnswerbackItemsCount : " + this.f1471g.m991d() + ",Items : " + sb.toString(), getClass().getSimpleName());
        builderM1016j.m1036a(ChatONPref.m3519a().getString("uid", ""));
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < builderM1016j.m1045g().size(); i3++) {
            sb2.append("[" + i3 + "]MsgID = " + builderM1016j.m1038a(i3).m1060f()).append(", Receiver = " + builderM1016j.m1038a(i3).m1058d());
        }
        ChatONLogWriter.m3508c("ch@t[" + builderM1016j.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", AnswerbackItemsCount : " + builderM1016j.m1046h() + ",Items : " + sb2.toString(), getClass().getSimpleName());
        TcpEnvelope.Builder builder = new TcpEnvelope.Builder();
        builder.m2813a(builderM1016j.build()).m2811a(11);
        return builder.m2816b();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
    }
}
