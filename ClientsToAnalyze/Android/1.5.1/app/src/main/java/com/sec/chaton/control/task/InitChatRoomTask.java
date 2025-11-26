package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.MessageIDGenerator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class InitChatRoomTask extends AbstractNetTask {

    /* renamed from: g */
    private ChatONContract.MessageTable.MsgContentType f1600g;

    /* renamed from: h */
    private ChatONContract.InBoxTable.ChatType f1601h;

    /* renamed from: i */
    private String[] f1602i;

    /* renamed from: j */
    private String f1603j;

    /* renamed from: k */
    private ContentResolver f1604k;

    /* renamed from: l */
    private String f1605l;

    /* renamed from: m */
    private String f1606m;

    public class InitChatRoomResultEntry extends MessageResultEntry {

        /* renamed from: d */
        public String f1607d;

        /* renamed from: e */
        public ArrayList f1608e;

        public InitChatRoomResultEntry(boolean z, String str, int i) {
            super(z, i);
            this.f1607d = str;
            this.f1608e = null;
        }

        public InitChatRoomResultEntry(boolean z, String str, int i, ArrayList arrayList) {
            super(z, i);
            this.f1607d = str;
            this.f1608e = arrayList;
        }
    }

    public InitChatRoomTask(Handler handler, String str, long j, ChatONContract.MessageTable.MsgContentType msgContentType, ChatONContract.InBoxTable.ChatType chatType, String[] strArr, String str2) {
        super(handler);
        this.f1606m = "";
        this.f1457e = j;
        this.f1605l = str;
        this.f1600g = msgContentType;
        this.f1601h = chatType;
        this.f1602i = strArr;
        this.f1603j = str2;
        this.f1604k = GlobalApplication.m2387e().getContentResolver();
    }

    public InitChatRoomTask(Handler handler, String str, ChatONContract.MessageTable.MsgContentType msgContentType, ChatONContract.InBoxTable.ChatType chatType, String[] strArr, String str2) {
        super(handler);
        this.f1606m = "";
        this.f1457e = -1L;
        this.f1605l = str;
        this.f1600g = msgContentType;
        this.f1601h = chatType;
        this.f1602i = strArr;
        this.f1603j = str2;
        this.f1604k = GlobalApplication.m2387e().getContentResolver();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        if (this.f1457e == -1) {
            this.f1457e = MessageIDGenerator.m3598a();
            MessageDatabaseHelper.m2274a(this.f1604k, String.valueOf(this.f1457e), this.f1605l, this.f1600g, this.f1603j, this.f1602i.length);
        } else {
            MessageDatabaseHelper.m2301c(this.f1604k, Long.valueOf(this.f1457e));
        }
        SSMGPB.InitChatRequest.Builder builderM1693e = SSMGPB.InitChatRequest.m1652v().m1679a(this.f1457e).m1683a(SSMGPB.MsgType.m1792a(this.f1600g.m2197a())).m1681a(SSMGPB.ChatType.m1239a(this.f1601h.m2189a())).m1684a(ChatONPref.m3519a().getString("uid", "")).m1688b(DeviceInfoUtil.m3564a()).m1689c(ChatONPref.m3519a().getString("msisdn", "")).m1693e(this.f1603j);
        for (String str : this.f1602i) {
            builderM1693e.m1691d(str);
            this.f1606m += " " + str;
        }
        ChatONLogWriter.m3508c("InitChatRequest : InBoxNo=" + this.f1605l + " MsgID = " + this.f1457e + " ChatType = " + this.f1601h + " Receiver = " + this.f1606m + "ChatMsg = " + this.f1603j, getClass().getName());
        ChatONLogWriter.m3508c("ch@t[" + builderM1693e.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", InBoxNo : " + this.f1605l + ", ChatType : " + builderM1693e.m1698i().m1240a() + ", MsgID : " + builderM1693e.m1696g() + ", ChatMsg : " + builderM1693e.m1703n() + ", Sender : " + builderM1693e.m1700k() + ", Receivers : " + ChatONLogWriter.m3494a(builderM1693e.m1701l()), getClass().getSimpleName());
        return new TcpEnvelope.Builder().m2811a(0).m2813a(builderM1693e.build()).m2812a(20000L).m2816b();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 0;
        if (obj2 == null) {
            if (this.f1456d >= f1453a) {
                MessageDatabaseHelper.m2278a(this.f1604k, Long.valueOf(this.f1457e));
                InBoxDatabaseHelper.m2263e(this.f1604k, this.f1605l);
            }
            message.obj = new MessageResultEntry(false, ResultEntry.Result.NETWORKFAIL);
            this.f1454b.sendMessage(message);
            ChatONLogWriter.m3508c("InitChatReply : InBoxNO = " + this.f1605l + ", InitChat Fail", getClass().getSimpleName());
            return;
        }
        SSMGPB.InitChatReply initChatReply = (SSMGPB.InitChatReply) ((TcpEnvelope) obj2).m2806c();
        ChatONLogWriter.m3508c("ch@t[" + initChatReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ResultCode : " + initChatReply.m1606l().m1898d() + ", ResultMessage : " + initChatReply.m1606l().m1900f() + ", InBoxNo : " + this.f1605l + ", MsgReceivedTime : " + initChatReply.m1602h() + ", MsgID : " + initChatReply.m1598d() + ", ServerInfo(address) : " + (initChatReply.m1604j() != null ? initChatReply.m1604j().m1925d() : "null(broadcast)") + ", ServerInfo(port) : " + (initChatReply.m1604j() != null ? Integer.valueOf(initChatReply.m1604j().m1927f()) : "null(broadcast)") + ", SessionID : " + initChatReply.m1600f(), getClass().getSimpleName());
        int iM1898d = initChatReply.m1606l().m1898d();
        String strM1900f = initChatReply.m1606l().m1900f();
        if (iM1898d == 1000 || iM1898d == 1001) {
            for (int i2 = 0; i2 < this.f1602i.length; i2++) {
                if (!ParticipantDatabaseHelper.m2309a(this.f1604k, this.f1602i[i2], this.f1605l)) {
                    ParticipantDatabaseHelper.m2313c(this.f1604k, this.f1605l, this.f1602i[i2]);
                }
            }
            InBoxDatabaseHelper.m2243a(this.f1604k, this.f1605l, initChatReply, this.f1603j, this.f1601h, this.f1602i.length, this.f1600g);
            MessageDatabaseHelper.m2282a(this.f1604k, Long.valueOf(initChatReply.m1602h()), initChatReply.m1600f(), initChatReply.m1598d(), Long.valueOf(this.f1457e), this.f1602i.length);
            if (iM1898d == 1001) {
                String[] strArrSplit = strM1900f.substring(strM1900f.indexOf("[") + 1, strM1900f.indexOf("]")).trim().split(",");
                ArrayList arrayList = new ArrayList();
                for (String str : strArrSplit) {
                    String strM2317e = ParticipantDatabaseHelper.m2317e(this.f1604k, this.f1605l, str);
                    ChatONLogWriter.m3508c("1001 error - invalidUserName:" + strM2317e, getClass().getSimpleName());
                    arrayList.add(strM2317e);
                    ParticipantDatabaseHelper.m2316d(this.f1604k, this.f1605l, str);
                }
                if (this.f1601h == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                    InBoxDatabaseHelper.m2260c(this.f1604k, this.f1605l);
                } else {
                    InBoxDatabaseHelper.m2258b(this.f1604k, this.f1605l);
                }
                message.obj = new InitChatRoomResultEntry(true, initChatReply.m1600f(), iM1898d, arrayList);
            } else {
                message.obj = new InitChatRoomResultEntry(true, initChatReply.m1600f(), iM1898d);
            }
        } else {
            message.obj = new MessageResultEntry(false, iM1898d);
            ChatONLogWriter.m3508c("InitChatReply : InBoxNO = " + this.f1605l + ", InitChat Fail", getClass().getSimpleName());
            if (iM1898d == 3001 || iM1898d == 3002) {
                MessageDatabaseHelper.m2279a(this.f1604k, Long.valueOf(this.f1457e), Long.valueOf(MessageIDGenerator.m3598a()));
            } else {
                MessageDatabaseHelper.m2278a(this.f1604k, Long.valueOf(this.f1457e));
            }
        }
        this.f1454b.sendMessage(message);
    }
}
