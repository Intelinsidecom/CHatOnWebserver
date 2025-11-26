package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.os.Handler;
import com.sec.chaton.chat.ChatUtil;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;

/* loaded from: classes.dex */
public class AnnounceChangeTask extends AbstractNetTask {

    /* renamed from: g */
    private SSMGPB.AnnounceChange f1468g;

    /* renamed from: h */
    private String f1469h;

    /* renamed from: i */
    private ContentResolver f1470i;

    public AnnounceChangeTask(Handler handler, SSMGPB.AnnounceChange announceChange, String str) {
        super(handler);
        this.f1468g = announceChange;
        this.f1469h = str;
        this.f1470i = GlobalApplication.m2387e().getContentResolver();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f1468g.m923g().size(); i++) {
            sb.append("[" + i + "]Member = " + this.f1468g.m917a(i).m1088f()).append(", Name = " + this.f1468g.m917a(i).m1090h()).append(", Status = " + this.f1468g.m917a(i).m1086d());
        }
        ChatONLogWriter.m3508c("ch@t[" + this.f1468g.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", MsgID : " + this.f1468g.m920d() + ", SessionID : " + this.f1468g.m922f() + ", GroupMemberListCount : " + this.f1468g.m926j() + ", GroupMemberList : " + ChatONLogWriter.m3494a(this.f1468g.m925i()) + ", ChangeMemberListCount : " + this.f1468g.m924h() + ", ChangeMemberList : " + sb.toString(), getClass().getSimpleName());
        StringBuilder sb2 = new StringBuilder();
        for (int i2 = 0; i2 < this.f1468g.m924h(); i2++) {
            String strM2310b = ParticipantDatabaseHelper.m2310b(this.f1470i, this.f1468g.m917a(i2).m1088f(), this.f1468g.m917a(i2).m1090h());
            if (this.f1468g.m917a(i2).m1086d() == SSMGPB.ChangeStatus.m1106a(0)) {
                if (!ParticipantDatabaseHelper.m2309a(this.f1470i, this.f1468g.m917a(i2).m1088f(), this.f1469h)) {
                    sb2.append(String.format("%s,%s,%s", "ENTER", this.f1468g.m917a(i2).m1088f(), ChatUtil.m795a(strM2310b))).append(";");
                    ParticipantDatabaseHelper.m2308a(this.f1470i, this.f1469h, this.f1468g.m917a(i2).m1088f(), strM2310b);
                }
            } else if (this.f1468g.m917a(i2).m1086d() == SSMGPB.ChangeStatus.m1106a(1) && ParticipantDatabaseHelper.m2309a(this.f1470i, this.f1468g.m917a(i2).m1088f(), this.f1469h)) {
                sb2.append(String.format("%s,%s,%s", "LEAVE", this.f1468g.m917a(i2).m1088f(), ChatUtil.m795a(strM2310b))).append(";");
                ParticipantDatabaseHelper.m2316d(this.f1470i, this.f1469h, this.f1468g.m917a(i2).m1088f());
            }
        }
        if (sb2.length() > 0) {
            MessageDatabaseHelper.m2273a(this.f1470i, this.f1469h, sb2.toString(), this.f1468g.m928l(), Long.toString(this.f1468g.m920d()));
        }
        InBoxDatabaseHelper.m2258b(this.f1470i, this.f1469h);
        SSMGPB.AnnounceChangeReply.Builder builderM955h = SSMGPB.AnnounceChangeReply.m955h();
        builderM955h.m968a(this.f1468g.m920d());
        ChatONLogWriter.m3508c("ch@t[" + builderM955h.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", MsgID : " + builderM955h.m979g(), getClass().getSimpleName());
        return new TcpEnvelope.Builder().m2813a(builderM955h.build()).m2811a(17).m2816b();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
    }
}
