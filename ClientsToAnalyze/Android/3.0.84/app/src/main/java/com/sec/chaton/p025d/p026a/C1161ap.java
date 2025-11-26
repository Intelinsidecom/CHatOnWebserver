package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.util.Log;
import com.sec.chaton.chat.C1077es;
import com.sec.chaton.p016a.C0310bg;
import com.sec.chaton.p016a.C0311bh;
import com.sec.chaton.p016a.C0312bi;
import com.sec.chaton.p016a.C0333cc;
import com.sec.chaton.p020c.C0822g;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p033i.p034a.C1534c;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1549ah;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.util.Iterator;

/* compiled from: DeliveryChatReplyTask.java */
/* renamed from: com.sec.chaton.d.a.ap */
/* loaded from: classes.dex */
public class C1161ap extends AbstractC1199c {

    /* renamed from: h */
    private String f4603h;

    /* renamed from: i */
    private C1077es f4604i;

    public C1161ap(Handler handler, String str, EnumC1450r enumC1450r, String str2) {
        super(handler);
        this.f4603h = str;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: b */
    protected C1548ag mo5504b() {
        this.f4604i = C1077es.m5329b(this.f4603h);
        C1534c c1534c = new C1534c();
        c1534c.m11829d(String.format("%04d%s", 7, "0001"));
        StringBuilder sb = new StringBuilder();
        C0311bh c0311bhM1800a = C0310bg.newBuilder().m1800a(C3159aa.m10962a().m10979a("uid", ""));
        Iterator<C0333cc> it = this.f4604i.m5334c().iterator();
        while (it.hasNext()) {
            C0333cc next = it.next();
            c0311bhM1800a.m1798a(C0312bi.newBuilder().m1839a(next.m2047h()).m1843a(next.m2043d()).m1842a(next.m2053n()).m1845b(C3159aa.m10962a().m10979a("chaton_id", "")).build());
            sb.append(next.m2047h()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        c1534c.m6525a(sb.toString());
        Log.wtf("CH", c1534c.toString());
        this.f4604i.m5330a();
        if (C3250y.f11735c) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < c0311bhM1800a.m1809f().size(); i++) {
                sb2.append("[" + i + "] Receiver : " + c0311bhM1800a.m1801a(i).m1828f()).append(", MsgType : " + c0311bhM1800a.m1801a(i).m1832j()).append(", MsgID : " + c0311bhM1800a.m1801a(i).m1830h()).append(", Sender : " + c0311bhM1800a.m1801a(i).m1826d());
            }
            C3250y.m11453c("ch@t[" + c0311bhM1800a.getClass().getSimpleName() + "]UID : " + C3159aa.m10962a().m10979a("uid", "") + ", DeliveryChatReplyItemsCount: " + c0311bhM1800a.m1810g() + sb2.toString(), getClass().getSimpleName());
        }
        return new C1549ah().m6579a(7).m6581a(c0311bhM1800a.build()).m6580a(C0822g.m4374c()).m6584b();
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1199c
    /* renamed from: a */
    protected void mo5502a(int i, Object obj, Object obj2) {
    }
}
