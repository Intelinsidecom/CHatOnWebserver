package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.chat.ChatUtil;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.BuddyDatabaseHelper;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.MessageIDGenerator;

/* loaded from: classes.dex */
public class InviteChatTask extends AbstractNetTask {

    /* renamed from: g */
    private ChatONContract.MessageTable.MsgContentType f1610g;

    /* renamed from: h */
    private String f1611h;

    /* renamed from: i */
    private String[] f1612i;

    /* renamed from: j */
    private String[] f1613j;

    /* renamed from: k */
    private ContentResolver f1614k;

    /* renamed from: l */
    private String f1615l;

    public InviteChatTask(Handler handler, ChatONContract.MessageTable.MsgContentType msgContentType, String str, String[] strArr, String[] strArr2, String str2) {
        super(handler);
        this.f1457e = -1L;
        this.f1610g = msgContentType;
        this.f1611h = str;
        this.f1612i = strArr;
        this.f1613j = strArr2;
        this.f1614k = GlobalApplication.m2387e().getContentResolver();
        this.f1615l = str2;
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        ChatONLogWriter.m3508c("Request InviteChat", getClass().getSimpleName());
        if (this.f1457e == -1) {
            this.f1457e = MessageIDGenerator.m3598a();
        }
        SSMGPB.InviteChatRequest.Builder builderM1751p = SSMGPB.InviteChatRequest.m1751p();
        builderM1751p.m1772a(this.f1457e).m1775a(SSMGPB.MsgType.m1792a(this.f1610g.m2197a())).m1776a(this.f1611h).m1779b(ChatONPref.m3519a().getString("msisdn", ""));
        for (String str : this.f1612i) {
            builderM1751p.m1780c(str);
        }
        for (String str2 : this.f1613j) {
            builderM1751p.m1782d(str2);
        }
        ChatONLogWriter.m3508c("ch@t[" + builderM1751p.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", InBoxNo : " + this.f1615l + ", MsgID : " + builderM1751p.m1786g() + ", InvitingMembersCount : " + builderM1751p.m1791l() + ", InvitingMembersList : " + ChatONLogWriter.m3494a(builderM1751p.m1790k()) + ", Sender : " + builderM1751p.m1787h() + ", ReceiverCount : " + builderM1751p.m1789j() + ", ReceiversList : " + ChatONLogWriter.m3494a(builderM1751p.m1788i()), getClass().getSimpleName());
        TcpEnvelope.Builder builder = new TcpEnvelope.Builder();
        builder.m2813a(builderM1751p.build()).m2811a(12).m2812a(20000L);
        return builder.m2816b();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 12;
        if (obj2 == null) {
            if (this.f1456d >= f1453a) {
                InBoxDatabaseHelper.m2263e(this.f1614k, this.f1615l);
            }
            ChatONLogWriter.m3508c("Result NULL", getClass().getSimpleName());
            message.obj = new MessageResultEntry(false, ResultEntry.Result.NETWORKFAIL);
            this.f1454b.sendMessage(message);
            return;
        }
        SSMGPB.InviteChatReply inviteChatReply = (SSMGPB.InviteChatReply) ((TcpEnvelope) obj2).m2806c();
        ChatONLogWriter.m3508c("ch@t[" + inviteChatReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ResultCode : " + inviteChatReply.m1717f().m1898d() + ", ResultMessage : " + inviteChatReply.m1717f().m1900f() + ", InBoxNo : " + this.f1615l + ", MsgID : " + inviteChatReply.m1715d(), getClass().getSimpleName());
        int iM1898d = inviteChatReply.m1717f().m1898d();
        if (iM1898d == 1000 || iM1898d == 1001) {
            StringBuilder sb = new StringBuilder();
            for (String str : this.f1613j) {
                ParticipantDatabaseHelper.m2313c(this.f1614k, this.f1615l, str);
                sb.append(String.format("%s,%s,%s", "INVITE", str, ChatUtil.m795a(BuddyDatabaseHelper.m2220a(this.f1614k, str))));
                sb.append(";");
            }
            MessageDatabaseHelper.m2297b(this.f1614k, this.f1615l, sb.toString());
            InBoxDatabaseHelper.m2258b(this.f1614k, this.f1615l);
            message.obj = new MessageResultEntry(true, iM1898d);
        } else {
            message.obj = new MessageResultEntry(false, iM1898d);
        }
        this.f1454b.sendMessage(message);
    }
}
