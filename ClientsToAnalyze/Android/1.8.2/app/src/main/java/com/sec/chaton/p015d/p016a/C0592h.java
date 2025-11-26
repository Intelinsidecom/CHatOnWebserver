package com.sec.chaton.p015d.p016a;

import android.content.ContentResolver;
import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.C0188o;
import com.sec.chaton.p007a.C0191r;
import com.sec.chaton.p007a.C0192s;
import com.sec.chaton.p007a.C0194u;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0771ac;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.List;

/* compiled from: AnswerBackTask.java */
/* renamed from: com.sec.chaton.d.a.h */
/* loaded from: classes.dex */
public class C0592h extends AbstractC0559b {

    /* renamed from: h */
    private C0188o f2345h;

    /* renamed from: i */
    private Handler f2346i;

    /* renamed from: j */
    private List f2347j;

    /* renamed from: k */
    private ContentResolver f2348k;

    public C0592h(Handler handler, C0188o c0188o) {
        super(handler);
        this.f2346i = handler;
        this.f2345h = c0188o;
        this.f2348k = GlobalApplication.m3260b().getContentResolver();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: c */
    protected C0770ab mo2748c() {
        C0192s c0192sNewBuilder = C0191r.newBuilder();
        this.f2347j = this.f2345h.m1676c();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f2347j.size(); i++) {
            ((C0194u) this.f2347j.get(i)).m1744f();
            this.f2348k.update(C0698m.m3149a(String.valueOf(((C0194u) this.f2347j.get(i)).m1744f())), null, null, null);
            c0192sNewBuilder.m1721a((C0194u) this.f2347j.get(i));
        }
        for (int i2 = 0; i2 < this.f2345h.m1676c().size(); i2++) {
            sb.append("[" + i2 + "]MsgID = " + this.f2345h.m1674a(i2).m1744f()).append(", Receiver = " + this.f2345h.m1674a(i2).m1742d());
        }
        C1786r.m6063c("ch@t[" + this.f2345h.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", AnswerbackItemsCount : " + this.f2345h.m1677d() + ",Items : " + sb.toString(), getClass().getSimpleName());
        c0192sNewBuilder.m1722a(C1789u.m6075a().getString("uid", ""));
        StringBuilder sb2 = new StringBuilder();
        for (int i3 = 0; i3 < c0192sNewBuilder.m1729f().size(); i3++) {
            sb2.append("[" + i3 + "]MsgID = " + c0192sNewBuilder.m1723a(i3).m1744f()).append(", Receiver = " + c0192sNewBuilder.m1723a(i3).m1742d());
        }
        C1786r.m6063c("ch@t[" + c0192sNewBuilder.getClass().getSimpleName() + "]UID : " + C1789u.m6075a().getString("uid", "") + ", AnswerbackItemsCount : " + c0192sNewBuilder.m1730g() + ",Items : " + sb2.toString(), getClass().getSimpleName());
        C0771ac c0771ac = new C0771ac();
        c0771ac.m3296a(c0192sNewBuilder.build()).m3294a(11);
        return c0771ac.m3299b();
    }

    @Override // com.sec.chaton.p015d.p016a.AbstractC0559b
    /* renamed from: a */
    protected void mo2747a(int i, Object obj, Object obj2) {
    }
}
