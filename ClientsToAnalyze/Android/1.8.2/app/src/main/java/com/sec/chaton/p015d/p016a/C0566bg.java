package com.sec.chaton.p015d.p016a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.p032b.C0950e;
import com.sec.chaton.p007a.C0110ac;
import com.sec.chaton.p007a.C0113af;
import com.sec.chaton.p007a.C0114ag;
import com.sec.chaton.p007a.C0147bm;
import com.sec.chaton.p007a.C0150bp;
import com.sec.chaton.p007a.C0151bq;
import com.sec.chaton.p007a.C0161c;
import com.sec.chaton.p007a.C0179f;
import com.sec.chaton.p007a.C0180g;
import com.sec.chaton.p007a.EnumC0116ai;
import com.sec.chaton.p007a.EnumC0159by;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.EnumC0705t;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0771ac;
import com.sec.chaton.p022h.C0810t;
import com.sec.chaton.p028io.entry.specialbuddy.SpecialBuddyFilePlayerEntry;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1735ar;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;

/* compiled from: MediaChatTask.java */
/* renamed from: com.sec.chaton.d.a.bg */
/* loaded from: classes.dex */
public class C0566bg extends AbstractC0559b {

    /* renamed from: h */
    protected String f2263h;

    /* renamed from: i */
    protected String f2264i;

    /* renamed from: j */
    protected String f2265j;

    /* renamed from: k */
    private String f2266k;

    /* renamed from: l */
    private String f2267l;

    /* renamed from: m */
    private EnumC0699n f2268m;

    /* renamed from: n */
    private EnumC0695j f2269n;

    /* renamed from: o */
    private String f2270o;

    /* renamed from: p */
    private String[] f2271p;

    /* renamed from: q */
    private boolean f2272q;

    /* renamed from: r */
    private String f2273r;

    /* renamed from: s */
    private ContentResolver f2274s;

    /* renamed from: t */
    private String f2275t;

    /* renamed from: u */
    private String f2276u;

    /* renamed from: v */
    private String f2277v;

    public C0566bg(Handler handler, String str, long j, String str2, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String str3, String[] strArr, String str4, boolean z, String str5, String str6) {
        super(handler, 1);
        this.f2267l = str2;
        this.f2266k = str;
        this.f2268m = enumC0699n;
        this.f2269n = enumC0695j;
        this.f2270o = str3;
        this.f2271p = strArr;
        this.f2273r = str4;
        this.f2272q = z;
        this.f2265j = str5;
        this.f2274s = GlobalApplication.m3260b().getContentResolver();
        this.f2240f = j;
        this.f2275t = "";
        this.f2277v = null;
        this.f2276u = str6;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: c */
    protected C0770ab mo2748c() {
        switch (this.f2268m) {
            case IMAGE:
                this.f2263h = "image";
                this.f2264i = GlobalApplication.m3262c().getString(R.string.last_message_me_image);
                break;
            case AUDIO:
                this.f2263h = SpecialBuddyFilePlayerEntry.FILEPLAYER_AUDIO;
                this.f2264i = GlobalApplication.m3262c().getString(R.string.last_message_me_voice);
                break;
            case CALENDAR:
                this.f2263h = "calendar";
                this.f2264i = GlobalApplication.m3262c().getString(R.string.last_message_me_calendar);
                break;
            case CONTACT:
                this.f2263h = "contact";
                this.f2264i = GlobalApplication.m3262c().getString(R.string.last_message_me_contact);
                break;
            case GEO:
                this.f2263h = "geo";
                this.f2264i = GlobalApplication.m3262c().getString(R.string.last_message_me_location);
                break;
            case VIDEO:
                this.f2263h = "video";
                this.f2264i = GlobalApplication.m3262c().getString(R.string.last_message_me_video);
                break;
            case DOCUMENT:
                this.f2263h = "doc";
                this.f2264i = GlobalApplication.m3262c().getString(R.string.last_message_me_document);
                break;
            case ANICON:
                Uri uriBuild = C0950e.f3514a.buildUpon().appendPath(this.f2277v).build();
                this.f2263h = "image";
                this.f2264i = GlobalApplication.m3262c().getString(R.string.last_message_me_anicon);
                long jCurrentTimeMillis = System.currentTimeMillis();
                ContentValues contentValues = new ContentValues();
                contentValues.put("sent_time", Long.valueOf(jCurrentTimeMillis));
                GlobalApplication.m3260b().getContentResolver().update(uriBuild, contentValues, null, null);
                break;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f2268m == EnumC0699n.GEO || this.f2268m == EnumC0699n.ANICON) {
            this.f2275t = this.f2265j;
        } else {
            String strSubstring = this.f2267l;
            if (this.f2267l != null && this.f2267l.startsWith(".")) {
                strSubstring = this.f2267l.substring(1);
            }
            if (TextUtils.isEmpty(this.f2276u)) {
                sb.append(this.f2263h + "\n");
                sb.append(strSubstring + "\n");
                sb.append(this.f2273r + "\n");
            } else {
                sb.append("mixed\n");
                sb.append(this.f2263h + "\n");
                sb.append(this.f2273r + "\n");
            }
            if (this.f2268m == EnumC0699n.CONTACT || this.f2268m == EnumC0699n.CALENDAR || this.f2268m == EnumC0699n.DOCUMENT) {
                sb.append(this.f2265j);
            }
            if (!TextUtils.isEmpty(this.f2276u)) {
                sb.append("\n" + this.f2276u);
            }
            this.f2275t = sb.toString();
        }
        if (EnumC0699n.GEO != this.f2268m) {
            C0665i.m3057a(this.f2274s, (String) null, (String) null, Long.valueOf(this.f2240f), this.f2275t, this.f2269n, C1767bw.m6002a());
        }
        C0771ac c0771ac = new C0771ac();
        if (this.f2272q) {
            C1786r.m6066e("Msg ID(File) : " + this.f2240f, getClass().getSimpleName());
            C0151bq c0151bqM1251e = C0150bp.newBuilder().m1237a(this.f2240f).m1241a(EnumC0159by.m1347a(1)).m1239a(EnumC0116ai.m813a(this.f2269n.m3146a())).m1242a(C1789u.m6075a().getString("uid", "")).m1245b(C1721ad.m5873a()).m1247c(C1789u.m6075a().getString("msisdn", "")).m1251e(this.f2275t);
            C1786r.m6066e("MsgType : " + this.f2268m.m3162a() + ", ChatType : " + this.f2269n.m3146a(), getClass().getSimpleName());
            for (String str : this.f2271p) {
                c0151bqM1251e.m1249d(str);
            }
            C1786r.m6066e("Content : " + c0151bqM1251e.m1257k(), getClass().getSimpleName());
            C1786r.m6063c("ch@t[" + c0151bqM1251e.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", InBoxNo : " + this.f2266k + ", MsgType : " + c0151bqM1251e.m1253g() + ", ChatType : " + c0151bqM1251e.m1254h() + ", MsgID : " + c0151bqM1251e.m1252f() + ", ChatMsg : " + c0151bqM1251e.m1257k() + ", Sender : " + c0151bqM1251e.m1255i() + ", Receivers : " + C1786r.m6049a(c0151bqM1251e.m1256j()), getClass().getSimpleName());
            c0771ac.m3294a(0).m3296a(c0151bqM1251e.build()).m3295a(5000L);
        } else if (!C0810t.m3426a(this.f2237c)) {
            C0660d.m3018a(this.f2274s, this.f2266k, this.f2237c);
            long jM5918a = C1735ar.m5918a();
            C0180g c0180gNewBuilder = C0179f.newBuilder();
            c0180gNewBuilder.m1567a(jM5918a).m1569a(EnumC0116ai.m813a(this.f2269n.m3146a())).m1577d(C1789u.m6075a().getString("uid", "")).m1579e(C1721ad.m5873a()).m1575c(C1789u.m6075a().getString("msisdn", ""));
            if (this.f2271p == null || this.f2271p.length == 0) {
                c0180gNewBuilder.m1573b(this.f2266k);
            } else {
                c0180gNewBuilder.m1573b(String.valueOf(this.f2271p[0]));
            }
            if (!TextUtils.isEmpty(this.f2270o)) {
                c0180gNewBuilder.m1571a(this.f2270o);
            }
            C1786r.m6063c("ch@t[AllowChatRequest]UID : " + C1789u.m6075a().getString("uid", "") + ", ChatType : " + c0180gNewBuilder.m1581g() + ", MsgID : " + c0180gNewBuilder.m1580f() + ", Receiver : " + c0180gNewBuilder.m1584j() + ", Sender : " + c0180gNewBuilder.m1583i() + ", SessionID : " + c0180gNewBuilder.m1582h(), getClass().getSimpleName());
            c0771ac.m3294a(2).m3296a(c0180gNewBuilder.build()).m3295a(30000L);
        } else {
            C0114ag c0114agM805f = C0113af.newBuilder().m790a(this.f2240f).m794a(EnumC0159by.m1347a(1)).m793a(EnumC0116ai.m813a(this.f2269n.m3146a())).m795a(this.f2270o).m801d(C1789u.m6075a().getString("uid", "")).m803e(C1721ad.m5873a()).m797b(C1789u.m6075a().getString("msisdn", "")).m805f(this.f2275t);
            for (String str2 : this.f2271p) {
                c0114agM805f.m799c(str2);
            }
            C1786r.m6063c("ch@t[" + c0114agM805f.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", InBoxNo : " + this.f2266k + ", ChatMsg : " + c0114agM805f.m812l() + ", ChatType : " + c0114agM805f.m808h() + ", MsgID : " + c0114agM805f.m804f() + ", MsgType : " + c0114agM805f.m807g() + ", ReceiverList : " + C1786r.m6049a(c0114agM805f.m811k()) + ", Sender : " + c0114agM805f.m810j() + ", SessionID : " + c0114agM805f.m809i(), getClass().getSimpleName());
            c0771ac.m3294a(4).m3296a(c0114agM805f.build()).m3295a(5000L);
        }
        return c0771ac.m3299b();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: a */
    protected void mo2747a(int i, Object obj, Object obj2) {
        Message message = new Message();
        if (obj2 != null) {
            C0770ab c0770ab = (C0770ab) obj2;
            switch (c0770ab.m3289b()) {
                case 1:
                    message.what = 0;
                    C0147bm c0147bm = (C0147bm) c0770ab.m3290c();
                    C1786r.m6063c("resultCode : " + c0147bm.m1165l().m1467d() + " resultMessage : " + c0147bm.m1165l().m1469f(), getClass().getSimpleName());
                    C1786r.m6063c("ch@t[" + c0147bm.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", ResultCode : " + c0147bm.m1165l().m1467d() + ", ResultMessage : " + c0147bm.m1165l().m1469f() + ", InBoxNo : " + this.f2266k + ", MsgReceivedTime : " + c0147bm.m1161h() + ", MsgID : " + c0147bm.m1157d() + ", ServerInfo(address) : " + (c0147bm.m1163j() != null ? c0147bm.m1163j().m1493d() : "null(broadcast)") + ", ServerInfo(port) : " + (c0147bm.m1163j() != null ? Integer.valueOf(c0147bm.m1163j().m1495f()) : "null(broadcast)") + ", SessionID : " + c0147bm.m1159f(), getClass().getSimpleName());
                    int iM1467d = c0147bm.m1165l().m1467d();
                    String strM1469f = c0147bm.m1165l().m1469f();
                    if (iM1467d == 1000 || iM1467d == 1001) {
                        for (int length = this.f2271p.length - 1; length >= 0; length--) {
                            if (!C0670n.m3083a(this.f2274s, this.f2271p[length], this.f2266k)) {
                                C0670n.m3087c(this.f2274s, this.f2266k, this.f2271p[length]);
                            }
                        }
                        C0660d.m3011a(this.f2274s, this.f2266k, c0147bm, this.f2275t, this.f2269n, this.f2271p, this.f2268m);
                        C0665i.m3053a(this.f2274s, Long.valueOf(c0147bm.m1161h()), c0147bm.m1159f(), c0147bm.m1157d(), Long.valueOf(this.f2240f), this.f2271p.length);
                        if (iM1467d == 1001) {
                            String[] strArrSplit = strM1469f.substring(strM1469f.indexOf("[") + 1, strM1469f.indexOf("]")).trim().split(",");
                            ArrayList arrayList = new ArrayList();
                            for (String str : strArrSplit) {
                                String strM3091e = C0670n.m3091e(this.f2274s, this.f2266k, str);
                                C1786r.m6063c("1001 error - invalidUserName:" + strM3091e, getClass().getSimpleName());
                                arrayList.add(strM3091e);
                                C0670n.m3090d(this.f2274s, this.f2266k, str);
                            }
                            if (this.f2269n == EnumC0695j.BROADCAST) {
                                C0660d.m3028c(this.f2274s, this.f2266k);
                            } else {
                                C0660d.m3027b(this.f2274s, this.f2266k);
                            }
                            message.obj = new C0568bi(this, true, c0147bm.m1159f(), iM1467d, arrayList);
                        } else {
                            message.obj = new C0568bi(this, true, c0147bm.m1159f(), iM1467d);
                        }
                        this.f2236b.sendMessage(message);
                        break;
                    } else {
                        if (iM1467d == 3001 || iM1467d == 3002) {
                            if (this.f2268m == EnumC0699n.GEO || this.f2268m == EnumC0699n.ANICON) {
                                C0665i.m3050a(this.f2274s, Long.valueOf(this.f2240f), Long.valueOf(C1735ar.m5918a()));
                            } else {
                                C0665i.m3051a(this.f2274s, Long.valueOf(this.f2240f), Long.valueOf(C1735ar.m5918a()), false);
                            }
                        } else if (this.f2268m == EnumC0699n.GEO || this.f2268m == EnumC0699n.ANICON) {
                            C0665i.m3049a(this.f2274s, Long.valueOf(this.f2240f));
                        } else {
                            C0665i.m3054a(this.f2274s, Long.valueOf(this.f2240f), false);
                        }
                        message.obj = new C0568bi(this, false, null, iM1467d);
                        this.f2236b.sendMessage(message);
                        break;
                    }
                    break;
                case 3:
                    message.what = 4;
                    C0161c c0161c = (C0161c) c0770ab.m3290c();
                    C1786r.m6063c("ch@t[" + c0161c.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", MsgID : " + c0161c.m1358d() + ", ResultCode : " + c0161c.m1360f().m1467d() + ", ResultMsg : " + c0161c.m1360f().m1469f(), getClass().getSimpleName());
                    int iM1467d2 = c0161c.m1360f().m1467d();
                    if (iM1467d2 == 1000 || iM1467d2 == 3003) {
                        message.obj = new C0103d(true, 10000, this.f2266k);
                    } else {
                        if (iM1467d2 == 2006 || iM1467d2 == 3008) {
                            C0660d.m3006a(GlobalApplication.m3260b().getContentResolver(), this.f2266k, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                        } else {
                            C0665i.m3049a(this.f2274s, Long.valueOf(this.f2240f));
                        }
                        message.obj = new C0103d(false, iM1467d2, this.f2266k);
                    }
                    this.f2236b.sendMessage(message);
                    break;
                case 5:
                    message.what = 4;
                    C0110ac c0110ac = (C0110ac) c0770ab.m3290c();
                    C1786r.m6063c("resultCode : " + c0110ac.m713l().m1467d() + ", Message : " + c0110ac.m713l().m1469f(), getClass().getSimpleName());
                    C1786r.m6063c("ch@t[" + c0110ac.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", Msg ID : " + c0110ac.m705d() + ", MsgReceivedTime : " + c0110ac.m711j() + ", SessionID : " + c0110ac.m707f() + ", ResultCode : " + c0110ac.m713l().m1467d() + ", ResultMsg : " + c0110ac.m713l().m1469f() + ", ServerInfo(address) : " + (c0110ac.m709h() != null ? c0110ac.m709h().m1493d() : "null") + ", ServerInfo(port) : " + (c0110ac.m709h() != null ? Integer.valueOf(c0110ac.m709h().m1495f()) : "null"), getClass().getSimpleName());
                    int iM1467d3 = c0110ac.m713l().m1467d();
                    String strM1469f2 = c0110ac.m713l().m1469f();
                    if (iM1467d3 == 1000 || iM1467d3 == 1001) {
                        C0665i.m3053a(this.f2274s, Long.valueOf(c0110ac.m711j()), c0110ac.m707f(), c0110ac.m705d(), Long.valueOf(this.f2240f), this.f2271p.length);
                        C0660d.m3020a(this.f2274s, C1789u.m6075a().getString("msisdn", ""), this.f2266k, this.f2264i, c0110ac.m711j(), c0110ac.m707f(), c0110ac.m709h().m1493d(), Integer.valueOf(c0110ac.m709h().m1495f()), Long.valueOf(c0110ac.m705d()), this.f2271p.length, this.f2268m);
                        if (iM1467d3 == 1001) {
                            String[] strArrSplit2 = strM1469f2.substring(strM1469f2.indexOf("[") + 1, strM1469f2.indexOf("]")).trim().split(",");
                            StringBuilder sb = new StringBuilder();
                            for (String str2 : strArrSplit2) {
                                if (C0670n.m3083a(this.f2274s, str2, this.f2266k)) {
                                    String strM3091e2 = C0670n.m3091e(this.f2274s, this.f2266k, str2);
                                    C1786r.m6063c("1001 error - invalidUserName:" + strM3091e2, getClass().getSimpleName());
                                    sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0705t.LEAVE.m3171a()), str2, C0493bg.m2684a(strM3091e2))).append(";");
                                    C0670n.m3090d(this.f2274s, this.f2266k, str2);
                                }
                            }
                            C0665i.m3040a(this.f2274s, this.f2266k, sb.toString(), c0110ac.m711j(), C1789u.m6075a().getString("msisdn", ""));
                            C0660d.m3027b(this.f2274s, this.f2266k);
                        }
                        message.obj = new C0103d(true, iM1467d3);
                    } else {
                        message.obj = new C0103d(false, iM1467d3);
                        if (this.f2268m == EnumC0699n.GEO || this.f2268m == EnumC0699n.ANICON) {
                            C0665i.m3049a(this.f2274s, Long.valueOf(this.f2240f));
                        } else {
                            C0665i.m3054a(this.f2274s, Long.valueOf(this.f2240f), false);
                        }
                    }
                    this.f2236b.sendMessage(message);
                    break;
            }
            return;
        }
        if (!m2759b() || i == 11 || i == 22 || i == 3) {
            if (this.f2268m == EnumC0699n.GEO || this.f2268m == EnumC0699n.ANICON) {
                C0665i.m3049a(this.f2274s, Long.valueOf(this.f2240f));
            } else {
                C0665i.m3054a(this.f2274s, Long.valueOf(this.f2240f), false);
            }
            if (i == 24 || i == 23 || i == 21) {
                C0660d.m3031e(this.f2274s, this.f2266k);
            }
        }
        message.obj = new C0103d(false, i);
        this.f2236b.sendMessage(message);
    }
}
