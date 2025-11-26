package com.sec.chaton.p015d.p016a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.C0110ac;
import com.sec.chaton.p007a.C0113af;
import com.sec.chaton.p007a.C0114ag;
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
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1735ar;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: ChatTask.java */
/* renamed from: com.sec.chaton.d.a.l */
/* loaded from: classes.dex */
public class C0596l extends AbstractC0559b {

    /* renamed from: h */
    private EnumC0699n f2354h;

    /* renamed from: i */
    private EnumC0695j f2355i;

    /* renamed from: j */
    private String f2356j;

    /* renamed from: k */
    private String[] f2357k;

    /* renamed from: l */
    private String f2358l;

    /* renamed from: m */
    private String f2359m;

    /* renamed from: n */
    private ContentResolver f2360n;

    /* renamed from: o */
    private String f2361o;

    public C0596l(Handler handler, long j, String str, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String str2, String str3) {
        super(handler, 1);
        this.f2361o = "";
        this.f2240f = j;
        this.f2359m = str;
        this.f2354h = enumC0699n;
        this.f2356j = str2;
        this.f2355i = enumC0695j;
        this.f2358l = str3;
        this.f2360n = GlobalApplication.m3260b().getContentResolver();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: c */
    protected C0770ab mo2748c() {
        this.f2357k = C0670n.m3086b(this.f2360n, this.f2359m);
        if (!C0810t.m3426a(this.f2237c)) {
            C0660d.m3018a(this.f2360n, this.f2359m, this.f2237c);
            long jM5918a = C1735ar.m5918a();
            C0180g c0180gNewBuilder = C0179f.newBuilder();
            c0180gNewBuilder.m1567a(jM5918a).m1569a(EnumC0116ai.m813a(this.f2355i.m3146a())).m1577d(C1789u.m6075a().getString("uid", "")).m1579e(C1721ad.m5873a()).m1575c(C1789u.m6075a().getString("msisdn", ""));
            if (this.f2357k == null || this.f2357k.length == 0) {
                c0180gNewBuilder.m1573b(this.f2359m);
            } else {
                c0180gNewBuilder.m1573b(String.valueOf(this.f2357k[0]));
            }
            if (!TextUtils.isEmpty(this.f2356j)) {
                c0180gNewBuilder.m1571a(this.f2356j);
            }
            C1786r.m6063c("ch@t[AllowChatRequest]UID : " + C1789u.m6075a().getString("uid", "") + ", ChatType : " + c0180gNewBuilder.m1581g() + ", MsgID : " + c0180gNewBuilder.m1580f() + ", Receiver : " + c0180gNewBuilder.m1584j() + ", Sender : " + c0180gNewBuilder.m1583i() + ", SessionID : " + c0180gNewBuilder.m1582h(), getClass().getSimpleName());
            C0771ac c0771ac = new C0771ac();
            c0771ac.m3294a(2).m3296a(c0180gNewBuilder.build()).m3295a(30000L);
            return c0771ac.m3299b();
        }
        C0114ag c0114agM805f = C0113af.newBuilder().m790a(this.f2240f).m793a(EnumC0116ai.m813a(this.f2355i.m3146a())).m795a(this.f2356j).m801d(C1789u.m6075a().getString("uid", "")).m803e(C1721ad.m5873a()).m797b(C1789u.m6075a().getString("msisdn", "")).m805f(this.f2358l);
        if (this.f2354h.m3162a() == 3) {
            c0114agM805f.m794a(EnumC0159by.m1347a(1));
        } else {
            c0114agM805f.m794a(EnumC0159by.m1347a(this.f2354h.m3162a()));
        }
        for (String str : this.f2357k) {
            c0114agM805f.m799c(str);
            this.f2361o += " " + str;
        }
        C1786r.m6063c("ch@t[" + c0114agM805f.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", InBoxNo : " + this.f2359m + ", ChatMsg : " + c0114agM805f.m812l() + ", ChatType : " + c0114agM805f.m808h() + ", MsgID : " + c0114agM805f.m804f() + ", MsgType : " + c0114agM805f.m807g() + ", ReceiverList : " + C1786r.m6049a(c0114agM805f.m811k()) + ", Sender : " + c0114agM805f.m810j() + ", SessionID : " + c0114agM805f.m809i(), getClass().getSimpleName());
        return new C0771ac().m3294a(4).m3296a(c0114agM805f.build()).m3295a(5000L).m3299b();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: a */
    protected void mo2747a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 4;
        if (obj2 != null) {
            C0770ab c0770ab = (C0770ab) obj2;
            switch (c0770ab.m3289b()) {
                case 3:
                    C0161c c0161c = (C0161c) c0770ab.m3290c();
                    C1786r.m6063c("ch@t[" + c0161c.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", MsgID : " + c0161c.m1358d() + ", ResultCode : " + c0161c.m1360f().m1467d() + ", ResultMsg : " + c0161c.m1360f().m1469f(), getClass().getSimpleName());
                    int iM1467d = c0161c.m1360f().m1467d();
                    if (iM1467d == 1000 || iM1467d == 3003) {
                        message.obj = new C0103d(true, 10000, this.f2359m);
                        break;
                    } else {
                        if (iM1467d == 2006 || iM1467d == 3008) {
                            C0660d.m3006a(GlobalApplication.m3260b().getContentResolver(), this.f2359m, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                        } else {
                            C0665i.m3049a(this.f2360n, Long.valueOf(this.f2240f));
                        }
                        message.obj = new C0103d(false, iM1467d, this.f2359m);
                        break;
                    }
                    break;
                case 5:
                    C0110ac c0110ac = (C0110ac) c0770ab.m3290c();
                    C1786r.m6063c("ch@t[" + c0110ac.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", Msg ID : " + c0110ac.m705d() + ", MsgReceivedTime : " + c0110ac.m711j() + ", SessionID : " + c0110ac.m707f() + ", ResultCode : " + c0110ac.m713l().m1467d() + ", ResultMsg : " + c0110ac.m713l().m1469f() + ", ServerInfo(address) : " + (c0110ac.m709h() != null ? c0110ac.m709h().m1493d() : "null") + ", ServerInfo(port) : " + (c0110ac.m709h() != null ? Integer.valueOf(c0110ac.m709h().m1495f()) : "null"), getClass().getSimpleName());
                    int iM1467d2 = c0110ac.m713l().m1467d();
                    String strM1469f = c0110ac.m713l().m1469f();
                    if (iM1467d2 == 1000 || iM1467d2 == 1001) {
                        C0665i.m3053a(this.f2360n, Long.valueOf(c0110ac.m711j()), c0110ac.m707f(), c0110ac.m705d(), Long.valueOf(this.f2240f), this.f2357k.length);
                        C0660d.m3020a(this.f2360n, C1789u.m6075a().getString("msisdn", ""), this.f2359m, this.f2358l, c0110ac.m711j(), c0110ac.m707f(), c0110ac.m709h().m1493d(), Integer.valueOf(c0110ac.m709h().m1495f()), Long.valueOf(c0110ac.m705d()), this.f2357k.length, this.f2354h);
                        if (iM1467d2 == 1001) {
                            String[] strArrSplit = strM1469f.substring(strM1469f.indexOf("[") + 1, strM1469f.indexOf("]")).trim().split(",");
                            StringBuilder sb = new StringBuilder();
                            for (String str : strArrSplit) {
                                if (C0670n.m3083a(this.f2360n, str, this.f2359m)) {
                                    String strM3091e = C0670n.m3091e(this.f2360n, this.f2359m, str);
                                    C1786r.m6063c("1001 error - invalidUserName:" + strM3091e, getClass().getSimpleName());
                                    sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0705t.LEAVE.m3171a()), str, C0493bg.m2684a(strM3091e))).append(";");
                                    C0670n.m3090d(this.f2360n, this.f2359m, str);
                                }
                            }
                            if (sb.length() > 0) {
                                C0665i.m3040a(this.f2360n, this.f2359m, sb.toString(), c0110ac.m711j(), C1789u.m6075a().getString("msisdn", ""));
                            }
                            C0660d.m3027b(this.f2360n, this.f2359m);
                        }
                        message.obj = new C0103d(true, iM1467d2);
                        break;
                    } else {
                        C0665i.m3049a(this.f2360n, Long.valueOf(this.f2240f));
                        message.obj = new C0103d(false, iM1467d2);
                        if (iM1467d2 == 6002 && this.f2355i == EnumC0695j.ONETOONE) {
                            C0660d.m3007a(this.f2360n, this.f2357k[0], C0670n.m3091e(this.f2360n, this.f2359m, this.f2357k[0]), c0110ac.m711j());
                            break;
                        }
                    }
                    break;
            }
            this.f2236b.sendMessage(message);
            return;
        }
        C1786r.m6063c("Fail to send message__", getClass().getSimpleName());
        if (this.f2239e >= f2235a || i == 11 || i == 22 || i == 3) {
            C0665i.m3049a(this.f2360n, Long.valueOf(this.f2240f));
            if (i == 24 || i == 23 || i == 21) {
                C0660d.m3031e(this.f2360n, this.f2359m);
            }
        }
        message.obj = new C0103d(false, i);
        this.f2236b.sendMessage(message);
    }
}
