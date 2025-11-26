package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.C0161c;
import com.sec.chaton.p007a.C0179f;
import com.sec.chaton.p007a.C0180g;
import com.sec.chaton.p007a.EnumC0116ai;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0771ac;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;

/* compiled from: AllowChatTask.java */
/* renamed from: com.sec.chaton.d.a.f */
/* loaded from: classes.dex */
public class C0590f extends AbstractC0559b {

    /* renamed from: h */
    long f2337h;

    /* renamed from: i */
    EnumC0695j f2338i;

    /* renamed from: j */
    String f2339j;

    /* renamed from: k */
    String f2340k;

    /* renamed from: l */
    String f2341l;

    public C0590f(Handler handler, EnumC0695j enumC0695j, String str, String str2, long j, String str3) {
        super(handler);
        this.f2338i = enumC0695j;
        this.f2340k = str2;
        this.f2337h = j;
        this.f2339j = str3;
        this.f2341l = str;
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: c */
    protected C0770ab mo2748c() {
        C0180g c0180gNewBuilder = C0179f.newBuilder();
        c0180gNewBuilder.m1567a(this.f2337h).m1569a(EnumC0116ai.m813a(this.f2338i.m3146a())).m1573b(String.valueOf(this.f2340k)).m1577d(C1789u.m6075a().getString("uid", "")).m1579e(C1721ad.m5873a()).m1575c(C1789u.m6075a().getString("msisdn", ""));
        if (!TextUtils.isEmpty(this.f2339j)) {
            c0180gNewBuilder.m1571a(this.f2339j);
        }
        C1786r.m6063c("ch@t[" + c0180gNewBuilder.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", ChatType : " + c0180gNewBuilder.m1581g() + ", MsgID : " + c0180gNewBuilder.m1580f() + ", Receiver : " + c0180gNewBuilder.m1584j() + ", Sender : " + c0180gNewBuilder.m1583i() + ", SessionID : " + c0180gNewBuilder.m1582h(), getClass().getSimpleName());
        C0771ac c0771ac = new C0771ac();
        c0771ac.m3294a(2).m3296a(c0180gNewBuilder.build()).m3295a(30000L);
        return c0771ac.m3299b();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: a */
    protected void mo2747a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 2;
        if (obj2 != null) {
            C0161c c0161c = (C0161c) ((C0770ab) obj2).m3290c();
            C1786r.m6063c("ch@t[" + c0161c.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", MsgID : " + c0161c.m1358d() + ", ResultCode : " + c0161c.m1360f().m1467d() + ", ResultMsg : " + c0161c.m1360f().m1469f(), getClass().getSimpleName());
            int iM1467d = c0161c.m1360f().m1467d();
            if (iM1467d == 1000 || iM1467d == 3003) {
                message.obj = new C0103d(true, iM1467d, this.f2341l);
            } else {
                if (iM1467d == 2006 || iM1467d == 3008) {
                    C0660d.m3006a(GlobalApplication.m3260b().getContentResolver(), this.f2341l, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                }
                message.obj = new C0103d(false, iM1467d, this.f2341l);
            }
            this.f2236b.sendMessage(message);
            return;
        }
        if ((this.f2239e >= f2235a || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C0660d.m3031e(GlobalApplication.m3260b().getContentResolver(), this.f2341l);
        }
        C1786r.m6063c("Fail to send allowChat message", getClass().getSimpleName());
        message.obj = new C0103d(false, i, this.f2341l);
        this.f2236b.sendMessage(message);
    }
}
