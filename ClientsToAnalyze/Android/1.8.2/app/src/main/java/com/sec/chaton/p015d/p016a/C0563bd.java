package com.sec.chaton.p015d.p016a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.C0147bm;
import com.sec.chaton.p007a.C0150bp;
import com.sec.chaton.p007a.C0151bq;
import com.sec.chaton.p007a.EnumC0116ai;
import com.sec.chaton.p007a.EnumC0159by;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p017e.p018a.C0670n;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0771ac;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1735ar;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;

/* compiled from: InitChatRoomTask.java */
/* renamed from: com.sec.chaton.d.a.bd */
/* loaded from: classes.dex */
public class C0563bd extends AbstractC0559b {

    /* renamed from: h */
    private EnumC0699n f2247h;

    /* renamed from: i */
    private EnumC0695j f2248i;

    /* renamed from: j */
    private String[] f2249j;

    /* renamed from: k */
    private String f2250k;

    /* renamed from: l */
    private ContentResolver f2251l;

    /* renamed from: m */
    private String f2252m;

    /* renamed from: n */
    private String f2253n;

    public C0563bd(Handler handler, String str, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String[] strArr, String str2) {
        super(handler, 1);
        this.f2253n = "";
        this.f2240f = -1L;
        this.f2252m = str;
        this.f2247h = enumC0699n;
        this.f2248i = enumC0695j;
        this.f2249j = strArr;
        this.f2250k = str2;
        this.f2251l = GlobalApplication.m3260b().getContentResolver();
    }

    public C0563bd(Handler handler, String str, long j, EnumC0699n enumC0699n, EnumC0695j enumC0695j, String[] strArr, String str2) {
        super(handler, 1);
        this.f2253n = "";
        this.f2240f = j;
        this.f2252m = str;
        this.f2247h = enumC0699n;
        this.f2248i = enumC0695j;
        this.f2249j = strArr;
        this.f2250k = str2;
        this.f2251l = GlobalApplication.m3260b().getContentResolver();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: c */
    protected C0770ab mo2748c() {
        if (this.f2240f == -1) {
            this.f2240f = C1735ar.m5918a();
            C0665i.m3042a(this.f2251l, String.valueOf(this.f2240f), this.f2252m, this.f2247h, this.f2250k, this.f2249j.length);
        } else {
            C0665i.m3074c(this.f2251l, Long.valueOf(this.f2240f));
        }
        C0151bq c0151bqM1251e = C0150bp.newBuilder().m1237a(this.f2240f).m1241a(EnumC0159by.m1347a(this.f2247h.m3162a())).m1239a(EnumC0116ai.m813a(this.f2248i.m3146a())).m1242a(C1789u.m6075a().getString("uid", "")).m1245b(C1721ad.m5873a()).m1247c(C1789u.m6075a().getString("msisdn", "")).m1251e(this.f2250k);
        for (String str : this.f2249j) {
            c0151bqM1251e.m1249d(str);
            this.f2253n += " " + str;
        }
        C1786r.m6063c("InitChatRequest : InBoxNo=" + this.f2252m + " MsgID = " + this.f2240f + " ChatType = " + this.f2248i + " Receiver = " + this.f2253n + "ChatMsg = " + this.f2250k, getClass().getName());
        C1786r.m6063c("ch@t[" + c0151bqM1251e.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", InBoxNo : " + this.f2252m + ", ChatType : " + c0151bqM1251e.m1254h().getNumber() + ", MsgID : " + c0151bqM1251e.m1252f() + ", ChatMsg : " + c0151bqM1251e.m1257k() + ", Sender : " + c0151bqM1251e.m1255i() + ", Receivers : " + C1786r.m6049a(c0151bqM1251e.m1256j()), getClass().getSimpleName());
        return new C0771ac().m3294a(0).m3296a(c0151bqM1251e.build()).m3295a(30000L).m3299b();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: a */
    protected void mo2747a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 0;
        if (obj2 != null) {
            C0147bm c0147bm = (C0147bm) ((C0770ab) obj2).m3290c();
            C1786r.m6063c("ch@t[" + c0147bm.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", ResultCode : " + c0147bm.m1165l().m1467d() + ", ResultMessage : " + c0147bm.m1165l().m1469f() + ", InBoxNo : " + this.f2252m + ", MsgReceivedTime : " + c0147bm.m1161h() + ", MsgID : " + c0147bm.m1157d() + ", ServerInfo(address) : " + (c0147bm.m1163j() != null ? c0147bm.m1163j().m1493d() : "null(broadcast)") + ", ServerInfo(port) : " + (c0147bm.m1163j() != null ? Integer.valueOf(c0147bm.m1163j().m1495f()) : "null(broadcast)") + ", SessionID : " + c0147bm.m1159f(), getClass().getSimpleName());
            int iM1467d = c0147bm.m1165l().m1467d();
            String strM1469f = c0147bm.m1165l().m1469f();
            if (iM1467d == 1000 || iM1467d == 1001) {
                for (int length = this.f2249j.length - 1; length >= 0; length--) {
                    if (!C0670n.m3083a(this.f2251l, this.f2249j[length], this.f2252m)) {
                        C0670n.m3087c(this.f2251l, this.f2252m, this.f2249j[length]);
                    }
                }
                C0660d.m3011a(this.f2251l, this.f2252m, c0147bm, this.f2250k, this.f2248i, this.f2249j, this.f2247h);
                C0665i.m3053a(this.f2251l, Long.valueOf(c0147bm.m1161h()), c0147bm.m1159f(), c0147bm.m1157d(), Long.valueOf(this.f2240f), this.f2249j.length);
                if (iM1467d == 1001) {
                    String[] strArrSplit = strM1469f.substring(strM1469f.indexOf("[") + 1, strM1469f.indexOf("]")).trim().split(",");
                    ArrayList arrayList = new ArrayList();
                    for (String str : strArrSplit) {
                        String strM3091e = C0670n.m3091e(this.f2251l, this.f2252m, str);
                        C1786r.m6063c("1001 error - invalidUserName:" + strM3091e, getClass().getSimpleName());
                        arrayList.add(strM3091e);
                        C0670n.m3090d(this.f2251l, this.f2252m, str);
                    }
                    if (this.f2248i == EnumC0695j.BROADCAST) {
                        C0660d.m3028c(this.f2251l, this.f2252m);
                    } else {
                        C0660d.m3027b(this.f2251l, this.f2252m);
                    }
                    message.obj = new C0564be(this, true, c0147bm.m1159f(), iM1467d, arrayList);
                } else {
                    message.obj = new C0564be(this, true, c0147bm.m1159f(), iM1467d);
                }
            } else {
                message.obj = new C0103d(false, iM1467d);
                C1786r.m6063c("InitChatReply : InBoxNO = " + this.f2252m + ", InitChat Fail", getClass().getSimpleName());
                if (iM1467d == 3001 || iM1467d == 3002) {
                    C0665i.m3050a(this.f2251l, Long.valueOf(this.f2240f), Long.valueOf(C1735ar.m5918a()));
                } else {
                    C0665i.m3049a(this.f2251l, Long.valueOf(this.f2240f));
                }
            }
            this.f2236b.sendMessage(message);
            return;
        }
        if (this.f2239e >= f2235a || i == 11 || i == 22 || i == 3) {
            C0665i.m3049a(this.f2251l, Long.valueOf(this.f2240f));
            if (i == 24 || i == 23 || i == 21) {
                C0660d.m3031e(this.f2251l, this.f2252m);
            }
        }
        message.obj = new C0103d(false, i);
        this.f2236b.sendMessage(message);
        C1786r.m6063c("InitChatReply : InBoxNO = " + this.f2252m + ", InitChat Fail", getClass().getSimpleName());
    }
}
