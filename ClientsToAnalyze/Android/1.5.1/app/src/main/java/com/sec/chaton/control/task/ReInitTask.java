package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.os.Message;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;

/* loaded from: classes.dex */
public class ReInitTask extends AbstractNetTask {

    /* renamed from: g */
    private long f1644g;

    /* renamed from: h */
    private String f1645h;

    /* renamed from: i */
    private ChatONContract.MessageTable.MsgContentType f1646i;

    /* renamed from: j */
    private ChatONContract.InBoxTable.ChatType f1647j;

    /* renamed from: k */
    private String[] f1648k;

    /* renamed from: l */
    private String f1649l;

    /* renamed from: m */
    private ContentResolver f1650m;

    public class InitChatRoomResultEntry extends MessageResultEntry {

        /* renamed from: d */
        public String f1651d;

        public InitChatRoomResultEntry(boolean z, String str, int i) {
            super(z, i);
            this.f1651d = str;
        }
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        SSMGPB.InitChatRequest.Builder builderM1693e = SSMGPB.InitChatRequest.m1652v().m1679a(this.f1644g).m1683a(SSMGPB.MsgType.m1792a(this.f1646i.m2197a())).m1681a(SSMGPB.ChatType.m1239a(this.f1647j.m2189a())).m1684a(ChatONPref.m3519a().getString("uid", "")).m1688b(DeviceInfoUtil.m3564a()).m1689c(ChatONPref.m3519a().getString("msisdn", "")).m1693e(this.f1649l);
        for (String str : this.f1648k) {
            builderM1693e.m1691d(str);
        }
        ChatONLogWriter.m3508c("ch@t[" + builderM1693e.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", InBoxNo : " + this.f1645h + ", MsgID : " + builderM1693e.m1696g() + ", MsgType : " + builderM1693e.m1697h() + ", ChatMsg : " + builderM1693e.m1703n() + ", Sender : " + builderM1693e.m1700k() + ", IMEI : " + builderM1693e.m1699j() + ", ReceiverCount : " + builderM1693e.m1702m() + ", ReceiversList : " + ChatONLogWriter.m3494a(builderM1693e.m1701l()), getClass().getSimpleName());
        return new TcpEnvelope.Builder().m2811a(0).m2813a(builderM1693e.build()).m2812a(20000L).m2816b();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 0;
        if (obj2 != null) {
            SSMGPB.InitChatReply initChatReply = (SSMGPB.InitChatReply) ((TcpEnvelope) obj2).m2806c();
            ChatONLogWriter.m3508c("ch@t[" + initChatReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ResultCode : " + initChatReply.m1606l().m1898d() + ", ResultMessage : " + initChatReply.m1606l().m1900f() + ", InBoxNo : " + this.f1645h + ", MsgID : " + initChatReply.m1598d() + ", MsgReceivedTime : " + initChatReply.m1602h() + ", SessionID : " + initChatReply.m1600f() + ", ServerInfo(address) : " + (initChatReply.m1604j() != null ? initChatReply.m1604j().m1925d() : "null") + ", ServerInfo(port) : " + (initChatReply.m1604j() != null ? Integer.valueOf(initChatReply.m1604j().m1927f()) : "null"), getClass().getSimpleName());
            int iM1898d = initChatReply.m1606l().m1898d();
            if (iM1898d == 1000 || ((iM1898d == 6002 && this.f1647j != ChatONContract.InBoxTable.ChatType.ONETOONE) || iM1898d == 1001)) {
                ChatONLogWriter.m3508c(initChatReply.m1604j().m1925d(), getClass().getSimpleName());
                InBoxDatabaseHelper.m2240a(this.f1650m, this.f1645h, initChatReply, this.f1647j, this.f1649l, this.f1648k, this.f1646i);
                MessageDatabaseHelper.m2282a(this.f1650m, Long.valueOf(initChatReply.m1602h()), initChatReply.m1600f(), initChatReply.m1598d(), Long.valueOf(this.f1644g), this.f1648k.length);
                message.obj = new InitChatRoomResultEntry(true, initChatReply.m1600f(), iM1898d);
                this.f1454b.sendMessage(message);
                return;
            }
            message.obj = new InitChatRoomResultEntry(false, initChatReply.m1600f(), iM1898d);
            this.f1454b.sendMessage(message);
        } else {
            message.obj = new MessageResultEntry(false, ResultEntry.Result.NETWORKFAIL);
            this.f1454b.sendMessage(message);
        }
        ChatONLogWriter.m3508c("InBoxNO : " + this.f1645h + ", InitChat Fail", getClass().getSimpleName());
        MessageDatabaseHelper.m2278a(this.f1650m, Long.valueOf(this.f1644g));
    }
}
