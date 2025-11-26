package com.sec.chaton.p013a.p014a;

import android.content.ContentResolver;
import android.os.Handler;
import com.sec.chaton.chat.C0585by;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.C0285ay;
import com.sec.chaton.p015b.C0315ca;
import com.sec.chaton.p015b.C0324cj;
import com.sec.chaton.p015b.C0329co;
import com.sec.chaton.p018c.C0507n;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.util.Iterator;

/* compiled from: DeliveryChatReplyTask.java */
/* renamed from: com.sec.chaton.a.a.ar */
/* loaded from: classes.dex */
public class C0142ar extends AbstractC0164c {

    /* renamed from: h */
    private String f346h;

    /* renamed from: i */
    private EnumC0665r f347i;

    /* renamed from: j */
    private String f348j;

    /* renamed from: k */
    private C0585by f349k;

    /* renamed from: l */
    private ContentResolver f350l;

    public C0142ar(Handler handler, String str, EnumC0665r enumC0665r, String str2) {
        super(handler);
        this.f346h = str;
        this.f347i = enumC0665r;
        this.f348j = str2;
        this.f350l = GlobalApplication.m3100a().getContentResolver();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected C0510q mo665a() {
        this.f349k = C0585by.m2770b(this.f346h);
        C0324cj c0324cjM1763a = C0315ca.newBuilder().m1763a(C1323bs.m4575a().getString("uid", ""));
        Iterator it = this.f349k.m2774c().iterator();
        while (it.hasNext()) {
            C0329co c0329co = (C0329co) it.next();
            c0324cjM1763a.m1760a(C0285ay.newBuilder().m1777a(c0329co.m1822h()).m1781a(c0329co.m1818d()).m1779a(c0329co.m1828n()).m1783b(C1323bs.m4575a().getString("msisdn", "")).build());
        }
        this.f349k.m2771a();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c0324cjM1763a.m1769f().size(); i++) {
            sb.append("[" + i + "] Receiver : " + c0324cjM1763a.m1757a(i).m1289f()).append(", MsgType : " + c0324cjM1763a.m1757a(i).m1293j()).append(", MsgID : " + c0324cjM1763a.m1757a(i).m1291h()).append(", Sender : " + c0324cjM1763a.m1757a(i).m1287d());
        }
        C1341p.m4660c("ch@t[" + c0324cjM1763a.getClass().getSimpleName() + "]UID : " + C1323bs.m4575a().getString("uid", "") + ", DeliveryChatReplyItemsCount: " + c0324cjM1763a.m1770g() + sb.toString(), getClass().getSimpleName());
        return new C0507n().m2556a(7).m2558a(c0324cjM1763a.build()).m2557a(30000L).m2561b();
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractC0164c
    /* renamed from: a */
    protected void mo666a(int i, Object obj, Object obj2) {
    }
}
