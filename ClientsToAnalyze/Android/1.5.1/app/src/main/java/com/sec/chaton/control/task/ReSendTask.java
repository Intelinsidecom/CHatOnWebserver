package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.os.Message;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;

/* loaded from: classes.dex */
public class ReSendTask extends AbstractNetTask {

    /* renamed from: g */
    private long f1653g;

    /* renamed from: h */
    private ChatONContract.MessageTable.MsgContentType f1654h;

    /* renamed from: i */
    private ChatONContract.InBoxTable.ChatType f1655i;

    /* renamed from: j */
    private String f1656j;

    /* renamed from: k */
    private String[] f1657k;

    /* renamed from: l */
    private String f1658l;

    /* renamed from: m */
    private String f1659m;

    /* renamed from: n */
    private ContentResolver f1660n;

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        switch (this.f1655i) {
            case ONETOONE:
                MessageDatabaseHelper.m2301c(this.f1660n, Long.valueOf(this.f1653g));
                break;
            case GROUPCHAT:
                MessageDatabaseHelper.m2301c(this.f1660n, Long.valueOf(this.f1653g));
                break;
        }
        this.f1657k = ParticipantDatabaseHelper.m2312b(this.f1660n, this.f1659m);
        SSMGPB.ChatRequest.Builder builderM1226f = SSMGPB.ChatRequest.m1182x().m1211a(this.f1653g).m1214a(SSMGPB.ChatType.m1239a(this.f1655i.m2189a())).m1216a(this.f1656j).m1222d(ChatONPref.m3519a().getString("uid", "")).m1224e(DeviceInfoUtil.m3564a()).m1219b(ChatONPref.m3519a().getString("msisdn", "")).m1226f(this.f1658l);
        if (this.f1654h.m2197a() == 3) {
            builderM1226f.m1215a(SSMGPB.MsgType.m1792a(1));
        } else {
            builderM1226f.m1215a(SSMGPB.MsgType.m1792a(this.f1654h.m2197a()));
        }
        for (String str : this.f1657k) {
            ChatONLogWriter.m3511e("Receiver : " + str, getClass().getSimpleName());
            builderM1226f.m1220c(str);
        }
        ChatONLogWriter.m3508c("ch@t[" + builderM1226f.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", InBoxNo : " + this.f1659m + ", MsgID : " + builderM1226f.m1228g() + ", MsgType : " + builderM1226f.m1230h() + ", ChatMsg : " + builderM1226f.m1237o() + ", Sender : " + builderM1226f.m1233k() + ", IMEI : " + builderM1226f.m1236n() + ", ChatMsg : " + builderM1226f.m1237o() + ", ChatType : " + builderM1226f.m1231i() + ", SessionID : " + builderM1226f.m1232j() + ", WhisperReceiver : " + builderM1226f.m1238p() + ", ReceiverCount : " + builderM1226f.m1235m() + ", ReceiversList : " + ChatONLogWriter.m3494a(builderM1226f.m1234l()), getClass().getSimpleName());
        return new TcpEnvelope.Builder().m2811a(4).m2813a(builderM1226f.build()).m2812a(20000L).m2816b();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 4;
        if (obj2 == null) {
            ChatONLogWriter.m3508c("Return : null", getClass().getSimpleName());
            message.obj = new MessageResultEntry(false, ResultEntry.Result.NETWORKFAIL);
            this.f1454b.sendMessage(message);
            MessageDatabaseHelper.m2278a(this.f1660n, Long.valueOf(this.f1653g));
            return;
        }
        SSMGPB.ChatReply chatReply = (SSMGPB.ChatReply) ((TcpEnvelope) obj2).m2806c();
        ChatONLogWriter.m3508c("ch@t[" + chatReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ResultCode : " + chatReply.m1134l().m1898d() + ", ResultMessage : " + chatReply.m1134l().m1900f() + ", InBoxNo : " + this.f1659m + ", MsgID : " + chatReply.m1126d() + ", MsgReceivedTime : " + chatReply.m1132j() + ", ServerInfo(address) : " + (chatReply.m1130h() != null ? chatReply.m1130h().m1925d() : "null") + ", ServerInfo(port) : " + (chatReply.m1130h() != null ? Integer.valueOf(chatReply.m1130h().m1927f()) : "null") + ", SessionID : " + chatReply.m1128f(), getClass().getSimpleName());
        int iM1898d = chatReply.m1134l().m1898d();
        if (iM1898d == 1000 || ((iM1898d == 6002 && this.f1655i != ChatONContract.InBoxTable.ChatType.ONETOONE) || iM1898d == 1001)) {
            MessageDatabaseHelper.m2282a(this.f1660n, Long.valueOf(chatReply.m1132j()), chatReply.m1128f(), chatReply.m1126d(), Long.valueOf(this.f1653g), this.f1657k.length);
            InBoxDatabaseHelper.m2252a(this.f1660n, ChatONPref.m3519a().getString("msisdn", ""), this.f1659m, this.f1658l, chatReply.m1132j(), chatReply.m1128f(), chatReply.m1130h().m1925d(), Integer.valueOf(chatReply.m1130h().m1927f()), Long.valueOf(chatReply.m1126d()), this.f1657k.length, this.f1654h);
            message.obj = new MessageResultEntry(true, iM1898d);
        } else {
            message.obj = new MessageResultEntry(false, iM1898d);
            MessageDatabaseHelper.m2278a(this.f1660n, Long.valueOf(this.f1653g));
        }
        this.f1454b.sendMessage(message);
    }
}
