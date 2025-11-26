package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.chat.ChatUtil;
import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.network.TcpClient;
import com.sec.chaton.network.TcpEnvelope;
import com.sec.chaton.p000io.entry.GetUnReadMessageList;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.MessageIDGenerator;
import com.sec.chaton.util.ServerAddressMgr;

/* loaded from: classes.dex */
public class ChatTask extends AbstractNetTask {

    /* renamed from: g */
    private ChatONContract.MessageTable.MsgContentType f1485g;

    /* renamed from: h */
    private ChatONContract.InBoxTable.ChatType f1486h;

    /* renamed from: i */
    private String f1487i;

    /* renamed from: j */
    private String[] f1488j;

    /* renamed from: k */
    private String f1489k;

    /* renamed from: l */
    private String f1490l;

    /* renamed from: m */
    private ContentResolver f1491m;

    /* renamed from: n */
    private boolean f1492n;

    /* renamed from: o */
    private String f1493o;

    public ChatTask(Handler handler, long j, String str, ChatONContract.MessageTable.MsgContentType msgContentType, ChatONContract.InBoxTable.ChatType chatType, String str2, String str3) {
        super(handler);
        this.f1493o = "";
        this.f1457e = j;
        this.f1490l = str;
        this.f1485g = msgContentType;
        this.f1487i = str2;
        this.f1486h = chatType;
        this.f1489k = str3;
        this.f1491m = GlobalApplication.m2387e().getContentResolver();
        this.f1492n = false;
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        this.f1488j = ParticipantDatabaseHelper.m2312b(this.f1491m, this.f1490l);
        if (!TcpClient.m2759a(this.f1455c)) {
            InBoxDatabaseHelper.m2250a(this.f1491m, this.f1490l, this.f1455c);
            long jM3598a = MessageIDGenerator.m3598a();
            SSMGPB.AllowChatRequest.Builder builderM860r = SSMGPB.AllowChatRequest.m860r();
            builderM860r.m883a(jM3598a).m886a(SSMGPB.ChatType.m1239a(this.f1486h.m2189a())).m893d(ChatONPref.m3519a().getString("uid", "")).m895e(DeviceInfoUtil.m3564a()).m891c(ChatONPref.m3519a().getString("msisdn", ""));
            if (this.f1488j == null || this.f1488j.length == 0) {
                builderM860r.m890b(this.f1490l);
            } else {
                builderM860r.m890b(String.valueOf(this.f1488j[0]));
            }
            if (!TextUtils.isEmpty(this.f1487i)) {
                builderM860r.m887a(this.f1487i);
            }
            ChatONLogWriter.m3508c("ch@t[AllowChatRequest]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ChatType : " + builderM860r.m899h() + ", MsgID : " + builderM860r.m898g() + ", Receiver : " + builderM860r.m902k() + ", Sender : " + builderM860r.m901j() + ", SessionID : " + builderM860r.m900i(), getClass().getSimpleName());
            TcpEnvelope.Builder builder = new TcpEnvelope.Builder();
            builder.m2811a(2).m2813a(builderM860r.build()).m2812a(20000L);
            return builder.m2816b();
        }
        if (this.f1492n) {
            if (new GetAllUnReadMessageTask(new Handler(), new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/inboxes").m2738a(HttpEnvelope.RequestMethod.GET).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2737a(801).m2739a(GetUnReadMessageList.class).m2742a()).runForNonThread().m1951b() == HttpResultCode.ERROR) {
                return null;
            }
            new SetReadMessage(new Handler(), new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/inbox").m2738a(HttpEnvelope.RequestMethod.POST).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2737a(802).m2742a(), this.f1490l).runForNonThread();
            this.f1488j = ParticipantDatabaseHelper.m2312b(this.f1491m, this.f1490l);
        }
        SSMGPB.ChatRequest.Builder builderM1226f = SSMGPB.ChatRequest.m1182x().m1211a(this.f1457e).m1214a(SSMGPB.ChatType.m1239a(this.f1486h.m2189a())).m1216a(this.f1487i).m1222d(ChatONPref.m3519a().getString("uid", "")).m1224e(DeviceInfoUtil.m3564a()).m1219b(ChatONPref.m3519a().getString("msisdn", "")).m1226f(this.f1489k);
        if (this.f1485g.m2197a() == 3) {
            builderM1226f.m1215a(SSMGPB.MsgType.m1792a(1));
        } else {
            builderM1226f.m1215a(SSMGPB.MsgType.m1792a(this.f1485g.m2197a()));
        }
        for (String str : this.f1488j) {
            builderM1226f.m1220c(str);
            this.f1493o += " " + str;
        }
        ChatONLogWriter.m3508c("ch@t[" + builderM1226f.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", InBoxNo : " + this.f1490l + ", ChatMsg : " + builderM1226f.m1237o() + ", ChatType : " + builderM1226f.m1231i() + ", MsgID : " + builderM1226f.m1228g() + ", MsgType : " + builderM1226f.m1230h() + ", ReceiverList : " + ChatONLogWriter.m3494a(builderM1226f.m1234l()) + ", Sender : " + builderM1226f.m1233k() + ", SessionID : " + builderM1226f.m1232j(), getClass().getSimpleName());
        return new TcpEnvelope.Builder().m2811a(4).m2813a(builderM1226f.build()).m2812a(20000L).m2816b();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 4;
        if (obj2 == null) {
            ChatONLogWriter.m3508c("Fail to send message__", getClass().getSimpleName());
            if (this.f1456d >= f1453a) {
                MessageDatabaseHelper.m2278a(this.f1491m, Long.valueOf(this.f1457e));
                InBoxDatabaseHelper.m2263e(this.f1491m, this.f1490l);
            }
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
                if (iM1898d == 1000) {
                    message.obj = new MessageResultEntry(true, 10000, this.f1490l);
                    break;
                } else {
                    if (iM1898d == 3003) {
                        InBoxDatabaseHelper.m2242a(GlobalApplication.m2387e().getContentResolver(), this.f1490l, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                    } else {
                        MessageDatabaseHelper.m2278a(this.f1491m, Long.valueOf(this.f1457e));
                    }
                    message.obj = new MessageResultEntry(false, iM1898d, this.f1490l);
                    break;
                }
            case 5:
                SSMGPB.ChatReply chatReply = (SSMGPB.ChatReply) tcpEnvelope.m2806c();
                ChatONLogWriter.m3508c("ch@t[" + chatReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", Msg ID : " + chatReply.m1126d() + ", MsgReceivedTime : " + chatReply.m1132j() + ", SessionID : " + chatReply.m1128f() + ", ResultCode : " + chatReply.m1134l().m1898d() + ", ResultMsg : " + chatReply.m1134l().m1900f() + ", ServerInfo(address) : " + (chatReply.m1130h() != null ? chatReply.m1130h().m1925d() : "null") + ", ServerInfo(port) : " + (chatReply.m1130h() != null ? Integer.valueOf(chatReply.m1130h().m1927f()) : "null"), getClass().getSimpleName());
                int iM1898d2 = chatReply.m1134l().m1898d();
                String strM1900f = chatReply.m1134l().m1900f();
                if (iM1898d2 != 1000 && iM1898d2 != 1001) {
                    MessageDatabaseHelper.m2278a(this.f1491m, Long.valueOf(this.f1457e));
                    message.obj = new MessageResultEntry(false, iM1898d2);
                    break;
                } else {
                    MessageDatabaseHelper.m2282a(this.f1491m, Long.valueOf(chatReply.m1132j()), chatReply.m1128f(), chatReply.m1126d(), Long.valueOf(this.f1457e), this.f1488j.length);
                    InBoxDatabaseHelper.m2252a(this.f1491m, ChatONPref.m3519a().getString("msisdn", ""), this.f1490l, this.f1489k, chatReply.m1132j(), chatReply.m1128f(), chatReply.m1130h().m1925d(), Integer.valueOf(chatReply.m1130h().m1927f()), Long.valueOf(chatReply.m1126d()), this.f1488j.length, this.f1485g);
                    if (iM1898d2 == 1001) {
                        String[] strArrSplit = strM1900f.substring(strM1900f.indexOf("[") + 1, strM1900f.indexOf("]")).trim().split(",");
                        StringBuilder sb = new StringBuilder();
                        for (String str : strArrSplit) {
                            if (ParticipantDatabaseHelper.m2309a(this.f1491m, str, this.f1490l)) {
                                String strM2317e = ParticipantDatabaseHelper.m2317e(this.f1491m, this.f1490l, str);
                                ChatONLogWriter.m3508c("1001 error - invalidUserName:" + strM2317e, getClass().getSimpleName());
                                sb.append(String.format("%s,%s,%s", "LEAVE", str, ChatUtil.m795a(strM2317e))).append(";");
                                ParticipantDatabaseHelper.m2316d(this.f1491m, this.f1490l, str);
                            }
                        }
                        if (sb.length() > 0) {
                            MessageDatabaseHelper.m2297b(this.f1491m, this.f1490l, sb.toString());
                        }
                        InBoxDatabaseHelper.m2258b(this.f1491m, this.f1490l);
                    }
                    message.obj = new MessageResultEntry(true, iM1898d2);
                    break;
                }
                break;
        }
        this.f1454b.sendMessage(message);
    }
}
