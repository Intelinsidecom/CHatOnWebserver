package com.sec.chaton.p013a.p014a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.C0263ac;
import com.sec.chaton.p015b.C0268ah;
import com.sec.chaton.p015b.C0277aq;
import com.sec.chaton.p015b.C0283aw;
import com.sec.chaton.p015b.C0295bh;
import com.sec.chaton.p015b.C0299bl;
import com.sec.chaton.p015b.C0304bq;
import com.sec.chaton.p015b.C0331e;
import com.sec.chaton.p015b.C0332f;
import com.sec.chaton.p015b.EnumC0275ao;
import com.sec.chaton.p015b.EnumC0323ci;
import com.sec.chaton.p015b.p016a.C0257e;
import com.sec.chaton.p018c.C0477ab;
import com.sec.chaton.p018c.C0507n;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0664q;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0631k;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1325bu;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;

/* compiled from: MediaChatTask.java */
/* renamed from: com.sec.chaton.a.a.s */
/* loaded from: classes.dex */
public class C0180s extends AbstractC0164c {

    /* renamed from: h */
    private String f433h;

    /* renamed from: i */
    private String f434i;

    /* renamed from: j */
    private EnumC0651d f435j;

    /* renamed from: k */
    private EnumC0665r f436k;

    /* renamed from: l */
    private String f437l;

    /* renamed from: m */
    private String[] f438m;

    /* renamed from: n */
    private boolean f439n;

    /* renamed from: o */
    private String f440o;

    /* renamed from: p */
    private ContentResolver f441p;

    /* renamed from: q */
    private String f442q;

    /* renamed from: r */
    private String f443r;

    /* renamed from: s */
    private String f444s;

    /* renamed from: t */
    private String f445t;

    public C0180s(Handler handler, String str, long j, String str2, EnumC0651d enumC0651d, EnumC0665r enumC0665r, String str3, String[] strArr, String str4, boolean z, String str5) {
        super(handler, 1);
        this.f434i = str2;
        this.f433h = str;
        this.f435j = enumC0651d;
        this.f436k = enumC0665r;
        this.f437l = str3;
        this.f438m = strArr;
        this.f440o = str4;
        this.f439n = z;
        this.f444s = str5;
        this.f441p = GlobalApplication.m3100a().getContentResolver();
        this.f391f = j;
        this.f445t = "";
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected C0510q mo665a() {
        switch (this.f435j) {
            case IMAGE:
                this.f442q = "image";
                this.f443r = GlobalApplication.m3106g().getString(R.string.last_message_me_image);
                break;
            case AUDIO:
                this.f442q = "audio";
                this.f443r = GlobalApplication.m3106g().getString(R.string.last_message_me_voice);
                break;
            case CALENDAR:
                this.f442q = "calendar";
                this.f443r = GlobalApplication.m3106g().getString(R.string.last_message_me_calendar);
                break;
            case CONTACT:
                this.f442q = "contact";
                this.f443r = GlobalApplication.m3106g().getString(R.string.last_message_me_contact);
                break;
            case GEO:
                this.f442q = "geo";
                this.f443r = GlobalApplication.m3106g().getString(R.string.last_message_me_location);
                break;
            case VIDEO:
                this.f442q = "video";
                this.f443r = GlobalApplication.m3106g().getString(R.string.last_message_me_video);
                break;
        }
        if (this.f435j == EnumC0651d.GEO) {
            this.f445t = this.f444s;
        } else {
            String strSubstring = this.f434i;
            if (this.f434i != null && this.f434i.startsWith(".")) {
                strSubstring = this.f434i.substring(1);
            }
            this.f445t = this.f442q + "\n" + strSubstring + "\n" + this.f440o;
            if (this.f435j == EnumC0651d.CONTACT || this.f435j == EnumC0651d.CALENDAR) {
                this.f445t += "\n" + this.f444s;
            }
        }
        if (EnumC0651d.GEO != this.f435j) {
            C0635o.m2926a(this.f441p, null, null, Long.valueOf(this.f391f), this.f445t, this.f436k, C1327bw.m4595a());
        }
        C0507n c0507n = new C0507n();
        if (this.f439n) {
            C1341p.m4662e("Msg ID(File) : " + this.f391f, getClass().getSimpleName());
            C0304bq c0304bqM1485e = C0268ah.newBuilder().m1471a(this.f391f).m1474a(EnumC0275ao.m1170a(1)).m1475a(EnumC0323ci.m1750a(this.f436k.m3012a())).m1476a(C1323bs.m4575a().getString("uid", "")).m1479b(C1336k.m4621a()).m1481c(C1323bs.m4575a().getString("msisdn", "")).m1485e(this.f445t);
            C1341p.m4662e("MsgType : " + this.f435j.m2978a() + ", ChatType : " + this.f436k.m3012a(), getClass().getSimpleName());
            for (String str : this.f438m) {
                c0304bqM1485e.m1483d(str);
            }
            C1341p.m4662e("Content : " + c0304bqM1485e.m1491k(), getClass().getSimpleName());
            C1341p.m4660c("ch@t[" + c0304bqM1485e.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", InBoxNo : " + this.f433h + ", MsgType : " + c0304bqM1485e.m1487g() + ", ChatType : " + c0304bqM1485e.m1488h() + ", MsgID : " + c0304bqM1485e.m1486f() + ", ChatMsg : " + c0304bqM1485e.m1491k() + ", Sender : " + c0304bqM1485e.m1489i() + ", Receivers : " + C1341p.m4646a(c0304bqM1485e.m1490j()), getClass().getSimpleName());
            c0507n.m2556a(0).m2558a(c0304bqM1485e.build()).m2557a(5000L);
        } else if (!C0477ab.m2446a(this.f388c)) {
            C0634n.m2905a(this.f441p, this.f433h, this.f388c);
            long jM4591a = C1325bu.m4591a();
            C0295bh c0295bhNewBuilder = C0331e.newBuilder();
            c0295bhNewBuilder.m1322a(jM4591a).m1324a(EnumC0323ci.m1750a(this.f436k.m3012a())).m1331d(C1323bs.m4575a().getString("uid", "")).m1333e(C1336k.m4621a()).m1329c(C1323bs.m4575a().getString("msisdn", ""));
            if (this.f438m == null || this.f438m.length == 0) {
                c0295bhNewBuilder.m1328b(this.f433h);
            } else {
                c0295bhNewBuilder.m1328b(String.valueOf(this.f438m[0]));
            }
            if (!TextUtils.isEmpty(this.f437l)) {
                c0295bhNewBuilder.m1326a(this.f437l);
            }
            C1341p.m4660c("ch@t[AllowChatRequest]UID : " + C1323bs.m4575a().getString("uid", "") + ", ChatType : " + c0295bhNewBuilder.m1336g() + ", MsgID : " + c0295bhNewBuilder.m1335f() + ", Receiver : " + c0295bhNewBuilder.m1339j() + ", Sender : " + c0295bhNewBuilder.m1338i() + ", SessionID : " + c0295bhNewBuilder.m1337h(), getClass().getSimpleName());
            c0507n.m2556a(2).m2558a(c0295bhNewBuilder.build()).m2557a(30000L);
        } else {
            C0299bl c0299blM1397f = C0332f.newBuilder().m1382a(this.f391f).m1384a(EnumC0275ao.m1170a(1)).m1385a(EnumC0323ci.m1750a(this.f436k.m3012a())).m1387a(this.f437l).m1392d(C1323bs.m4575a().getString("uid", "")).m1394e(C1336k.m4621a()).m1389b(C1323bs.m4575a().getString("msisdn", "")).m1397f(this.f445t);
            c0299blM1397f.m1390c(this.f438m[0]);
            C1341p.m4660c("ch@t[" + c0299blM1397f.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", InBoxNo : " + this.f433h + ", ChatMsg : " + c0299blM1397f.m1404l() + ", ChatType : " + c0299blM1397f.m1400h() + ", MsgID : " + c0299blM1397f.m1396f() + ", MsgType : " + c0299blM1397f.m1398g() + ", ReceiverList : " + C1341p.m4646a(c0299blM1397f.m1403k()) + ", Sender : " + c0299blM1397f.m1402j() + ", SessionID : " + c0299blM1397f.m1401i(), getClass().getSimpleName());
            c0507n.m2556a(4).m2558a(c0299blM1397f.build()).m2557a(5000L);
        }
        return c0507n.m2561b();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected void mo666a(int i, Object obj, Object obj2) {
        Message message = new Message();
        if (obj2 != null) {
            C0510q c0510q = (C0510q) obj2;
            switch (c0510q.m2573b()) {
                case 1:
                    message.what = 1029;
                    C0277aq c0277aq = (C0277aq) c0510q.m2574c();
                    C1341p.m4660c("resultCode : " + c0277aq.m1209l().m1626d() + " resultMessage : " + c0277aq.m1209l().m1628f(), getClass().getSimpleName());
                    C1341p.m4660c("ch@t[" + c0277aq.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", ResultCode : " + c0277aq.m1209l().m1626d() + ", ResultMessage : " + c0277aq.m1209l().m1628f() + ", InBoxNo : " + this.f433h + ", MsgReceivedTime : " + c0277aq.m1205h() + ", MsgID : " + c0277aq.m1201d() + ", ServerInfo(address) : " + (c0277aq.m1207j() != null ? c0277aq.m1207j().m1559d() : "null(broadcast)") + ", ServerInfo(port) : " + (c0277aq.m1207j() != null ? Integer.valueOf(c0277aq.m1207j().m1561f()) : "null(broadcast)") + ", SessionID : " + c0277aq.m1203f(), getClass().getSimpleName());
                    int iM1626d = c0277aq.m1209l().m1626d();
                    String strM1628f = c0277aq.m1209l().m1628f();
                    if (iM1626d == 1000 || iM1626d == 1001 || iM1626d == 3002) {
                        int length = this.f438m.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (!C0631k.m2864a(this.f441p, this.f438m[i2], this.f433h)) {
                                C0631k.m2868c(this.f441p, this.f433h, this.f438m[i2]);
                            }
                        }
                        C0634n.m2898a(this.f441p, this.f433h, c0277aq, this.f445t, this.f436k, this.f438m, this.f435j);
                        C0635o.m2923a(this.f441p, Long.valueOf(c0277aq.m1205h()), c0277aq.m1203f(), c0277aq.m1201d(), Long.valueOf(this.f391f), this.f438m.length);
                        if (iM1626d == 1001) {
                            String[] strArrSplit = strM1628f.substring(strM1628f.indexOf("[") + 1, strM1628f.indexOf("]")).trim().split(",");
                            ArrayList arrayList = new ArrayList();
                            for (String str : strArrSplit) {
                                String strM2872e = C0631k.m2872e(this.f441p, this.f433h, str);
                                C1341p.m4660c("1001 error - invalidUserName:" + strM2872e, getClass().getSimpleName());
                                arrayList.add(strM2872e);
                                C0631k.m2871d(this.f441p, this.f433h, str);
                            }
                            if (this.f436k == EnumC0665r.BROADCAST) {
                                C0634n.m2909b(this.f441p, this.f433h);
                            } else {
                                C0634n.m2889a(this.f441p, this.f433h);
                            }
                            message.obj = new C0177p(this, true, c0277aq.m1203f(), iM1626d, arrayList, this.f391f);
                        } else {
                            message.obj = new C0177p(this, true, c0277aq.m1203f(), iM1626d, this.f391f);
                        }
                        this.f387b.sendMessage(message);
                        break;
                    } else {
                        if (iM1626d == 3001) {
                            if (this.f435j == EnumC0651d.GEO) {
                                C0635o.m2920a(this.f441p, Long.valueOf(this.f391f), Long.valueOf(C1325bu.m4591a()));
                            } else {
                                C0635o.m2921a(this.f441p, Long.valueOf(this.f391f), Long.valueOf(C1325bu.m4591a()), false);
                            }
                        } else if (this.f435j == EnumC0651d.GEO) {
                            C0635o.m2919a(this.f441p, Long.valueOf(this.f391f));
                        } else {
                            C0635o.m2924a(this.f441p, Long.valueOf(this.f391f), false);
                        }
                        message.obj = new C0177p(this, false, null, iM1626d, this.f391f);
                        this.f387b.sendMessage(message);
                        break;
                    }
                    break;
                case 3:
                    message.what = 1025;
                    C0263ac c0263ac = (C0263ac) c0510q.m2574c();
                    C1341p.m4660c("ch@t[" + c0263ac.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", MsgID : " + c0263ac.m992d() + ", ResultCode : " + c0263ac.m994f().m1626d() + ", ResultMsg : " + c0263ac.m994f().m1628f(), getClass().getSimpleName());
                    int iM1626d2 = c0263ac.m994f().m1626d();
                    if (iM1626d2 == 1000 || iM1626d2 == 3003) {
                        message.obj = new C0257e(true, 10000, this.f433h, this.f391f);
                    } else {
                        if (iM1626d2 == 2006 || iM1626d2 == 3008) {
                            C0634n.m2893a(GlobalApplication.m3100a().getContentResolver(), this.f433h, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                        } else if (this.f435j == EnumC0651d.GEO) {
                            C0635o.m2919a(this.f441p, Long.valueOf(this.f391f));
                        } else {
                            C0635o.m2924a(this.f441p, Long.valueOf(this.f391f), false);
                        }
                        message.obj = new C0257e(false, iM1626d2, this.f433h, this.f391f);
                    }
                    this.f387b.sendMessage(message);
                    break;
                case 5:
                    message.what = 1025;
                    C0283aw c0283aw = (C0283aw) c0510q.m2574c();
                    C1341p.m4660c("resultCode : " + c0283aw.m1259l().m1626d() + ", Message : " + c0283aw.m1259l().m1628f(), getClass().getSimpleName());
                    C1341p.m4660c("ch@t[" + c0283aw.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", Msg ID : " + c0283aw.m1251d() + ", MsgReceivedTime : " + c0283aw.m1257j() + ", SessionID : " + c0283aw.m1253f() + ", ResultCode : " + c0283aw.m1259l().m1626d() + ", ResultMsg : " + c0283aw.m1259l().m1628f() + ", ServerInfo(address) : " + (c0283aw.m1255h() != null ? c0283aw.m1255h().m1559d() : "null") + ", ServerInfo(port) : " + (c0283aw.m1255h() != null ? Integer.valueOf(c0283aw.m1255h().m1561f()) : "null"), getClass().getSimpleName());
                    int iM1626d3 = c0283aw.m1259l().m1626d();
                    String strM1628f2 = c0283aw.m1259l().m1628f();
                    if (iM1626d3 == 1000 || iM1626d3 == 1001) {
                        C0635o.m2923a(this.f441p, Long.valueOf(c0283aw.m1257j()), c0283aw.m1253f(), c0283aw.m1251d(), Long.valueOf(this.f391f), this.f438m.length);
                        C0634n.m2895a(this.f441p, C1323bs.m4575a().getString("msisdn", ""), this.f433h, this.f443r, c0283aw.m1257j(), c0283aw.m1253f(), c0283aw.m1255h().m1559d(), Integer.valueOf(c0283aw.m1255h().m1561f()), Long.valueOf(c0283aw.m1251d()), this.f438m.length, this.f435j);
                        if (iM1626d3 == 1001) {
                            m716a(strM1628f2.substring(strM1628f2.indexOf("[") + 1, strM1628f2.indexOf("]")).trim().split(","), c0283aw.m1257j());
                        }
                        message.obj = new C0257e(true, iM1626d3, this.f391f);
                    } else {
                        message.obj = new C0257e(false, iM1626d3, this.f391f);
                        if (iM1626d3 == 6002) {
                            if (this.f436k == EnumC0665r.ONETOONE) {
                                C0634n.m2894a(this.f441p, this.f438m[0], C0631k.m2872e(this.f441p, this.f433h, this.f438m[0]), c0283aw.m1257j());
                            } else {
                                m716a(C0631k.m2867b(this.f441p, this.f433h), c0283aw.m1257j());
                            }
                        }
                        if (this.f435j == EnumC0651d.GEO) {
                            C0635o.m2919a(this.f441p, Long.valueOf(this.f391f));
                        } else {
                            C0635o.m2924a(this.f441p, Long.valueOf(this.f391f), false);
                        }
                    }
                    this.f387b.sendMessage(message);
                    break;
            }
            return;
        }
        if (!m703b() || i == 11 || i == 22 || i == 3) {
            if (this.f435j == EnumC0651d.GEO) {
                C0635o.m2919a(this.f441p, Long.valueOf(this.f391f));
            } else {
                C0635o.m2924a(this.f441p, Long.valueOf(this.f391f), false);
            }
            if (i == 24 || i == 23 || i == 21) {
                C0634n.m2914d(this.f441p, this.f433h);
            }
        }
        message.obj = new C0257e(false, i, this.f391f);
        this.f387b.sendMessage(message);
    }

    /* renamed from: a */
    private void m716a(String[] strArr, long j) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (C0631k.m2864a(this.f441p, str, this.f433h)) {
                String strM2872e = C0631k.m2872e(this.f441p, this.f433h, str);
                C1341p.m4660c("1001 error - invalidUserName:" + strM2872e, getClass().getSimpleName());
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0664q.LEAVE.m3010a()), str, C0520a.m2713a(strM2872e))).append(";");
                C0631k.m2871d(this.f441p, this.f433h, str);
            }
        }
        if (sb.length() > 0) {
            C0635o.m2928a(this.f441p, this.f433h, sb.toString(), j, C1323bs.m4575a().getString("msisdn", ""));
            C0634n.m2916f(this.f441p, this.f433h);
            C0634n.m2889a(this.f441p, this.f433h);
        }
    }
}
