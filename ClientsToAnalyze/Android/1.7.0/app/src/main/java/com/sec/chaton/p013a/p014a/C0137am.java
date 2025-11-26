package com.sec.chaton.p013a.p014a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.C0263ac;
import com.sec.chaton.p015b.C0283aw;
import com.sec.chaton.p015b.C0295bh;
import com.sec.chaton.p015b.C0299bl;
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
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;

/* compiled from: ChatTask.java */
/* renamed from: com.sec.chaton.a.a.am */
/* loaded from: classes.dex */
public class C0137am extends AbstractC0164c {

    /* renamed from: h */
    private EnumC0651d f327h;

    /* renamed from: i */
    private EnumC0665r f328i;

    /* renamed from: j */
    private String f329j;

    /* renamed from: k */
    private String f330k;

    /* renamed from: l */
    private String f331l;

    /* renamed from: m */
    private String f332m;

    /* renamed from: n */
    private ContentResolver f333n;

    /* renamed from: o */
    private int f334o;

    public C0137am(Handler handler, long j, String str, EnumC0651d enumC0651d, EnumC0665r enumC0665r, String str2, String str3, String[] strArr) {
        super(handler, 1);
        this.f391f = j;
        this.f332m = str;
        this.f327h = enumC0651d;
        this.f329j = str2;
        this.f328i = enumC0665r;
        this.f331l = str3;
        this.f333n = GlobalApplication.m3100a().getContentResolver();
        if (strArr != null && strArr.length > 0) {
            this.f330k = strArr[0];
            this.f334o = strArr.length;
        } else {
            this.f330k = "";
            this.f334o = 0;
        }
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected C0510q mo665a() {
        if (!C0477ab.m2446a(this.f388c)) {
            C0634n.m2905a(this.f333n, this.f332m, this.f388c);
            long jM4591a = C1325bu.m4591a();
            C0295bh c0295bhNewBuilder = C0331e.newBuilder();
            c0295bhNewBuilder.m1322a(jM4591a).m1324a(EnumC0323ci.m1750a(this.f328i.m3012a())).m1331d(C1323bs.m4575a().getString("uid", "")).m1333e(C1336k.m4621a()).m1329c(C1323bs.m4575a().getString("msisdn", ""));
            if (TextUtils.isEmpty(this.f330k)) {
                c0295bhNewBuilder.m1328b(this.f332m);
            } else {
                c0295bhNewBuilder.m1328b(this.f330k);
            }
            if (!TextUtils.isEmpty(this.f329j)) {
                c0295bhNewBuilder.m1326a(this.f329j);
            }
            C1341p.m4660c("ch@t[AllowChatRequest]UID : " + C1323bs.m4575a().getString("uid", "") + ", ChatType : " + c0295bhNewBuilder.m1336g() + ", MsgID : " + c0295bhNewBuilder.m1335f() + ", Receiver : " + c0295bhNewBuilder.m1339j() + ", Sender : " + c0295bhNewBuilder.m1338i() + ", SessionID : " + c0295bhNewBuilder.m1337h(), getClass().getSimpleName());
            C0507n c0507n = new C0507n();
            c0507n.m2556a(2).m2558a(c0295bhNewBuilder.build()).m2557a(30000L);
            return c0507n.m2561b();
        }
        C0299bl c0299blM1397f = C0332f.newBuilder().m1382a(this.f391f).m1385a(EnumC0323ci.m1750a(this.f328i.m3012a())).m1387a(this.f329j).m1392d(C1323bs.m4575a().getString("uid", "")).m1394e(C1336k.m4621a()).m1389b(C1323bs.m4575a().getString("msisdn", "")).m1397f(this.f331l);
        if (this.f327h.m2978a() == 3) {
            c0299blM1397f.m1384a(EnumC0275ao.m1170a(1));
        } else {
            c0299blM1397f.m1384a(EnumC0275ao.m1170a(this.f327h.m2978a()));
        }
        c0299blM1397f.m1390c(this.f330k);
        C1341p.m4660c("ch@t[" + c0299blM1397f.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", InBoxNo : " + this.f332m + ", ChatMsg : " + c0299blM1397f.m1404l() + ", ChatType : " + c0299blM1397f.m1400h() + ", MsgID : " + c0299blM1397f.m1396f() + ", MsgType : " + c0299blM1397f.m1398g() + ", ReceiverList : " + C1341p.m4646a(c0299blM1397f.m1403k()) + ", Sender : " + c0299blM1397f.m1402j() + ", SessionID : " + c0299blM1397f.m1401i(), getClass().getSimpleName());
        return new C0507n().m2556a(4).m2558a(c0299blM1397f.build()).m2557a(5000L).m2561b();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected void mo666a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 4;
        if (obj2 != null) {
            C0510q c0510q = (C0510q) obj2;
            switch (c0510q.m2573b()) {
                case 3:
                    C0263ac c0263ac = (C0263ac) c0510q.m2574c();
                    C1341p.m4660c("ch@t[" + c0263ac.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", MsgID : " + c0263ac.m992d() + ", ResultCode : " + c0263ac.m994f().m1626d() + ", ResultMsg : " + c0263ac.m994f().m1628f(), getClass().getSimpleName());
                    int iM1626d = c0263ac.m994f().m1626d();
                    if (iM1626d == 1000 || iM1626d == 3003) {
                        message.obj = new C0257e(true, 10000, this.f332m, this.f391f);
                        break;
                    } else {
                        if (iM1626d == 2006 || iM1626d == 3008) {
                            C0634n.m2893a(GlobalApplication.m3100a().getContentResolver(), this.f332m, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                        } else {
                            C0635o.m2919a(this.f333n, Long.valueOf(this.f391f));
                        }
                        message.obj = new C0257e(false, iM1626d, this.f332m, this.f391f);
                        break;
                    }
                    break;
                case 5:
                    C0283aw c0283aw = (C0283aw) c0510q.m2574c();
                    C1341p.m4660c("ch@t[" + c0283aw.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", Msg ID : " + c0283aw.m1251d() + ", MsgReceivedTime : " + c0283aw.m1257j() + ", SessionID : " + c0283aw.m1253f() + ", ResultCode : " + c0283aw.m1259l().m1626d() + ", ResultMsg : " + c0283aw.m1259l().m1628f() + ", ServerInfo(address) : " + (c0283aw.m1255h() != null ? c0283aw.m1255h().m1559d() : "null") + ", ServerInfo(port) : " + (c0283aw.m1255h() != null ? Integer.valueOf(c0283aw.m1255h().m1561f()) : "null"), getClass().getSimpleName());
                    int iM1626d2 = c0283aw.m1259l().m1626d();
                    String strM1628f = c0283aw.m1259l().m1628f();
                    if (iM1626d2 == 1000 || iM1626d2 == 1001) {
                        C0635o.m2923a(this.f333n, Long.valueOf(c0283aw.m1257j()), c0283aw.m1253f(), c0283aw.m1251d(), Long.valueOf(this.f391f), this.f334o);
                        C0634n.m2895a(this.f333n, C1323bs.m4575a().getString("msisdn", ""), this.f332m, this.f331l, c0283aw.m1257j(), c0283aw.m1253f(), c0283aw.m1255h().m1559d(), Integer.valueOf(c0283aw.m1255h().m1561f()), Long.valueOf(c0283aw.m1251d()), this.f334o, this.f327h);
                        if (iM1626d2 == 1001) {
                            m681a(strM1628f.substring(strM1628f.indexOf("[") + 1, strM1628f.indexOf("]")).trim().split(","), c0283aw.m1257j());
                        }
                        message.obj = new C0257e(true, iM1626d2, this.f391f);
                        break;
                    } else {
                        C0635o.m2919a(this.f333n, Long.valueOf(this.f391f));
                        message.obj = new C0257e(false, iM1626d2, this.f391f);
                        if (iM1626d2 == 6002) {
                            if (this.f328i == EnumC0665r.ONETOONE) {
                                C0634n.m2894a(this.f333n, this.f330k, C0631k.m2872e(this.f333n, this.f332m, this.f330k), c0283aw.m1257j());
                                break;
                            } else {
                                m681a(C0631k.m2867b(this.f333n, this.f332m), c0283aw.m1257j());
                                break;
                            }
                        }
                    }
                    break;
            }
            this.f387b.sendMessage(message);
            return;
        }
        C1341p.m4660c("Fail to send message__", getClass().getSimpleName());
        if (!m703b() || i == 11 || i == 22 || i == 3) {
            C0635o.m2919a(this.f333n, Long.valueOf(this.f391f));
            if (i == 24 || i == 23 || i == 21) {
                C0634n.m2914d(this.f333n, this.f332m);
            }
        }
        message.obj = new C0257e(false, i, this.f391f);
        this.f387b.sendMessage(message);
    }

    /* renamed from: a */
    private void m681a(String[] strArr, long j) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (C0631k.m2864a(this.f333n, str, this.f332m)) {
                String strM2872e = C0631k.m2872e(this.f333n, this.f332m, str);
                C1341p.m4660c("1001 error - invalidUserName:" + strM2872e, getClass().getSimpleName());
                sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0664q.LEAVE.m3010a()), str, C0520a.m2713a(strM2872e))).append(";");
                C0631k.m2871d(this.f333n, this.f332m, str);
            }
        }
        if (sb.length() > 0) {
            C0635o.m2928a(this.f333n, this.f332m, sb.toString(), j, C1323bs.m4575a().getString("msisdn", ""));
            C0634n.m2916f(this.f333n, this.f332m);
            C0634n.m2889a(this.f333n, this.f332m);
        }
    }
}
