package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.C0263ac;
import com.sec.chaton.p015b.C0295bh;
import com.sec.chaton.p015b.C0331e;
import com.sec.chaton.p015b.EnumC0323ci;
import com.sec.chaton.p015b.p016a.C0257e;
import com.sec.chaton.p018c.C0507n;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;

/* compiled from: AllowChatTask.java */
/* renamed from: com.sec.chaton.a.a.af */
/* loaded from: classes.dex */
public class C0130af extends AbstractC0164c {

    /* renamed from: h */
    long f310h;

    /* renamed from: i */
    EnumC0665r f311i;

    /* renamed from: j */
    String f312j;

    /* renamed from: k */
    String f313k;

    /* renamed from: l */
    String f314l;

    public C0130af(Handler handler, EnumC0665r enumC0665r, String str, String str2, long j, String str3) {
        super(handler);
        this.f311i = enumC0665r;
        this.f313k = str2;
        this.f310h = j;
        this.f312j = str3;
        this.f314l = str;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected C0510q mo665a() {
        C0295bh c0295bhNewBuilder = C0331e.newBuilder();
        c0295bhNewBuilder.m1322a(this.f310h).m1324a(EnumC0323ci.m1750a(this.f311i.m3012a())).m1328b(String.valueOf(this.f313k)).m1331d(C1323bs.m4575a().getString("uid", "")).m1333e(C1336k.m4621a()).m1329c(C1323bs.m4575a().getString("msisdn", ""));
        if (!TextUtils.isEmpty(this.f312j)) {
            c0295bhNewBuilder.m1326a(this.f312j);
        }
        C1341p.m4660c("ch@t[" + c0295bhNewBuilder.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", ChatType : " + c0295bhNewBuilder.m1336g() + ", MsgID : " + c0295bhNewBuilder.m1335f() + ", Receiver : " + c0295bhNewBuilder.m1339j() + ", Sender : " + c0295bhNewBuilder.m1338i() + ", SessionID : " + c0295bhNewBuilder.m1337h(), getClass().getSimpleName());
        C0507n c0507n = new C0507n();
        c0507n.m2556a(2).m2558a(c0295bhNewBuilder.build()).m2557a(30000L);
        return c0507n.m2561b();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected void mo666a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 2;
        if (obj2 != null) {
            C0263ac c0263ac = (C0263ac) ((C0510q) obj2).m2574c();
            C1341p.m4660c("ch@t[" + c0263ac.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", MsgID : " + c0263ac.m992d() + ", ResultCode : " + c0263ac.m994f().m1626d() + ", ResultMsg : " + c0263ac.m994f().m1628f(), getClass().getSimpleName());
            int iM1626d = c0263ac.m994f().m1626d();
            if (iM1626d == 1000 || iM1626d == 3003) {
                message.obj = new C0257e(true, iM1626d, this.f314l);
            } else {
                if (iM1626d == 2006 || iM1626d == 3008) {
                    C0634n.m2893a(GlobalApplication.m3100a().getContentResolver(), this.f314l, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                } else if (iM1626d == 3006) {
                }
                message.obj = new C0257e(false, iM1626d, this.f314l);
            }
            this.f387b.sendMessage(message);
            return;
        }
        if ((!m703b() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C0634n.m2914d(GlobalApplication.m3100a().getContentResolver(), this.f314l);
        }
        C1341p.m4660c("Fail to send allowChat message", getClass().getSimpleName());
        message.obj = new C0257e(false, i, this.f314l);
        this.f387b.sendMessage(message);
    }
}
