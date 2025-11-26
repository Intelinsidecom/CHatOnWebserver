package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.C0062R;
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
import com.sec.chaton.util.StorageStateInfoUtil;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MediaChatTask extends AbstractNetTask {

    /* renamed from: g */
    private String f1616g;

    /* renamed from: h */
    private File f1617h;

    /* renamed from: i */
    private String f1618i;

    /* renamed from: j */
    private ChatONContract.MessageTable.MsgContentType f1619j;

    /* renamed from: k */
    private ChatONContract.InBoxTable.ChatType f1620k;

    /* renamed from: l */
    private String f1621l;

    /* renamed from: m */
    private String[] f1622m;

    /* renamed from: n */
    private boolean f1623n;

    /* renamed from: o */
    private String f1624o;

    /* renamed from: p */
    private ContentResolver f1625p;

    /* renamed from: q */
    private String f1626q;

    /* renamed from: r */
    private String f1627r;

    /* renamed from: s */
    private String f1628s;

    /* renamed from: t */
    private String f1629t;

    /* renamed from: u */
    private boolean f1630u;

    public class MediaIntiChatRoomReulstEntry extends MessageResultEntry {

        /* renamed from: d */
        public String f1631d;

        /* renamed from: e */
        public ArrayList f1632e;

        public MediaIntiChatRoomReulstEntry(boolean z, String str, int i) {
            super(z, i);
            this.f1631d = str;
        }

        public MediaIntiChatRoomReulstEntry(boolean z, String str, int i, ArrayList arrayList) {
            super(z, i);
            this.f1631d = str;
            this.f1632e = arrayList;
        }
    }

    public MediaChatTask(Handler handler, String str, long j, File file, String str2, ChatONContract.MessageTable.MsgContentType msgContentType, ChatONContract.InBoxTable.ChatType chatType, String str3, String[] strArr, String str4, boolean z, String str5) {
        super(handler);
        this.f1617h = file;
        this.f1618i = str2;
        this.f1616g = str;
        this.f1619j = msgContentType;
        this.f1620k = chatType;
        this.f1621l = str3;
        this.f1622m = strArr;
        this.f1624o = str4;
        this.f1623n = z;
        this.f1628s = str5;
        this.f1625p = GlobalApplication.m2387e().getContentResolver();
        this.f1457e = j;
        this.f1629t = "";
        this.f1630u = false;
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected TcpEnvelope mo2107a() {
        switch (C0197f.f1690a[this.f1619j.ordinal()]) {
            case 1:
                this.f1626q = "image";
                this.f1627r = GlobalApplication.m2388f().getString(C0062R.string.last_message_me_image);
                break;
            case 2:
                this.f1626q = "audio";
                this.f1627r = GlobalApplication.m2388f().getString(C0062R.string.last_message_me_voice);
                break;
            case 3:
                this.f1626q = "calendar";
                this.f1627r = GlobalApplication.m2388f().getString(C0062R.string.last_message_me_calendar);
                break;
            case 4:
                this.f1626q = "contact";
                this.f1627r = GlobalApplication.m2388f().getString(C0062R.string.last_message_me_contact);
                break;
            case 5:
                this.f1626q = "geo";
                this.f1627r = GlobalApplication.m2388f().getString(C0062R.string.last_message_me_location);
                break;
            case 6:
                this.f1626q = "video";
                this.f1627r = GlobalApplication.m2388f().getString(C0062R.string.last_message_me_video);
                break;
        }
        if (this.f1619j == ChatONContract.MessageTable.MsgContentType.GEO) {
            this.f1629t = this.f1628s;
        } else {
            String strSubstring = this.f1618i;
            if (this.f1618i != null && this.f1618i.startsWith(".")) {
                strSubstring = this.f1618i.substring(1);
            }
            this.f1629t = this.f1626q + "\n" + strSubstring + "\n" + this.f1624o;
            if (this.f1619j == ChatONContract.MessageTable.MsgContentType.CONTACT || this.f1619j == ChatONContract.MessageTable.MsgContentType.CALENDAR) {
                this.f1629t += "\n" + this.f1628s;
            }
        }
        if (ChatONContract.MessageTable.MsgContentType.GEO != this.f1619j) {
            MessageDatabaseHelper.m2287a(this.f1625p, (String) null, (String) null, Long.valueOf(this.f1457e), this.f1629t, this.f1620k, StorageStateInfoUtil.m3677a());
        }
        TcpEnvelope.Builder builder = new TcpEnvelope.Builder();
        if (this.f1623n) {
            ChatONLogWriter.m3511e("Msg ID(File) : " + this.f1457e, getClass().getSimpleName());
            SSMGPB.InitChatRequest.Builder builderM1693e = SSMGPB.InitChatRequest.m1652v().m1679a(this.f1457e).m1683a(SSMGPB.MsgType.m1792a(1)).m1681a(SSMGPB.ChatType.m1239a(this.f1620k.m2189a())).m1684a(ChatONPref.m3519a().getString("uid", "")).m1688b(DeviceInfoUtil.m3564a()).m1689c(ChatONPref.m3519a().getString("msisdn", "")).m1693e(this.f1629t);
            ChatONLogWriter.m3511e("MsgType : " + this.f1619j.m2197a() + ", ChatType : " + this.f1620k.m2189a(), getClass().getSimpleName());
            for (String str : this.f1622m) {
                builderM1693e.m1691d(str);
            }
            ChatONLogWriter.m3511e("Content : " + builderM1693e.m1703n(), getClass().getSimpleName());
            ChatONLogWriter.m3508c("ch@t[" + builderM1693e.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", InBoxNo : " + this.f1616g + ", MsgType : " + builderM1693e.m1697h() + ", ChatType : " + builderM1693e.m1698i() + ", MsgID : " + builderM1693e.m1696g() + ", ChatMsg : " + builderM1693e.m1703n() + ", Sender : " + builderM1693e.m1700k() + ", Receivers : " + ChatONLogWriter.m3494a(builderM1693e.m1701l()), getClass().getSimpleName());
            builder.m2811a(0).m2813a(builderM1693e.build()).m2812a(20000L);
        } else if (TcpClient.m2759a(this.f1455c)) {
            if (this.f1630u) {
                if (new GetAllUnReadMessageTask(new Handler(), new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/inboxes").m2738a(HttpEnvelope.RequestMethod.GET).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2737a(801).m2739a(GetUnReadMessageList.class).m2742a()).runForNonThread().m1951b() == HttpResultCode.ERROR) {
                    return null;
                }
                new SetReadMessage(new Handler(), new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/inbox").m2738a(HttpEnvelope.RequestMethod.POST).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2737a(802).m2742a(), this.f1616g).runForNonThread();
                this.f1622m = ParticipantDatabaseHelper.m2312b(this.f1625p, this.f1616g);
            }
            SSMGPB.ChatRequest.Builder builderM1226f = SSMGPB.ChatRequest.m1182x().m1211a(this.f1457e).m1215a(SSMGPB.MsgType.m1792a(1)).m1214a(SSMGPB.ChatType.m1239a(this.f1620k.m2189a())).m1216a(this.f1621l).m1222d(ChatONPref.m3519a().getString("uid", "")).m1224e(DeviceInfoUtil.m3564a()).m1219b(ChatONPref.m3519a().getString("msisdn", "")).m1226f(this.f1629t);
            for (String str2 : this.f1622m) {
                builderM1226f.m1220c(str2);
            }
            ChatONLogWriter.m3508c("ch@t[" + builderM1226f.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", InBoxNo : " + this.f1616g + ", ChatMsg : " + builderM1226f.m1237o() + ", ChatType : " + builderM1226f.m1231i() + ", MsgID : " + builderM1226f.m1228g() + ", MsgType : " + builderM1226f.m1230h() + ", ReceiverList : " + ChatONLogWriter.m3494a(builderM1226f.m1234l()) + ", Sender : " + builderM1226f.m1233k() + ", SessionID : " + builderM1226f.m1232j(), getClass().getSimpleName());
            builder.m2811a(4).m2813a(builderM1226f.build()).m2812a(20000L);
        } else {
            InBoxDatabaseHelper.m2250a(this.f1625p, this.f1616g, this.f1455c);
            long jM3598a = MessageIDGenerator.m3598a();
            SSMGPB.AllowChatRequest.Builder builderM860r = SSMGPB.AllowChatRequest.m860r();
            builderM860r.m883a(jM3598a).m886a(SSMGPB.ChatType.m1239a(this.f1620k.m2189a())).m893d(ChatONPref.m3519a().getString("uid", "")).m895e(DeviceInfoUtil.m3564a()).m891c(ChatONPref.m3519a().getString("msisdn", ""));
            if (this.f1622m == null || this.f1622m.length == 0) {
                builderM860r.m890b(this.f1616g);
            } else {
                builderM860r.m890b(String.valueOf(this.f1622m[0]));
            }
            if (!TextUtils.isEmpty(this.f1621l)) {
                builderM860r.m887a(this.f1621l);
            }
            ChatONLogWriter.m3508c("ch@t[AllowChatRequest]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ChatType : " + builderM860r.m899h() + ", MsgID : " + builderM860r.m898g() + ", Receiver : " + builderM860r.m902k() + ", Sender : " + builderM860r.m901j() + ", SessionID : " + builderM860r.m900i(), getClass().getSimpleName());
            builder.m2811a(2).m2813a(builderM860r.build()).m2812a(20000L);
        }
        return builder.m2816b();
    }

    @Override // com.sec.chaton.control.task.AbstractNetTask
    /* renamed from: a */
    protected void mo2108a(int i, Object obj, Object obj2) {
        Message message = new Message();
        if (obj2 == null) {
            if (this.f1456d >= f1453a) {
                if (this.f1619j == ChatONContract.MessageTable.MsgContentType.GEO) {
                    MessageDatabaseHelper.m2278a(this.f1625p, Long.valueOf(this.f1457e));
                } else {
                    MessageDatabaseHelper.m2283a(this.f1625p, Long.valueOf(this.f1457e), false);
                }
                InBoxDatabaseHelper.m2263e(this.f1625p, this.f1616g);
            }
            message.obj = new MessageResultEntry(false, ResultEntry.Result.NETWORKFAIL);
            this.f1454b.sendMessage(message);
            return;
        }
        TcpEnvelope tcpEnvelope = (TcpEnvelope) obj2;
        switch (tcpEnvelope.m2805b()) {
            case 1:
                message.what = 0;
                SSMGPB.InitChatReply initChatReply = (SSMGPB.InitChatReply) tcpEnvelope.m2806c();
                ChatONLogWriter.m3508c("resultCode : " + initChatReply.m1606l().m1898d() + " resultMessage : " + initChatReply.m1606l().m1900f(), getClass().getSimpleName());
                ChatONLogWriter.m3508c("ch@t[" + initChatReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", ResultCode : " + initChatReply.m1606l().m1898d() + ", ResultMessage : " + initChatReply.m1606l().m1900f() + ", InBoxNo : " + this.f1616g + ", MsgReceivedTime : " + initChatReply.m1602h() + ", MsgID : " + initChatReply.m1598d() + ", ServerInfo(address) : " + (initChatReply.m1604j() != null ? initChatReply.m1604j().m1925d() : "null(broadcast)") + ", ServerInfo(port) : " + (initChatReply.m1604j() != null ? Integer.valueOf(initChatReply.m1604j().m1927f()) : "null(broadcast)") + ", SessionID : " + initChatReply.m1600f(), getClass().getSimpleName());
                int iM1898d = initChatReply.m1606l().m1898d();
                String strM1900f = initChatReply.m1606l().m1900f();
                if (iM1898d != 1000 && iM1898d != 1001) {
                    if (iM1898d == 3001 || iM1898d == 3002) {
                        if (this.f1619j == ChatONContract.MessageTable.MsgContentType.GEO) {
                            MessageDatabaseHelper.m2279a(this.f1625p, Long.valueOf(this.f1457e), Long.valueOf(MessageIDGenerator.m3598a()));
                        } else {
                            MessageDatabaseHelper.m2280a(this.f1625p, Long.valueOf(this.f1457e), Long.valueOf(MessageIDGenerator.m3598a()), false);
                        }
                    } else if (this.f1619j == ChatONContract.MessageTable.MsgContentType.GEO) {
                        MessageDatabaseHelper.m2278a(this.f1625p, Long.valueOf(this.f1457e));
                    } else {
                        MessageDatabaseHelper.m2283a(this.f1625p, Long.valueOf(this.f1457e), false);
                    }
                    message.obj = new MediaIntiChatRoomReulstEntry(false, null, iM1898d);
                    this.f1454b.sendMessage(message);
                    break;
                } else {
                    for (int i2 = 0; i2 < this.f1622m.length; i2++) {
                        if (!ParticipantDatabaseHelper.m2309a(this.f1625p, this.f1622m[i2], this.f1616g)) {
                            ParticipantDatabaseHelper.m2313c(this.f1625p, this.f1616g, this.f1622m[i2]);
                        }
                    }
                    InBoxDatabaseHelper.m2243a(this.f1625p, this.f1616g, initChatReply, this.f1629t, this.f1620k, this.f1622m.length, this.f1619j);
                    MessageDatabaseHelper.m2282a(this.f1625p, Long.valueOf(initChatReply.m1602h()), initChatReply.m1600f(), initChatReply.m1598d(), Long.valueOf(this.f1457e), this.f1622m.length);
                    if (iM1898d == 1001) {
                        String[] strArrSplit = strM1900f.substring(strM1900f.indexOf("[") + 1, strM1900f.indexOf("]")).trim().split(",");
                        ArrayList arrayList = new ArrayList();
                        for (String str : strArrSplit) {
                            String strM2317e = ParticipantDatabaseHelper.m2317e(this.f1625p, this.f1616g, str);
                            ChatONLogWriter.m3508c("1001 error - invalidUserName:" + strM2317e, getClass().getSimpleName());
                            arrayList.add(strM2317e);
                            ParticipantDatabaseHelper.m2316d(this.f1625p, this.f1616g, str);
                        }
                        if (this.f1620k == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                            InBoxDatabaseHelper.m2260c(this.f1625p, this.f1616g);
                        } else {
                            InBoxDatabaseHelper.m2258b(this.f1625p, this.f1616g);
                        }
                        message.obj = new MediaIntiChatRoomReulstEntry(true, initChatReply.m1600f(), iM1898d, arrayList);
                    } else {
                        message.obj = new MediaIntiChatRoomReulstEntry(true, initChatReply.m1600f(), iM1898d);
                    }
                    this.f1454b.sendMessage(message);
                    break;
                }
                break;
            case 3:
                message.what = 4;
                SSMGPB.AllowChatReply allowChatReply = (SSMGPB.AllowChatReply) tcpEnvelope.m2806c();
                ChatONLogWriter.m3508c("ch@t[" + allowChatReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", MsgID : " + allowChatReply.m822d() + ", ResultCode : " + allowChatReply.m824f().m1898d() + ", ResultMsg : " + allowChatReply.m824f().m1900f(), getClass().getSimpleName());
                int iM1898d2 = allowChatReply.m824f().m1898d();
                if (iM1898d2 == 1000) {
                    message.obj = new MessageResultEntry(true, 10000, this.f1616g);
                } else {
                    if (iM1898d2 == 3003) {
                        InBoxDatabaseHelper.m2242a(GlobalApplication.m2387e().getContentResolver(), this.f1616g, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                    } else {
                        MessageDatabaseHelper.m2278a(this.f1625p, Long.valueOf(this.f1457e));
                    }
                    message.obj = new MessageResultEntry(false, iM1898d2, this.f1616g);
                }
                this.f1454b.sendMessage(message);
                break;
            case 5:
                message.what = 4;
                SSMGPB.ChatReply chatReply = (SSMGPB.ChatReply) tcpEnvelope.m2806c();
                ChatONLogWriter.m3508c("resultCode : " + chatReply.m1134l().m1898d() + ", Message : " + chatReply.m1134l().m1900f(), getClass().getSimpleName());
                ChatONLogWriter.m3508c("ch@t[" + chatReply.getClass().getSimpleName() + "]UID : " + ChatONPref.m3519a().getString("uid", "") + ", Msg ID : " + chatReply.m1126d() + ", MsgReceivedTime : " + chatReply.m1132j() + ", SessionID : " + chatReply.m1128f() + ", ResultCode : " + chatReply.m1134l().m1898d() + ", ResultMsg : " + chatReply.m1134l().m1900f() + ", ServerInfo(address) : " + (chatReply.m1130h() != null ? chatReply.m1130h().m1925d() : "null") + ", ServerInfo(port) : " + (chatReply.m1130h() != null ? Integer.valueOf(chatReply.m1130h().m1927f()) : "null"), getClass().getSimpleName());
                int iM1898d3 = chatReply.m1134l().m1898d();
                String strM1900f2 = chatReply.m1134l().m1900f();
                if (iM1898d3 == 1000 || iM1898d3 == 1001) {
                    MessageDatabaseHelper.m2282a(this.f1625p, Long.valueOf(chatReply.m1132j()), chatReply.m1128f(), chatReply.m1126d(), Long.valueOf(this.f1457e), this.f1622m.length);
                    InBoxDatabaseHelper.m2252a(this.f1625p, ChatONPref.m3519a().getString("msisdn", ""), this.f1616g, this.f1627r, chatReply.m1132j(), chatReply.m1128f(), chatReply.m1130h().m1925d(), Integer.valueOf(chatReply.m1130h().m1927f()), Long.valueOf(chatReply.m1126d()), this.f1622m.length, this.f1619j);
                    if (iM1898d3 == 1001) {
                        String[] strArrSplit2 = strM1900f2.substring(strM1900f2.indexOf("[") + 1, strM1900f2.indexOf("]")).trim().split(",");
                        StringBuilder sb = new StringBuilder();
                        for (String str2 : strArrSplit2) {
                            String strM2317e2 = ParticipantDatabaseHelper.m2317e(this.f1625p, this.f1616g, str2);
                            ChatONLogWriter.m3508c("1001 error - invalidUserName:" + strM2317e2, getClass().getSimpleName());
                            sb.append(String.format("%s,%s,%s", "LEAVE", str2, ChatUtil.m795a(strM2317e2))).append(";");
                            ParticipantDatabaseHelper.m2316d(this.f1625p, this.f1616g, str2);
                        }
                        MessageDatabaseHelper.m2297b(this.f1625p, this.f1616g, sb.toString());
                        InBoxDatabaseHelper.m2258b(this.f1625p, this.f1616g);
                    }
                    message.obj = new MessageResultEntry(true, iM1898d3);
                } else {
                    message.obj = new MessageResultEntry(false, iM1898d3);
                    if (this.f1619j == ChatONContract.MessageTable.MsgContentType.GEO) {
                        MessageDatabaseHelper.m2278a(this.f1625p, Long.valueOf(this.f1457e));
                    } else {
                        MessageDatabaseHelper.m2283a(this.f1625p, Long.valueOf(this.f1457e), false);
                    }
                }
                this.f1454b.sendMessage(message);
                break;
        }
    }
}
