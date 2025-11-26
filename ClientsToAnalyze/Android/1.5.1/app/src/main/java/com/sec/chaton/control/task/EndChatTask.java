package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.TcpClient;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.MessageIDGenerator;

/* loaded from: classes.dex */
public class EndChatTask extends AbstractNetTask {

    /* renamed from: g */
    private ChatONContract.InBoxTable.ChatType f1508g;

    /* renamed from: h */
    private String f1509h;

    /* renamed from: i */
    private String[] f1510i;

    /* renamed from: j */
    private String f1511j;

    /* renamed from: k */
    private ContentResolver f1512k;

    public EndChatTask(Handler handler, ChatONContract.InBoxTable.ChatType chatType, String str, String str2, String[] strArr) {
        super(handler);
        this.f1508g = chatType;
        this.f1509h = str;
        this.f1511j = str2;
        this.f1510i = strArr;
        this.f1512k = GlobalApplication.m2387e().getContentResolver();
        this.f1457e = -1L;
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        if (TcpClient.m2759a(this.f1455c)) {
            ChatONLogWriter.m3506b("EndChatTask", "EndChat Start, chatType : " + this.f1508g.toString() + "InBonxNO : " + this.f1511j + ", SessionID : " + this.f1509h);
            if (this.f1457e == -1) {
                this.f1457e = MessageIDGenerator.m3598a();
            }
            SSMGPB.EndChatRequest.Builder builderM1517c = SSMGPB.EndChatRequest.m1489o().m1509a(this.f1457e).m1511a(SSMGPB.ChatType.m1239a(this.f1508g.m2189a())).m1513a(this.f1509h).m1516b(ChatONPref.m3519a().getString("uid", "")).m1517c(ChatONPref.m3519a().getString("msisdn", ""));
            Cursor cursorM2306a = ParticipantDatabaseHelper.m2306a(this.f1512k, this.f1511j);
            ChatONLogWriter.m3506b("EndChatTask", "Participants Count : " + cursorM2306a.getCount());
            while (cursorM2306a.moveToNext()) {
                String string = cursorM2306a.getString(cursorM2306a.getColumnIndex("participants_buddy_no"));
                ChatONLogWriter.m3506b("EndChatTask", "Request End Chat To : " + string);
                builderM1517c.m1519d(string);
            }
            cursorM2306a.close();
            ChatONLogWriter.m3508c("ch@t[" + builderM1517c.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ChatType : " + builderM1517c.m1524h() + ", MsgID : " + builderM1517c.m1523g() + ", Receivers : " + ChatONLogWriter.m3494a(builderM1517c.m1527k()) + ", Sender : " + builderM1517c.m1526j() + ", SessionID : " + builderM1517c.m1525i(), getClass().getSimpleName());
            return new TcpEnvelope.Builder().m2813a(builderM1517c.build()).m2811a(8).m2812a(20000L).m2816b();
        }
        InBoxDatabaseHelper.m2250a(this.f1512k, this.f1511j, this.f1455c);
        long jM3598a = MessageIDGenerator.m3598a();
        SSMGPB.AllowChatRequest.Builder builderM860r = SSMGPB.AllowChatRequest.m860r();
        builderM860r.m883a(jM3598a).m886a(SSMGPB.ChatType.m1239a(this.f1508g.m2189a())).m893d(ChatONPref.m3519a().getString("uid", "")).m895e(DeviceInfoUtil.m3564a()).m891c(ChatONPref.m3519a().getString("msisdn", ""));
        if (this.f1510i == null || this.f1510i.length == 0) {
            builderM860r.m890b(this.f1511j);
        } else {
            builderM860r.m890b(String.valueOf(this.f1510i[0]));
        }
        if (!TextUtils.isEmpty(this.f1509h)) {
            builderM860r.m887a(this.f1509h);
        }
        ChatONLogWriter.m3508c("ch@t[AllowChatRequest]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ChatType : " + builderM860r.m899h() + ", MsgID : " + builderM860r.m898g() + ", Receiver : " + builderM860r.m902k() + ", Sender : " + builderM860r.m901j() + ", SessionID : " + builderM860r.m900i(), getClass().getSimpleName());
        TcpEnvelope.Builder builder = new TcpEnvelope.Builder();
        builder.m2811a(2).m2813a(builderM860r.build()).m2812a(20000L);
        return builder.m2816b();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 8;
        if (obj2 == null) {
            if (this.f1456d >= f1453a) {
                InBoxDatabaseHelper.m2263e(this.f1512k, this.f1511j);
            }
            ChatONLogWriter.m3508c("Fail to send endChat message", getClass().getSimpleName());
            message.obj = new MessageResultEntry(false, ResultEntry.Result.NETWORKFAIL);
            this.f1454b.sendMessage(message);
            return;
        }
        TcpEnvelope tcpEnvelope = (TcpEnvelope) obj2;
        switch (tcpEnvelope.m2805b()) {
            case 3:
                SSMGPB.AllowChatReply allowChatReply = (SSMGPB.AllowChatReply) tcpEnvelope.m2806c();
                ChatONLogWriter.m3508c("ch@t[" + allowChatReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", MsgID : " + allowChatReply.m822d() + ", ResultCode : " + allowChatReply.m824f().m1898d() + ", ResultMsg : " + allowChatReply.m824f().m1900f(), getClass().getSimpleName());
                int iM1898d = allowChatReply.m824f().m1898d();
                if (iM1898d != 1000) {
                    message.obj = new MessageResultEntry(false, iM1898d, this.f1511j);
                    break;
                } else {
                    message.obj = new MessageResultEntry(true, 10000, this.f1511j);
                    break;
                }
            case 9:
                SSMGPB.EndChatReply endChatReply = (SSMGPB.EndChatReply) tcpEnvelope.m2806c();
                ChatONLogWriter.m3508c("ch@t[" + endChatReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ResultCode : " + endChatReply.m1455f().m1898d() + ", ResultMessage : " + endChatReply.m1455f().m1900f() + ", MsgID : " + endChatReply.m1453d(), getClass().getSimpleName());
                int iM1898d2 = endChatReply.m1455f().m1898d();
                if (iM1898d2 != 1000 && iM1898d2 != 6002 && iM1898d2 != 1001 && iM1898d2 != 3006) {
                    ChatONLogWriter.m3509d("reply.getResult().getResultCode():" + iM1898d2);
                    message.obj = new MessageResultEntry(false, iM1898d2);
                    break;
                } else {
                    this.f1512k.delete(ChatONContract.MessageTable.f1726a, "message_inbox_no=?", new String[]{this.f1511j});
                    this.f1512k.delete(ChatONContract.InBoxTable.f1717a, "inbox_no=?", new String[]{this.f1511j});
                    this.f1512k.delete(ChatONContract.ParticipantTable.f1741a, "participants_inbox_no=?", new String[]{this.f1511j});
                    message.obj = new MessageResultEntry(true, iM1898d2);
                    break;
                }
        }
        this.f1454b.sendMessage(message);
    }
}
