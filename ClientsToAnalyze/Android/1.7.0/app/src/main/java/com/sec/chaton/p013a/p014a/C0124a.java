package com.sec.chaton.p013a.p014a;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.C0309bv;
import com.sec.chaton.p015b.C0348v;
import com.sec.chaton.p015b.C0352z;
import com.sec.chaton.p015b.EnumC0275ao;
import com.sec.chaton.p015b.p016a.C0257e;
import com.sec.chaton.p018c.C0507n;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0664q;
import com.sec.chaton.p025d.p026a.C0631k;
import com.sec.chaton.p025d.p026a.C0633m;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1325bu;
import com.sec.chaton.util.C1341p;

/* compiled from: InviteChatTask.java */
/* renamed from: com.sec.chaton.a.a.a */
/* loaded from: classes.dex */
public class C0124a extends AbstractC0164c {

    /* renamed from: h */
    private EnumC0651d f291h;

    /* renamed from: i */
    private String f292i;

    /* renamed from: j */
    private String[] f293j;

    /* renamed from: k */
    private String[] f294k;

    /* renamed from: l */
    private ContentResolver f295l;

    /* renamed from: m */
    private String f296m;

    public C0124a(Handler handler, EnumC0651d enumC0651d, String str, String[] strArr, String[] strArr2, String str2) {
        super(handler);
        this.f391f = -1L;
        this.f291h = enumC0651d;
        this.f292i = str;
        this.f293j = strArr;
        this.f294k = strArr2;
        this.f295l = GlobalApplication.m3100a().getContentResolver();
        this.f296m = str2;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected C0510q mo665a() {
        C1341p.m4660c("Request InviteChat", getClass().getSimpleName());
        if (this.f391f == -1) {
            this.f391f = C1325bu.m4591a();
        }
        C0309bv c0309bvNewBuilder = C0352z.newBuilder();
        c0309bvNewBuilder.m1572a(this.f391f).m1574a(EnumC0275ao.m1170a(this.f291h.m2978a())).m1576a(this.f292i).m1578b(C1323bs.m4575a().getString("msisdn", ""));
        for (String str : this.f293j) {
            c0309bvNewBuilder.m1579c(str);
        }
        for (String str2 : this.f294k) {
            c0309bvNewBuilder.m1581d(str2);
        }
        C1341p.m4660c("ch@t[" + c0309bvNewBuilder.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", InBoxNo : " + this.f296m + ", MsgID : " + c0309bvNewBuilder.m1584f() + ", InvitingMembersCount : " + c0309bvNewBuilder.m1589k() + ", InvitingMembersList : " + C1341p.m4646a(c0309bvNewBuilder.m1588j()) + ", Sender : " + c0309bvNewBuilder.m1585g() + ", ReceiverCount : " + c0309bvNewBuilder.m1587i() + ", ReceiversList : " + C1341p.m4646a(c0309bvNewBuilder.m1586h()), getClass().getSimpleName());
        C0507n c0507n = new C0507n();
        c0507n.m2558a(c0309bvNewBuilder.build()).m2556a(12).m2557a(30000L);
        return c0507n.m2561b();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected void mo666a(int i, Object obj, Object obj2) {
        Message message = new Message();
        message.what = 12;
        if (obj2 != null) {
            C0348v c0348v = (C0348v) ((C0510q) obj2).m2574c();
            C1341p.m4660c("ch@t[" + c0348v.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", ResultCode : " + c0348v.m2008f().m1626d() + ", ResultMessage : " + c0348v.m2008f().m1628f() + ", InBoxNo : " + this.f296m + ", ReceivedTime : " + String.valueOf(c0348v.m2010h()) + ", MsgID : " + c0348v.m2006d(), getClass().getSimpleName());
            int iM1626d = c0348v.m2008f().m1626d();
            if (iM1626d == 1000 || iM1626d == 1001 || iM1626d == 3005) {
                StringBuilder sb = new StringBuilder();
                for (String str : this.f294k) {
                    C0631k.m2868c(this.f295l, this.f296m, str);
                    sb.append(String.format("%d,%s,%s", Integer.valueOf(EnumC0664q.INVITE.m3010a()), str, C0520a.m2713a(C0633m.m2883a(this.f295l, str))));
                    sb.append(";");
                }
                C0635o.m2928a(this.f295l, this.f296m, sb.toString(), c0348v.m2010h(), C1323bs.m4575a().getString("msisdn", ""));
                C0634n.m2916f(this.f295l, this.f296m);
                C0634n.m2889a(this.f295l, this.f296m);
                message.obj = new C0257e(true, iM1626d);
            } else {
                message.obj = new C0257e(false, iM1626d);
            }
            this.f387b.sendMessage(message);
            return;
        }
        if ((!m703b() || i == 11 || i == 22 || i == 3) && (i == 24 || i == 23 || i == 21)) {
            C0634n.m2914d(this.f295l, this.f296m);
        }
        C1341p.m4660c("Result NULL", getClass().getSimpleName());
        message.obj = new C0257e(false, i);
        this.f387b.sendMessage(message);
    }
}
